package com.dou.servicedept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author SunHaiLong
 * @date 2022/3/3 19:51
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.dou")
@EnableSwagger2
public class DeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptApplication.class,args);
    }
}
