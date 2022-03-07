package com.dou.servicerely.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Description Swagger配置类
 * @Date 2022/1/10 下午7:18
 */
@Configuration
@EnableSwagger2     //开启Swagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment){
        //获取项目的环境
        //1、设置（启动swagger的）环境（即使用哪个配置文件时）(这里配置了dev(开发)和test(测试)环境)
        Profiles profiles = Profiles.of("dev","test");
        //2、通过environment.acceptsProfiles(profiles)来 监听 判断是否处在自己设定的环境中;若在，会返回true，不在则返回false
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)   //是否启动swagger，默认true，即启动；若设为false，则swagger不能在浏览器访问
                .select()
                //.paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("pathwine","","");
        return new ApiInfo("网站-OA后台系统API文档",
                "本文档描述了OA后台系统微服务接口定义",
                "v1.0",
                "",
                contact,    //作者信息
                "",
                "",
                new ArrayList<>()
        );
    }
}
