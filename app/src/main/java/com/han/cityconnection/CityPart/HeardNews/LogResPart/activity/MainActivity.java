package com.han.cityconnection.CityPart.HeardNews.LogResPart.activity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.han.cityconnection.App;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.Contract.Contract;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.ResBean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UserInfoBean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UserLogbean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UsergetCodebean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.entity.LogResPesnterImp;
import com.han.cityconnection.CityPart.HeardNews.fragment.TouTiaoFragment;
import com.han.cityconnection.R;
import com.han.cityconnection.base.BaseActivity;
import com.han.cityconnection.config.FragmentBuilder;
import com.han.cityconnection.config.Parameter;
import com.han.cityconnection.config.Urls;
import com.han.cityconnection.view.fragment.ZhaoPinFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by think on 2017/5/12.
 */

public class MainActivity extends BaseActivity implements View.OnClickListener,Contract.LogResView{
    private ImageView btn_back_login;
    private TextView button_user_login;
    private TextView textView_user_forget_pwd;
    private TextView textView_user_register;
    private ImageView imageView_share_login1;
    private ImageView imageView_share_login2;
    private ImageView imageView_share_login3;
    private ImageView imageView_share_login4;
    private ImageView eyes, uDel, pDel;
    private EditText editText_user_login_name;
    private EditText editText_user_login_pwd;
    private InputMethodManager imm; // 输入框管理器
    private String name;
    private String pwd;
    private LogResPesnterImp logResPesnterImp;



    @Override
    protected int getLayoutId() {
        return R.layout.username_login;
    }

    @Override
    protected void init() {
        logResPesnterImp=new LogResPesnterImp(this);
        btn_back_login = (ImageView) findViewById(R.id.btn_back_login);
        editText_user_login_name = (EditText) findViewById(R.id.editText_user_login_name);
        editText_user_login_pwd = (EditText) findViewById(R.id.editText_user_login_pwd);
        button_user_login = (TextView) findViewById(R.id.button_user_login);
        textView_user_forget_pwd = (TextView) findViewById(R.id.textView_user_forget_pwd);
        textView_user_register = (TextView) findViewById(R.id.textView_user_register);
        imageView_share_login1 = (ImageView) findViewById(R.id.submit1);
        imageView_share_login2 = (ImageView) findViewById(R.id.submit2);
        imageView_share_login3 = (ImageView) findViewById(R.id.submit3);
        imageView_share_login4 = (ImageView) findViewById(R.id.submit4);
        eyes = (ImageView) findViewById(R.id.eyes);
        uDel = (ImageView) findViewById(R.id.username_delete);
        pDel = (ImageView) findViewById(R.id.password_delete);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        // 加入点击事件
        btn_back_login.setOnClickListener(this);
        button_user_login.setOnClickListener(this);
        textView_user_forget_pwd.setOnClickListener(this);
        textView_user_register.setOnClickListener(this);
        imageView_share_login1.setOnClickListener(this);
        imageView_share_login2.setOnClickListener(this);
        imageView_share_login3.setOnClickListener(this);
        imageView_share_login4.setOnClickListener(this);
        editText_user_login_name.setOnClickListener(this);



    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back_login:
                finish();
                break;
            case R.id.button_user_login:
                name = editText_user_login_name.getText().toString().trim();
                pwd = editText_user_login_pwd.getText().toString().trim();
                if(name.equals("")){
                    editText_user_login_name.requestFocus();
                    editText_user_login_name.setFocusable(true);
                    editText_user_login_name.setFocusableInTouchMode(true);
                    imm.showSoftInput(editText_user_login_name, 0);
                    Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                }else if(pwd.equals("")){
                    editText_user_login_name.requestFocus();
                    editText_user_login_name.setFocusable(true);
                    editText_user_login_name.setFocusableInTouchMode(true);
                    imm.showSoftInput(editText_user_login_name, 0);
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }else if(name.length()<4){
                    editText_user_login_name.requestFocus();
                    editText_user_login_name.setFocusable(true);
                    editText_user_login_name.setFocusableInTouchMode(true);
                    imm.showSoftInput(editText_user_login_name, 0);
                    Toast.makeText(this, "用户名不正确", Toast.LENGTH_SHORT).show();
                }else if(pwd.length()<6){
                    editText_user_login_pwd.requestFocus();
                    editText_user_login_pwd.setFocusable(true);
                    editText_user_login_pwd.setFocusableInTouchMode(true);
                    imm.showSoftInput(editText_user_login_pwd, 0);
                    Toast.makeText(this, "输入的密码不正确", Toast.LENGTH_SHORT).show();
                }else{
                    // 关闭软键盘
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(
                            editText_user_login_pwd.getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    button_user_login.setText("登 录 中...");
                    String s = ReplyParams(name, pwd);
                    Log.i("xinxin",s);
                    Map<String,String> map=new HashMap<>();
                    map.put("param",s);
                    logResPesnterImp.senduserlog(Urls.APPURL,map);
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                    FragmentBuilder.getInstance().start(TouTiaoFragment.class).build();
                }
                break;
            case R.id.textView_user_forget_pwd:
                // 忘记密码
                Intent intent = new Intent(MainActivity.this, FindPasswrad.class);
                startActivity(intent);
                break;
            case R.id.textView_user_register:
                // 快速注册
                Intent intent1 = new Intent(MainActivity.this, QuickRegister.class);
                startActivityForResult(intent1, 0);
                break;
            case R.id.submit1:
                //短信注册
                Intent intent2 = new Intent(MainActivity.this, DuanxinLogin.class);
                startActivity(intent2);
                break;
            case R.id.submit2:
                // qq登录

                break;
            case R.id.submit3:
                // 微信登录

                break;
            case R.id.submit4:
                // 新浪微博调用授权

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
    // 用户直接登录
    private String ReplyParams(String username, String userpwd) {
        JSONObject jo = new JSONObject();
        try {
            jo.put("loginName", username);
            jo.put("userPWD", userpwd);
            jo.put("ip", "");
            jo.put("post", "8000");
            jo.put("version", "android 4.3");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String params = Parameter.createnewsParam(
                Urls.METHOD_CheckUserLogin, jo);
        return params;
    }
}
