package com.mvc.kgdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mvc.kgdemo.mapper") //扫描的mapper
@SpringBootApplication
public class KgdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KgdemoApplication.class, args);
    }

}
