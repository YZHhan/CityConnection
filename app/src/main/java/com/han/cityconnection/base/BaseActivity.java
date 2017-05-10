package com.han.cityconnection.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.han.cityconnection.App;
import com.han.cityconnection.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.activity = this;
        //隐藏ActionBar
        getSupportActionBar().hide();
        init();
        initListener();
    }


    //加载布局
    protected abstract int getLayoutId();

    //初始化
    protected abstract void init();

    //初始化监听
    protected abstract void initListener();

    //加载数据
    protected abstract void loadData();

}
