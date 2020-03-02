package com.yinshenghao.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableDubboConfiguration
public class ProviderApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ProviderApplication.class, args);


    }

}
