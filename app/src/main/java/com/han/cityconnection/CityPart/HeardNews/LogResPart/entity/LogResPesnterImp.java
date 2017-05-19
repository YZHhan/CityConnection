package com.han.cityconnection.CityPart.HeardNews.LogResPart.entity;

import com.han.cityconnection.CityPart.HeardNews.LogResPart.Contract.Contract;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.activity.MainActivity;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.activity.QuickRegister;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.activity.ResInfoActivity;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.ResBean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UserInfoBean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UserLogbean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UsergetCodebean;
import com.han.cityconnection.base.BaseView;
import com.han.cityconnection.model.http.NetWorkCallBack;

import java.util.Map;

/**
 * Created by think on 2017/5/15.
 */

public class LogResPesnterImp implements Contract.LogResPresent{
    private QuickRegister quickRegister;
    private ResInfoActivity resInfoActivity;
    private MainActivity mainActivity;
    private LogResModel logResModel;

    public LogResPesnterImp(BaseView view) {
       super();
        if(view instanceof QuickRegister) {
            this.quickRegister = (QuickRegister) view;
        }else if(view instanceof ResInfoActivity){
            this.resInfoActivity= (ResInfoActivity) view;
        }else if(view instanceof MainActivity){
            this.mainActivity= (MainActivity) view;
        }
        this.logResModel=new LogResModelImp();
    }

    @Override
    public void loadNetData(String url, Map<String, String> params) {
    logResModel.zhuce(url, params, new NetWorkCallBack<ResBean>() {
        @Override
        public void onSuccess(ResBean data) {
            quickRegister.senddata(data);
        }

        @Override
        public void onError(String errorMsg) {

        }
    });
    }

    @Override
    public void senduserinfo(String url, Map<String, String> params) {
        logResModel.infozhuce(url, params, new NetWorkCallBack<UserInfoBean>() {
            @Override
            public void onSuccess(UserInfoBean data) {
           resInfoActivity.userinfo(data);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void sendresign(String url, Map<String, String> params) {

    }

    @Override
    public void senduserlog(String url, Map<String, String> params) {
        logResModel.userlogin(url, params, new NetWorkCallBack<UserLogbean>() {
            @Override
            public void onSuccess(UserLogbean data) {
                mainActivity.userlog(data);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void getcode(final String url, Map<String, String> params) {
        logResModel.getcode(url, params, new NetWorkCallBack<UsergetCodebean>() {
            @Override
            public void onSuccess(UsergetCodebean data) {
                quickRegister.getcode(data);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
