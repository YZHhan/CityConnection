package com.han.cityconnection.CityPart.HeardNews.LogResPart.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.han.cityconnection.*;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.Contract.Contract;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.ResBean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UserInfoBean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UserLogbean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UsergetCodebean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.entity.LogResPesnterImp;
import com.han.cityconnection.CityPart.HeardNews.fragment.TouTiaoFragment;
import com.han.cityconnection.config.FragmentBuilder;
import com.han.cityconnection.config.Parameter;
import com.han.cityconnection.config.Urls;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by think on 2017/5/16.
 */

public class ResInfoActivity extends Activity implements View.OnClickListener, Contract.LogResView {
    private ImageView manImage, womenImage, back, positionImage;
    private EditText nameEdit, addressEditText, birText;
    private TextView topTitle, bangdingTextView;
    private String sexFlag = "";
    private Button btn;
    private LogResPesnterImp logResPesnterImp;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_regist_info);
        logResPesnterImp = new LogResPesnterImp(this);
        btn = (Button) findViewById(R.id.submit_btn);
        btn.setOnClickListener(this);
        back = (ImageView) findViewById(R.id.back);
        birText = (EditText) findViewById(R.id.bir_text);
        nameEdit = (EditText) findViewById(R.id.name_edit);
        addressEditText = (EditText) findViewById(R.id.address_edit);
        positionImage = (ImageView) findViewById(R.id.position_image);
        manImage = (ImageView) findViewById(R.id.mansex_image);
        womenImage = (ImageView) findViewById(R.id.womansex_image);
        topTitle = (TextView) findViewById(R.id.top_title);
        bangdingTextView = (TextView) findViewById(R.id.bangding_textview);
        manImage.setOnClickListener(this);
        womenImage.setOnClickListener(this);
        positionImage.setOnClickListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mansex_image:
                manImage.setImageResource(R.drawable.regist_man_check);
                womenImage.setImageResource(R.drawable.regist_woman);
                sexFlag = "男";
                break;
            case R.id.womansex_image:
                manImage.setImageResource(R.drawable.regist_man);
                womenImage.setImageResource(R.drawable.regist_woman_check);
                sexFlag = "女";
                break;
            case R.id.submit_btn:
                if (nameEdit.getText().toString().trim().equals("")) {
                    nameEdit.requestFocus();
                    nameEdit.setFocusable(true);
                    nameEdit.setFocusableInTouchMode(true);
                    CustomToast.showToast(this, "请填写昵称~");
                    return;
                }

                if (nameEdit.getText().toString().length() < 2
                        || nameEdit.getText().toString().length() > 10) {
                    nameEdit.requestFocus();
                    nameEdit.setFocusable(true);
                    nameEdit.setFocusableInTouchMode(true);
                    CustomToast.showToast(this, "请正确设置昵称,2-10字内~");
                    return;
                }
                if (!sexFlag.equals("男") && !sexFlag.equals("女")) {
                    CustomToast.showToast(this, "请设置性别~");
                    return;
                }
                if (birText.getText().toString().trim().equals("")) {
                    CustomToast.showToast(this, "请填写你的生日信息~");
                    return;
                }
                if (addressEditText.getText().toString().trim().equals("")) {
                    addressEditText.requestFocus();
                    addressEditText.setFocusable(true);
                    addressEditText.setFocusableInTouchMode(true);
                    CustomToast.showToast(this, "居住地不能为空~");
                    return;
                }
                if (addressEditText.getText().toString().length() < 2
                        || addressEditText.getText().toString().length() > 12) {
                    addressEditText.requestFocus();
                    addressEditText.setFocusable(true);
                    addressEditText.setFocusableInTouchMode(true);
                    CustomToast.showToast(this, "请正确设置居住地,2-12字内~");
                    return;
                }
                String s = creatParams();
                Map<String, String> map = new HashMap<>();
                map.put("param", s);
                logResPesnterImp.senduserinfo(Urls.APPURL, map);
                startActivity(new Intent(ResInfoActivity.this, com.han.cityconnection.MainActivity.class));
                break;
        }
    }

    @Override
    public void senddata(ResBean resBean) {

    }

    @Override
    public void userinfo(UserInfoBean userInfoBean) {

    }

    @Override
    public void useresign() {

    }

    @Override
    public void userlog(UserLogbean userLogbean) {

    }

    @Override
    public void getcode(UsergetCodebean usergetCodebean) {

    }

    @Override
    public void showErrorImage() {

    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void turnVideoPlay() {

    }

    @Override
    public void turnDetailInfor() {

    }

    @Override
    public void LoadMore() {

    }

    @Override
    public void LoadRefresh() {

    }

    @Override
    public void showActionBarStyle() {

    }
    // 完善信息参数
    private String creatParams() {
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteID", 2422);
            jo.put("userName",nameEdit.getText().toString().trim());
            jo.put("userID", 0);
            jo.put("face", "");
            jo.put("nick", nameEdit.getText().toString().trim());
            jo.put("sex", sexFlag);
            jo.put("birthday", birText.getText().toString().trim());
            jo.put("lifeaddr", addressEditText.getText().toString().trim());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String params = Parameter.createnewsParam(
                Urls.PHSocket_SetAddUserBaseInfo, jo);
        return params;
    }
}
