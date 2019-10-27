package com.example.demo123;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "example" ,autoRefreshed = true)
public class Demo123Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo123Application.class, args);
    }

}
