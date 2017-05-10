package com.han.cityconnection.model.http;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.han.cityconnection.config.Urls;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import static com.han.cityconnection.App.context;

/**
 * Created by Administrator on 2017/5/9.
 */

public class VolleyHttp  implements IHttp{

    RequestQueue requestQueue;
    private static VolleyHttp volleyHttp = null;
    private VolleyHttp() {
        super();
        requestQueue= Volley.newRequestQueue(context);
    }

    //单例模式的方法
    public synchronized static VolleyHttp getInstance(){
        if(volleyHttp == null) {
            volleyHttp = new VolleyHttp();
        }
        return volleyHttp;
    }


    //Post的请求
    @Override
    public <T> void post(String url, final Map<String, String> params, final NetWorkCallBack<T> callBack) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                  T  t = getGeneric(response, callBack);
                callBack.onSuccess(t);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }

    @Override
    public <T> void get(String url, Map<String, String> params, NetWorkCallBack<T> callBack) {

    }



    private <T> T getGeneric(String jsonData,NetWorkCallBack<T> callBack){
        Gson gson = new Gson();
        //通过反射获取泛型的实例
        Type[] types = callBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        T t = gson.fromJson(jsonData,actualTypeArguments[0]);
        return t;
    }

}
