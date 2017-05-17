package com.han.cityconnection.CityPart.HeardNews.LogResPart.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.han.cityconnection.R;

/**
 * Created by think on 2017/5/16.
 */

public class SetPassword extends Activity implements View.OnClickListener{
    // UI组件
    private ImageView backText;
    private TextView titleText;
    private LinearLayout jumpLay;
    private EditText passEdit1, passEdit2;
    private Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpasswrad);
        backText = (ImageView) findViewById(R.id.btn_back_login);
        backText.setOnClickListener(this);
        titleText = (TextView) findViewById(R.id.tv_title_login);
        titleText.setVisibility(View.INVISIBLE);
        jumpLay = (LinearLayout) findViewById(R.id.jump_lay);
        jumpLay.setVisibility(View.VISIBLE);
        jumpLay.setOnClickListener(this);
        passEdit1 = (EditText) findViewById(R.id.editText_user_login_name);
        passEdit1.setHint("设置密码");
        passEdit2 = (EditText) findViewById(R.id.editText_user_login_pwd);
        passEdit2.setHint("确认密码");
        confirmBtn = (Button) findViewById(R.id.button_user_login);
        confirmBtn.setText("确定");
        confirmBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back_login:
                finish();
                break;
            case R.id.jump_lay:
                startActivity(new Intent(SetPassword.this,ResInfoActivity.class));
                break;
            case R.id.button_user_login:
                String pass1 = passEdit1.getText().toString()
                        .trim();
                String pass2 = passEdit2.getText().toString()
                        .trim();
                if (pass1.equals("")) {
                    getFocus(passEdit1, "请输入密码~");
                } else if (pass2.equals("")) {
                    getFocus(passEdit2, "请确认密码~");
                } else if (pass1.length() < 6) {
                    getFocus(passEdit1, "密码不能小于6位~");
                } else if (pass2.length() < 6) {
                    getFocus(passEdit2, "密码不能小于6位~");
                } else if (!pass1.equals(pass2)) {
                    CustomToast.showToast(this, "密码不一致~");
                } else {
                    // 关闭软键盘
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(
                            passEdit1.getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    startActivity(new Intent(SetPassword.this,ResInfoActivity.class));
                }
                break;
        }
    }
    //获取焦点并且进行提示
    public void getFocus(EditText e, String str) {
        e.requestFocus();
        e.setFocusable(true);
        e.setFocusableInTouchMode(true);
        CustomToast.showToast(this, str);
    }
}
