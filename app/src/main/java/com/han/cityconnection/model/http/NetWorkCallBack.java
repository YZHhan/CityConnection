package com.han.cityconnection.model.http;

import android.widget.TextView;

/**
 * Created by Administrator on 2017/5/8.
 */

public interface NetWorkCallBack<T> {

    //成功的回调
    void onSuccess(T data);


    //失败的回调
    void onError(String errorMsg);
}
