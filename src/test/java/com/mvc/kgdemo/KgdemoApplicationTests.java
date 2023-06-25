package com.mvc.kgdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class KgdemoApplicationTests {

    @Test
    void contextLoads() {
    }



    @Test
    void testUuid(){
        System.out.println(UUID.randomUUID().toString());
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
    }

    @Test
    void timeFormat(){
//        SimpleDateFormat类的使用  是格式化日期格式的类 可以自定义日期的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
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
            parse = sdf.parse("2022-10-10 19:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("parse = " + parse);
        System.out.println("转化后的时间--> "+sdf.format(parse));
        

    }
}
