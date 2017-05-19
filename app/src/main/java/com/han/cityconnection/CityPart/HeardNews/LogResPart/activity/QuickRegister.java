package com.han.cityconnection.CityPart.HeardNews.LogResPart.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.Contract.Contract;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.ResBean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UserInfoBean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UserLogbean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.bean.UsergetCodebean;
import com.han.cityconnection.CityPart.HeardNews.LogResPart.entity.LogResPesnterImp;
import com.han.cityconnection.config.Parameter;
import com.han.cityconnection.config.Urls;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.han.cityconnection.App.context;

/**
 * Created by think on 2017/5/12.
 */

public class QuickRegister extends Activity implements View.OnClickListener,Contract.LogResView{
    private ImageView btn_back_login;
    private TextView textView_user_verify, cityname;
    private TextView tv_title_login;
    private EditText editText_user_login_name;
    private EditText editText_user_login_pwd;
    private Button button_user_login;
    private MyProgressDialog pDialog;
    private boolean falg = true;
    private boolean falgaa = true;
    private boolean flag = true;
    private int timer = 180;
    private Timer mytime;
    private String phonennumber;
    private int cityid;
    private String IP = "";
    private String userpwd;
    private LogResPesnterImp logResPesnterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginandregister);
        logResPesnterImp=new LogResPesnterImp(this);
        btn_back_login = (ImageView) findViewById(R.id.btn_back_login);
        textView_user_verify = (TextView) findViewById(R.id.textView_user_verify);
        tv_title_login = (TextView) findViewById(R.id.tv_title_login);
        editText_user_login_name = (EditText) findViewById(R.id.editText_user_login_name);
        editText_user_login_pwd = (EditText) findViewById(R.id.editText_user_login_pwd);
        button_user_login = (Button) findViewById(R.id.button_user_login);
        cityname = (TextView) findViewById(R.id.cityname);

        tv_title_login.setText("快速注册");
        button_user_login.setText("提交注册");

        btn_back_login.setOnClickListener(this);
        button_user_login.setOnClickListener(this);
        editText_user_login_name.setOnClickListener(this);
        textView_user_verify.setOnClickListener(this);
        pDialog = new MyProgressDialog(this, "短信发送中...");
    }
    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.textView_user_verify:
               phonennumber = editText_user_login_name.getText().toString().trim();
               if(!isMobileNO(phonennumber)){
                   editText_user_login_name.requestFocus();
                   editText_user_login_name.setFocusable(true);
                   editText_user_login_name.setFocusableInTouchMode(true);
                   Toast.makeText(this, "请输入正确的手机号~",
                           Toast.LENGTH_SHORT).show();
               }else{
                   boolean aaaaa = false;
                   if (Integer.valueOf(phonennumber.substring(0, 1)) == 1
                           && ((Integer.valueOf(phonennumber.substring(1, 2)) == 7)
                           || (Integer.valueOf(phonennumber.substring(1, 2)) == 3)
                           || (Integer.valueOf(phonennumber.substring(1, 2)) == 5) || (Integer
                           .valueOf(phonennumber.substring(1, 2)) == 8))) {
                       aaaaa = true;
                   }else{
                       Toast.makeText(this, "请输入正确的手机号~",Toast.LENGTH_SHORT).show();
                   }
                   if (falg && aaaaa) {
                       falg = false;
                       falgaa = true;
                       //String params = ReplyParams();
                       //manager.request(params, 0, 1);
                       pDialog.show();
                       // 做一个倒计时
                       mytime = new Timer();
                       mytime.schedule(new TimerTask() {
                           @Override
                           public void run() {
                               pDialog.dismiss();

                               if (!falgaa) {
                                   if (mytime != null) {
                                       mytime.cancel();
                                       timer = 180;
                                       falg = true;
                                       textView_user_verify.post(new Runnable() {
                                           @Override
                                           public void run() {
                                               textView_user_verify
                                                       .setBackgroundResource(R.drawable.getcode_select);
                                               textView_user_verify
                                                       .setText("获取验证码");
                                           }
                                       });
                                   }
                               } else {

                                   textView_user_verify.post(new Runnable() {
                                       @Override
                                       public void run() {
                                           textView_user_verify.setText("已发送"
                                                   + timer + "秒");
                                       }
                                   });
                                   if (timer == 0) {
                                       textView_user_verify.post(new Runnable() {
                                           @Override
                                           public void run() {
                                               textView_user_verify
                                                       .setBackgroundResource(R.drawable.getcode_select);
                                               textView_user_verify
                                                       .setText("重新获取");
                                           }
                                       });
                                       timer = 181;
                                       falg = true;
                                       mytime.cancel();
                                   }
                                   timer--;
                               }
                           }
                       }, 2000, 1000);
                   }else{
                       CustomToast.showToast(this, "请稍后再试~");
                   }
               }
               String s = ReplyParams(phonennumber);
               Map<String,String> map=new HashMap<>();
               map.put("param",s);
               logResPesnterImp.getcode(Urls.APPURL,map);
               break;
           case R.id.button_user_login:
               // 提交注册
               phonennumber = editText_user_login_name.getText().toString().trim();
               userpwd = editText_user_login_pwd.getText().toString().trim();
               if (phonennumber.equals("")) {
                   editText_user_login_name.requestFocus();
                   editText_user_login_name.setFocusable(true);
                   editText_user_login_name.setFocusableInTouchMode(true);
                   Toast.makeText(QuickRegister.this, "请输入手机号~",
                           Toast.LENGTH_SHORT).show();
               } else if (!isMobileNO(phonennumber)) {
                   editText_user_login_name.requestFocus();
                   editText_user_login_name.setFocusable(true);
                   editText_user_login_name.setFocusableInTouchMode(true);
                   Toast.makeText(QuickRegister.this, "请输入正确的手机号~",
                           Toast.LENGTH_SHORT).show();
               } else if (userpwd.equals("")) {
                   editText_user_login_pwd.requestFocus();
                   editText_user_login_pwd.setFocusable(true);
                   editText_user_login_pwd.setFocusableInTouchMode(true);
                   Toast.makeText(QuickRegister.this, "请输入收到的短信验证码~",
                           Toast.LENGTH_SHORT).show();
               } else if (phonennumber.length() < 6) {
                   editText_user_login_pwd.requestFocus();
                   editText_user_login_pwd.setFocusable(true);
                   editText_user_login_pwd.setFocusableInTouchMode(true);
                   Toast.makeText(QuickRegister.this, "验证码错误~", Toast.LENGTH_SHORT)
                           .show();
               } else {
                   if (flag) {
                       flag = false;
                       // 关闭软键盘
                       InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                       imm.hideSoftInputFromWindow(
                               editText_user_login_pwd.getWindowToken(),
                               InputMethodManager.HIDE_NOT_ALWAYS);
                        startActivity(new Intent(QuickRegister.this,SetPassword.class));
                   }
               }
               String s1 = ReplyParams1(phonennumber, userpwd);
               Map<String,String> map1=new HashMap<>();
               map1.put("param",s1);
               logResPesnterImp.loadNetData(Urls.APPURL,map1);
               if(phonennumber.equals("") || userpwd.equals("")){
                   Toast.makeText(this, "请填写收到的验证码", Toast.LENGTH_SHORT).show();
               }else{
                   startActivity(new Intent(QuickRegister.this,SetPassword.class));
               }

               break;
       }
    }
    // 用户获取验证码返回值
    private void parserResult(String result) {

        if (result != null) {
            try {
                JSONObject obj = new JSONObject(result);
                JSONObject object = obj.optJSONObject("MessageList");
                int getid = object.getInt("code");
                String usertishi = object.optString("message");
                if (getid != 0) {
                    switch (getid) {
                        case 1000:
                            pDialog.dismiss();
                            CustomToast.showToast(context, "验证码已发送~");
                            // 做一个倒计时
                            break;
                        default:
                            Toast.makeText(QuickRegister.this, usertishi,
                                    Toast.LENGTH_SHORT).show();
                            // pDialog.dismiss();
                            pDialog.dismiss();
                            falg = true;
                            if (mytime != null) {
                                mytime.cancel();
                                timer = 180;
                                falg = true;
                                textView_user_verify.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        textView_user_verify
                                                .setBackgroundResource(R.drawable.getcode_select);
                                        textView_user_verify.setText("获取验证码");
                                    }
                                });
                            }
                            break;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    // 用户注册验证码
    private String ReplyParams(String uesrname) {
        JSONObject jo = new JSONObject();
        try {
            jo.put("phone", uesrname);
            jo.put("siteID", 2422);
            jo.put("ip", IP);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String params = Parameter.createnewsParam(
                Urls.METHOD_SetRegSendCode, jo);
        return params;
    }
    // 用户手机注册
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
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^1[34578]\\d{9}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
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
    public void getcode(UsergetCodebean usergetCodebean){

    }
}
