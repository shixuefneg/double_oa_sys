package com.dou.serviceuser;

import org.apache.catalina.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author SunHaiLong
 * @date 2022/3/3 19:37
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.dou")
public class UserAppliction {

    public static void main(String[] args) {
        SpringApplication.run(UserAppliction.class,args);
    }
}
