package com.han.cityconnection.persenteer.header;

import com.han.cityconnection.CityPart.HeardNews.Entity.BeiJingMsgList;
import com.han.cityconnection.CityPart.HeardNews.Entity.CityNewsInfoBean;
import com.han.cityconnection.CityPart.HeardNews.Entity.MainAddbean;
import com.han.cityconnection.CityPart.HeardNews.Entity.Photobean;
import com.han.cityconnection.CityPart.HeardNews.fragment.NewsInfoActivity;
import com.han.cityconnection.CityPart.HeardNews.fragment.imageloader.ImgsActivity;
import com.han.cityconnection.MainActivity;
import com.han.cityconnection.model.http.NetWorkCallBack;
import com.han.cityconnection.model.modelpart.headmodel.HeaderModelImpl;
import com.han.cityconnection.CityPart.HeardNews.contract.HeaderNewContract;
import com.han.cityconnection.CityPart.HeardNews.fragment.TouTiaoFragment;
import com.han.cityconnection.base.BaseView;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/10.
 */

public class HeaderParsenterImpl implements HeaderNewContract.HeaderPresenter {
    private TouTiaoFragment touTiaoFragment;
    private HeaderModelImpl headerModel;
    private NewsInfoActivity newsInfoActivity;
    private MainActivity mainActivity;
    private ImgsActivity imgsActivity;
    public HeaderParsenterImpl(BaseView baseView) {
        super();
        this.headerModel=new HeaderModelImpl();
        if(baseView instanceof HeaderNewContract.HeaderView){
            this.touTiaoFragment= (TouTiaoFragment) baseView;
        }else if(baseView instanceof HeaderNewContract.HeaderNewsView){
            this.newsInfoActivity= (NewsInfoActivity) baseView;
        }else if(baseView instanceof MainActivity){
            this.mainActivity= (MainActivity) baseView;
        }else if(baseView instanceof ImgsActivity){
            this.imgsActivity= (ImgsActivity) baseView;
        }
    }

    @Override
    public void loadNetData(String url, Map<String, String> params) {
        headerModel.getHeaderData(url, params, new NetWorkCallBack<BeiJingMsgList>() {
            @Override
            public void onSuccess(BeiJingMsgList data) {
                touTiaoFragment.setData(data);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void loadNewsData(String url, Map<String, String> params) {
        headerModel.getHeaderData(url, params, new NetWorkCallBack<CityNewsInfoBean>() {
            @Override
            public void onSuccess(CityNewsInfoBean data) {
                    newsInfoActivity.setData(data);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void loadgriddata(String url, Map<String, String> params) {
        headerModel.getaddgridData(url, params, new NetWorkCallBack<MainAddbean>() {
            @Override
            public void onSuccess(MainAddbean data) {
                mainActivity.getgrid(data);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void fabuphootos(String url, Map<String, String> params) {
        headerModel.getfabudData(url, params, new NetWorkCallBack<Photobean>() {
            @Override
            public void onSuccess(Photobean data) {
                imgsActivity.fabuphoto(data);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

}
