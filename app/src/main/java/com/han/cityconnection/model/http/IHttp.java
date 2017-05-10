package com.han.cityconnection.model.http;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/9.
 */

public interface IHttp {
    <T> void post(String url, Map<String,String> params, NetWorkCallBack<T> callBack);
    <T> void get(String url, Map<String,String> params, NetWorkCallBack<T>callBack);
}
