package com.han.cityconnection.CityPart.HeardNews.SheQuPart.entity;

import com.han.cityconnection.model.http.NetWorkCallBack;

import java.util.Map;

/**
 * Created by think on 2017/5/13.
 */

public interface IshequModel {
    <T>void getshequdata(String url, Map<String,String> params, NetWorkCallBack<T> callBack);


}
