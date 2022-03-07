package com.dou.servicenotice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author SunHaiLong
 * @date 2022/3/3 19:49
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.dou")
public class NoticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticeApplication.class,args);
    }
}
