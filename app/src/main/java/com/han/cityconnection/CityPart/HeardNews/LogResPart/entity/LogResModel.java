package com.han.cityconnection.CityPart.HeardNews.LogResPart.entity;

import com.han.cityconnection.model.http.NetWorkCallBack;

import java.util.Map;

/**
 * Created by think on 2017/5/15.
 */

public interface LogResModel {
    //注册主界面
    <T>void zhuce(String url, Map<String,String> params, NetWorkCallBack<T> callBack);
    //快速注册
    <T>void quickzhuce(String url, Map<String,String> params, NetWorkCallBack<T> callBack);
    //详细信息
    <T>void infozhuce(String url, Map<String,String> params, NetWorkCallBack<T> callBack);
    //直接登录
    <T>void userlogin(String url, Map<String,String> params, NetWorkCallBack<T> callBack);
    //获取验证码
    <T>void getcode(String url, Map<String,String> params, NetWorkCallBack<T> callBack);
}
