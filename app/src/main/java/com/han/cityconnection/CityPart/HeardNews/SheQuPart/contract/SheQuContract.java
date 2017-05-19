package com.han.cityconnection.CityPart.HeardNews.SheQuPart.contract;

import com.han.cityconnection.CityPart.HeardNews.SheQuPart.bean.TabBean;
import com.han.cityconnection.base.BaseView;

import java.util.Map;

/**
 * Created by think on 2017/5/10.
 */

public interface SheQuContract {
    interface SheQuview extends BaseView{
        void senddata(TabBean tabBean);
    }
    interface SheQuPresenter {
        void loadNetData(String url, Map<String, String> params);
    }
}
