package com.han.cityconnection.CityPart.HeardNews.LogResPart.Contract;

import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.ResBean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UserInfoBean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UserLogbean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UsergetCodebean;
import com.han.cityconnection.base.BaseView;

import java.util.Map;

/**
 * Created by think on 2017/5/12.
 */

public interface Contract {
    interface LogResView extends BaseView{
        void senddata(ResBean resBean);
        //个人信息详情
        void userinfo(UserInfoBean userInfoBean);
        //快速注册提交
        void useresign();
        //获取验证码
        void getcode(UsergetCodebean usergetCodebean);
        //登录
        void userlog(UserLogbean userLogbean);
    }
    interface LogResPresent{
        void loadNetData(String url, Map<String, String> params);
        void senduserinfo(String url, Map<String, String> params);
        void sendresign(String url, Map<String, String> params);
        void senduserlog(String url, Map<String, String> params);
        void getcode(String url, Map<String, String> params);
    }
}
