package com.han.cityconnection.CityPart.HeardNews.SheQuPart.entity;

import com.han.cityconnection.CityPart.HeardNews.SheQuPart.bean.TabBean;
import com.han.cityconnection.CityPart.HeardNews.SheQuPart.contract.SheQuContract;
import com.han.cityconnection.CityPart.HeardNews.SheQuPart.fragment.SheQuFragment;
import com.han.cityconnection.base.BaseView;
import com.han.cityconnection.model.http.NetWorkCallBack;

import java.util.Map;

/**
 * Created by think on 2017/5/13.
 */

public class ShequParsenterImpl implements SheQuContract.SheQuPresenter {
    private SheQuFragment sheQuFragment;
    private IshequModel ishequModel;

    public ShequParsenterImpl(BaseView view) {
        super();
        this.sheQuFragment= (SheQuFragment) view;
        ishequModel=new IshequmodelImp();

    }

    @Override
    public void loadNetData(String url, Map<String, String> params) {
    ishequModel.getshequdata(url, params, new NetWorkCallBack<TabBean>() {
        @Override
        public void onSuccess(TabBean data) {
        sheQuFragment.senddata(data);
        }

        @Override
        public void onError(String errorMsg) {

        }
    });

    }
}
