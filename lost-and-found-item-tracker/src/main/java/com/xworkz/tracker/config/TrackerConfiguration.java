package com.xworkz.tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.xworkz.tracker")
public class TrackerConfiguration {
    public TrackerConfiguration(){
        System.out.println("created TrackerConfiguration...");
    }

    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".jsp");

        return internalResourceViewResolver;
    }
}
