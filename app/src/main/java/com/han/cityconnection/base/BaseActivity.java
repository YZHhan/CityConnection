package com.han.cityconnection.base;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.han.cityconnection.App;
import com.han.cityconnection.R;

public abstract class BaseActivity extends AppCompatActivity {

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.activity = this;
        App.cityId=2482;
        //隐藏ActionBar
        getSupportActionBar().hide();
        init();
        initListener();
        loadData();
    }


    //加载布局
    protected abstract int getLayoutId();

    //初始化
    protected abstract void init();

    //初始化监听
    protected abstract void initListener();

    //加载数据
    protected abstract void loadData();
    public void showProgress() {
        dialog = new Dialog(this, R.style.dialog);
        dialog.setContentView(R.layout.layout_dialog);
        dialog.show();

    }

    public void diaProgress(){
        if (dialog != null && dialog.isShowing()==true) {
            dialog.dismiss();
            dialog=null;
        }
    }

}
