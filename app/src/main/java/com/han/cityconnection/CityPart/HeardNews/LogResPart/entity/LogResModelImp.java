package com.han.cityconnection.CityPart.HeardNews.LogResPart.entity;

import com.han.cityconnection.model.http.NetWorkCallBack;
import com.han.cityconnection.model.http.VolleyHttp;

import java.util.Map;

/**
 * Created by think on 2017/5/15.
 */

public class LogResModelImp  implements LogResModel{
    private VolleyHttp volleyHttp;
    public LogResModelImp() {
        super();
        volleyHttp=VolleyHttp.getInstance();
    }
    @Override
    public <T> void zhuce(String url, Map<String, String> params, NetWorkCallBack<T> callBack) {
        volleyHttp.post(url,params,callBack);
    }

    @Override
    public <T> void quickzhuce(String url, Map<String, String> params, NetWorkCallBack<T> callBack) {
        volleyHttp.post(url,params,callBack);
    }

    @Override
    public <T> void infozhuce(String url, Map<String, String> params, NetWorkCallBack<T> callBack) {
        volleyHttp.post(url,params,callBack);
    }

    @Override
    public <T> void userlogin(String url, Map<String, String> params, NetWorkCallBack<T> callBack) {
        volleyHttp.post(url,params,callBack);
    }

    @Override
    public <T> void getcode(String url, Map<String, String> params, NetWorkCallBack<T> callBack) {
        volleyHttp.post(url,params,callBack);
    }
}
