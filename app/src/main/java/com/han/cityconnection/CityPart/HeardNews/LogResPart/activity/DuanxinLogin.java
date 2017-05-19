package com.han.cityconnection.CityPart.HeardNews.LogResPart.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.han.cityconnection.R;

/**
 * Created by think on 2017/5/12.
 */

public class DuanxinLogin extends Activity implements View.OnClickListener{
    private ImageView btn_back_login;
    private TextView textView_user_verify;
    private EditText editText_user_login_name;
    private EditText editText_user_login_pwd;
    private Button button_user_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginandregister);
        btn_back_login = (ImageView) findViewById(R.id.btn_back_login);
        textView_user_verify = (TextView) findViewById(R.id.textView_user_verify);
        editText_user_login_name = (EditText) findViewById(R.id.editText_user_login_name);
        editText_user_login_pwd = (EditText) findViewById(R.id.editText_user_login_pwd);
        button_user_login = (Button) findViewById(R.id.button_user_login);

        btn_back_login.setOnClickListener(this);
        textView_user_verify.setOnClickListener(this);
        button_user_login.setOnClickListener(this);
        editText_user_login_name.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_login:
                break;
            case R.id.textView_user_verify:
                break;
            case R.id.button_user_login:
                break;
            case R.id.editText_user_login_name:
                break;
        }
    }
}
