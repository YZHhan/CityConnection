package com.han.cityconnection.CityPart.HeardNews.contract;

import com.han.cityconnection.base.BaseView;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/9.
 */

public interface HeaderNewContract {

    interface HeaderView extends BaseView {
        //加载数据   需传入参数 参数为返回的JavaBean
        void setData();
    }

    interface HeaderPresenter {
        //将view层传入的地址在次转入到model层，获取网络数据
        void loadNetData(String url, Map<String, String> params);

    }
}