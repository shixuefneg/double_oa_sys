package com.dou.serviceemployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author SunHaiLong
 * @date 2022/3/3 19:50
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.dou")
public class EmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpApplication.class,args);
    }
}
