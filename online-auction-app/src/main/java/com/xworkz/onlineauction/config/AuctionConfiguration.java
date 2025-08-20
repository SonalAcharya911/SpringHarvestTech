package com.xworkz.onlineauction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.xworkz.onlineauction")
public class AuctionConfiguration {

    public AuctionConfiguration(){
        System.out.println("created AuctionConfiguration");
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        return new InternalResourceViewResolver("/",".jsp");
    }
}
