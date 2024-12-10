package com.example.demo.api.configs;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {


    @Bean
    @ConditionalOnProperty(name = "my.feature.enabled", havingValue = "true")
    public String ThisIsMyFirstConditional(){
        return "this is My first condition";
    }


}
