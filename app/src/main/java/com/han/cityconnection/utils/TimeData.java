package com.han.cityconnection.utils;

import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/5/10.
 */

public class TimeData {
    public static String dateFormat(long l) {// new Date().getTime()是当前的毫秒数

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        String date = df.format(l);// 将当前事件转换为指定格式的日期
        System.out.println(date);// 打印指定格式的日期
        return date;
    }
}
