package com.han.cityconnection.CityPart.HeardNews.LogResPart.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

//自定义时间的土司
public class CustomToast {
    private static Toast mToast;

    public static void clearToast() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
    }

    public static void showToast(Context context, String text, int s) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, s);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }

    public static void showToast(Context context, String text) {
        if (context == null || text == null || text.equals("")) {
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }

    public static void dismissToast() {
        if (mToast != null) mToast.cancel();
    }

    public static void showToastError1(Context context) {
        if (mToast == null) {
            mToast = Toast.makeText(context, "网络无法连接，请检查网络~", Toast.LENGTH_SHORT);
        } else {
            mToast.setText("网络无法连接，请检查网络~");
        }
        mToast.show();
    }

    public static void showToastError2(Context context) {
        if (mToast == null) {
            mToast = Toast.makeText(context, "网络连接异常，请稍后再试~", Toast.LENGTH_SHORT);
        } else {
            mToast.setText("网络连接异常，请稍后再试~");
        }
        mToast.show();
    }

    public static void showToastLogin(Context context) {
        Intent intentLogin = new Intent(context, MainActivity.class);
        context.startActivity(intentLogin);
    }

    public static void showToastUserIdError(Context context) {
        if (mToast == null) {
            mToast = Toast.makeText(context, "该用户不存在~", Toast.LENGTH_SHORT);
        } else {
            mToast.setText("该用户不存在~");
        }
        mToast.show();
    }

    public static void showLoad(Context context) {
        Toast.makeText(context, "正在载入，请稍后~~", Toast.LENGTH_SHORT).show();
    }

}