package com.xworkz.tourism.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.tourism")
public class TourismConfiguration {

    public TourismConfiguration(){
        System.out.println("created TourismConfiguration");
    }

}
