package com.yang.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


//放在tomcat里运行的启动方式需要继承SpringBootServletInitializer
@SpringBootApplication
public class CodeApplication extends SpringBootServletInitializer {

    //重写configure方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
        return springApplicationBuilder.sources(CodeApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(CodeApplication.class, args);
    }

}
