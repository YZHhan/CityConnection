package com.han.cityconnection.base;

/**
 * Created by Administrator on 2017/5/9.
 */

public interface BaseView {
    //当网络连接失败时，显示默认图片
    void showErrorImage();

    //当网络连接失败时，吐司“没有网络连接”
    void showErrorMsg(String msg);

    //网络慢时，显示加载进度条
    void showProgressDialog();

    //点击布局时，跳转到播放页面
    void turnVideoPlay();

    //点击布局时，跳转到H5详情页面
    void turnDetailInfor();

    //上拉加载
    void LoadMore();

    //下拉刷新
    void LoadRefresh();

    //显示隐藏ActionBar中的控件
    void showActionBarStyle();
}
