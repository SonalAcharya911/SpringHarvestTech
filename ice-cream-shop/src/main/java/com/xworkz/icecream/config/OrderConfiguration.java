package com.xworkz.icecream.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.icecream")
public class OrderConfiguration {
    public OrderConfiguration(){
        System.out.println("created order configuration...");
    }

    @Bean
    public InternalResourceViewResolver registerInternalResourceViewResolver(){
        System.out.println("registering InternalResourceViewResolver with spring container");
        InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
}
