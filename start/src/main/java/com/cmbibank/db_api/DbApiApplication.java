package com.cmbibank.db_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.cmbibank.db_api", "com.alibaba.cola" })
@MapperScan("com.cmbibank.db_api.gatewayimpl.database")
public class DbApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbApiApplication.class, args);
    }

}
