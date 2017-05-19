package com.han.cityconnection.model.headerMdel;

import com.han.cityconnection.model.http.NetWorkCallBack;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/10.
 */

public interface IHeaderModel {
    <T> void getHeaderData(String url, Map<String, String> map, NetWorkCallBack<T> callBack);
}
