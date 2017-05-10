package com.han.cityconnection.base;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.han.cityconnection.App;

/**
 * Created by Administrator on 2017/5/8.
 */

public abstract class BaseFragment extends Fragment {

    protected Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();
        initData();
    }

    /**
     * 加载布局
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化View控件
     */
    protected abstract void initView(View view);

    /**
     * 初始化数据（对象）
     */
    protected abstract void initData();

    /**
     * 初始化监听
     */
    protected abstract void initListener();

    /**
     * 加载数据
     */
    protected abstract void loadData();

    /**
     * 页面切切换传递数据
     * @param bundle
     */
    public void setParams(Bundle bundle){
        this.bundle = bundle;
    }

    /**
     * 当Fragment可见时，在此刷setParams新页面显示
     */
    protected void onShow(){
        App.lastFragment = this;
        String simpleName = App.lastFragment.getClass().getSimpleName();
        updateTitleBar();
    };

    /**
     * 当Fragment不可见时
     */
    protected void onHidden(){

    };

    /**
     * 更改标题内容
     */
    protected void updateTitleBar(){};

}
