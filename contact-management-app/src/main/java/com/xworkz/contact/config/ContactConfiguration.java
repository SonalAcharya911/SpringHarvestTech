package com.xworkz.contact.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.contact")
public class ContactConfiguration {
    public ContactConfiguration(){
        System.out.println("created ContactConfiguration");
    }
}
