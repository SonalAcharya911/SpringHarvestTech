package com.xworkz.tracker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.tracker")
public class TrackerConfiguration {
    public TrackerConfiguration(){
        System.out.println("created TrackerConfiguration...");
    }
}
