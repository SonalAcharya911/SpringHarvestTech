package com.xworkz.icecream.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.icecream")
public class OrderConfiguration {
    public OrderConfiguration(){
        System.out.println("created order configuration...");
    }
}
