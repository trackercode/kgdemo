package com.mvc.kgdemo;

import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestClass {

    @Test
    void timeFormat(){
//        SimpleDateFormat类的使用  是格式化日期格式的类 可以自定义日期的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss z");
        // 实例化两个date
        java.util.Date date1 = new java.util.Date();  // 实例化后默认值为当前时间
        java.sql.Date date2 = new java.sql.Date(date1.getTime());
        System.out.println("date1 = " + date1);
        System.out.println("date1.getTime() = " + date1.getTime());
        System.out.println("date2 = " + date2);


        // 格式化日期  使用SimpleDateFormat的format（Date）  日期-->字符串
        String format = sdf.format(date1);
        System.out.println("format = " + format);

        // 解析   字符串-->date
        Date parse = null;
        try {
//            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//            parse = sdf.parse("2022-10-10 19:00:00 CST");
            parse = sdf.parse("2022-10-10 19:00:00 UTC");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("parse = " + parse);
        System.out.println("转化后的时间--> "+sdf.format(parse));

    }

    @Test
    void timeFormat2(){
        String date = "2022-10-10 19:00:00";
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.parse(date,formatter);
        System.out.println("localDateTime: "+localDateTime);
        long timeStamp = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println("timeStamp: "+timeStamp);
    }


    @Test
    void timeFormat3(){
        long seconds= 1665399600000L;
        String pattern = "yyyy-MM-dd HH:mm:ss";
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(seconds / 1000L, 0, ZoneOffset.ofHours(8));
        String time = dateTime.format(DateTimeFormatter.ofPattern(pattern));
        System.out.println("time: "+time);

    }

    @Test
    void timeFormat4(){
        String pattern = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.now();
        String str=formatter.format(localDateTime);
        System.out.println("queryBBQ: "+str);
    }

    @Test
    void getWebApi(){
//        OkHttpClient client = new OkHttpClient.Builder()
//                .connectTimeout(5000, TimeUnit.MILLISECONDS) //连接超时
//                .readTimeout(5000, TimeUnit.MILLISECONDS) //读取超时
//                .writeTimeout(5000, TimeUnit.MILLISECONDS) //写入超时
//                .sslSocketFactory(SSLSocketManager.getSSLSocketFactory())//配置（https请求才需要配置，http请求不用）
//                .hostnameVerifier(SSLSocketManager.getHostnameVerifier())//配置（https请求才需要配置，http请求不用）
////                .proxy(Proxy.NO_PROXY)
//                .build()
//
//        Response response =null;
//        try {
//            response = client.newCall(request).execute();
//            System.out.println("response: "+response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("response: "+response);
    }
}
