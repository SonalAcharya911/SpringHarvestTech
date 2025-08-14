package com.xworkz.passport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.criteria.CriteriaBuilder;

@Configuration
@ComponentScan(basePackages = "com.xworkz.passport")
public class PassportSevaConfiguration {
    public PassportSevaConfiguration(){
        System.out.println("created PassportSevaConfiguration");
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        return new InternalResourceViewResolver("/",".jsp");
    }


}
