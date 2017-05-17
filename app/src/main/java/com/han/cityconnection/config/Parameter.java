package com.han.cityconnection.config;

import android.util.Log;

import com.han.cityconnection.App;
import com.han.cityconnection.utils.TimeData;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/9.
 */

public class Parameter {
    public static String version = "4.6";

//城市 详情的请求
    public static String createParam(String method, JSONObject params) {
        String time = TimeData.dateFormat(new Date().getTime());
        JSONObject pp = new JSONObject();
        try {
            pp.put("customerID", Urls.CUSTOMER_ID);
            pp.put("requestTime", time);
            pp.put("Method", method);
            pp.put("customerKey", encodeByMD5(Urls.CUSTOMER_KEY + method
                    + time));
            // pp.put("customerKey", Constants.CUSTOMER_KEY);
            pp.put("appName", Urls.APPNAME);
            pp.put("version", version);
            pp.put("Param", params);
            pp.put("Statis", createTongji());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pp.toString();
    }

    // 首页下载接口字符串
    public static String createnewsParam(String method, JSONObject params) {
        String time = TimeData.dateFormat(new Date().getTime());
        JSONObject pp = new JSONObject();
        try {
            pp.put("customerID", Urls.CUSTOMER_ID);
            pp.put("requestTime",time);
            pp.put("Method", method);
            pp.put("customerKey", encodeByMD5(Urls.CUSTOMER_KEY + method
                    + time));
            // pp.put("customerKey", Urls.CUSTOMER_KEY);
            pp.put("appName", Urls.APPNAME);
            pp.put("version", version);
            pp.put("Param", params);
            pp.put("Statis", createTongji());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("qqqqqqqqq", pp.toString());
        return pp.toString();
    }

    // 统计接口字符串
    public static JSONObject createTongji() {
        JSONObject pp = new JSONObject();
        try {
            pp.put("SiteId", App.cityId);//先写一个死的
            pp.put("UserId", App.userId);
            pp.put("PhoneNo", App.XINGHAO);
            pp.put("SystemNo", 2);
            pp.put("System_VersionNo", App.BANBEN);
            pp.put("PhoneId", App.PHONEID);
            pp.put("PhoneNum", App.PHONENUM);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pp;
    }

    /** 对字符串进行MD5加密 */
    public static String encodeByMD5(String originString) {
        if (originString != null) {
            try {
                // 创建具有指定算法名称的信息摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                // 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md.digest(originString.getBytes());
                // 将得到的字节数组变成字符串返回
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /** 将一个字节转化成十六进制形式的字符串 */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    // 十六进制下数字到字符的映射数组
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
}
