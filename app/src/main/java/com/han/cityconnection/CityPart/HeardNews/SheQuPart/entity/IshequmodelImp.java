package com.han.cityconnection.CityPart.HeardNews.SheQuPart.entity;

import com.han.cityconnection.model.http.NetWorkCallBack;
import com.han.cityconnection.model.http.VolleyHttp;

import java.util.Map;

/**
 * Created by think on 2017/5/13.
 */

public class IshequmodelImp implements IshequModel {
    private VolleyHttp volleyHttp;
    public IshequmodelImp() {
        super();
        volleyHttp=VolleyHttp.getInstance();
    }

    @Override
    public <T> void getshequdata(String url, Map<String,String> params, NetWorkCallBack<T> callBack) {
        volleyHttp.post(url,params,callBack);
    }
}
