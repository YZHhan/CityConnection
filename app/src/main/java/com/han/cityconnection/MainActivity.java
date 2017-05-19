package com.han.cityconnection;

import android.view.View;
import android.widget.RadioButton;

import com.han.cityconnection.base.BaseActivity;
import com.han.cityconnection.view.fragment.FanChanFragment;
import com.han.cityconnection.view.fragment.FoundFragment;
import com.han.cityconnection.view.fragment.SheQuFragment;
import com.han.cityconnection.CityPart.HeardNews.fragment.TouTiaoFragment;
import com.han.cityconnection.view.fragment.ZhaoPinFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RadioButton toutioButton;
    private RadioButton shequButton;
    private RadioButton zhaopinButton;
    private RadioButton fangchanButton;
    private RadioButton foundButton;

//        String params4 = ReplyParams("15650714120");
//        Log.d("abcabc1", params4);
//        String params1 = "param="
//                + params4.replace(
//                "+6Hp9X5zR39SOI6oP0685Bk77gG56m7PkV89xYvl86A=",
//                "%2b6Hp9X5zR39SOI6oP0685Bk77gG56m7PkV89xYvl86A=");
////        Log.d("abcabc2", params1);
//
//
//        String replyParams1 = ReplyParams1("15650714120", "620656");
////        Log.d("abcabc3", replyParams1);
//
//        String replyParams = ReplyParams();
////        Log.d("abc4", replyParams);


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        FragmentBuilder.getInstance().start(TouTiaoFragment.class).build();
        toutioButton = (RadioButton) findViewById(R.id.main_toutiaoBtn);
        shequButton = (RadioButton) findViewById(R.id.main_shequBtn);
        zhaopinButton = (RadioButton) findViewById(R.id.main_zhaopinBtn);
        fangchanButton = (RadioButton) findViewById(R.id.main_fangchanBtn);
        foundButton = (RadioButton) findViewById(R.id.main_foundBtn);


    }

    @Override
    protected void initListener() {
        toutioButton.setOnClickListener(this);
        shequButton.setOnClickListener(this);
        zhaopinButton.setOnClickListener(this);
        fangchanButton.setOnClickListener(this);
        foundButton.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
//        FragmentBuilder.getInstance().start(TouTiaoFragment.class).build();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_toutiaoBtn:
                FragmentBuilder.getInstance().start(TouTiaoFragment.class).build();
                break;

            case R.id.main_shequBtn:
                FragmentBuilder.getInstance().start(SheQuFragment.class).build();
                break;
            case R.id.main_zhaopinBtn:
                FragmentBuilder.getInstance().start(ZhaoPinFragment.class).build();
                break;
            case R.id.main_fangchanBtn:
                FragmentBuilder.getInstance().start(FanChanFragment.class).build();
                break;
            case R.id.main_foundBtn:
                FragmentBuilder.getInstance().start(FoundFragment.class).build();
                break;

        }
    }

    private String ReplyParams(String username) {
        JSONObject jo = new JSONObject();
        try {
            jo.put("phone", username);
            jo.put("siteID", "2482");
            jo.put("ip", "115.171.30.103");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //————需要进行  一些改造
        final String params = Parameter.createnewsParam(
                Urls.METHOD_SetRegSendCode, jo);
        return params;
    }


    private String ReplyParams1(String username, String userpwd) {
        JSONObject jo = new JSONObject();
        try {
            jo.put("phone", username);// 手机号
            jo.put("authKey", userpwd);// 短信验证码
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String params = Parameter.createnewsParam(
                Urls.PHSocket_GetPhoneRegCodeCheck, jo);
        return params;
    }


    /**
     * @return
     */
    private String ReplyParams() {
        JSONObject jo = new JSONObject();
        JSONObject jo1 = new JSONObject();
        try {
            jo.put("RoleIMG", "data/site");
            jo.put("SiteID", "2482");
            jo.put("RoleName", "尹自含");
            jo.put("lifeaddr", "北京吉利大学");
            jo.put("sex", "男");
            jo.put("birthday", "1993_01_20");
//            if (getIntent().getStringExtra("client_flag") != null && !getIntent().getStringExtra("client_flag").equals("")) {//客户端过来
//                jo.put("Tel", "");
//                jo.put("UserPWD", "");
//                if (getIntent().getStringExtra("client_flag").equals("qq")) {
//                    jo.put("OType", 2);
//                    jo.put("QQOpenID", getIntent().getStringExtra("client_id"));//qqid
//                } else if (getIntent().getStringExtra("client_flag").equals("weixin")) {
//                    jo.put("OType", 4);
//                    jo.put("openID", getIntent().getStringExtra("client_id"));//微信id
//                    jo.put("weixin", "weixin@ccoo.cn");
//                } else {
//                    jo.put("OType", 3);
//                    jo.put("WeiboID", getIntent().getStringExtra("client_id"));//微博id
//                }
//            } else {
            jo.put("OType", 5);
            jo.put("Tel", "15650714120");
            jo.put("UserPWD", "qwert12345");
//            }
            jo1.put("InUser", jo);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String params = Parameter.createnewsParam(
                Urls.METHOD_SetRegUserInfo, jo1);
        return params;
    }


}
