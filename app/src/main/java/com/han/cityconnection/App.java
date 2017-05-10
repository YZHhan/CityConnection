package com.han.cityconnection;

import android.app.Application;
import android.content.Context;

import com.han.cityconnection.base.BaseActivity;
import com.han.cityconnection.base.BaseFragment;

/**
 * Created by Administrator on 2017/5/8.
 */

public class App extends Application {
    public static String BANBEN = "Android " + android.os.Build.VERSION.RELEASE;
    public static String XINGHAO = android.os.Build.MODEL;
    public static String PHONEID="862380037036772";
    public static String PHONENUM="0";
    public static int cityId = 0;
    public static int userId = 0;
    public static BaseActivity activity;
    public static BaseFragment lastFragment;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context=this;
    }
}
