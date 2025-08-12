package com.xworkz.exhibition.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.xworkz.exhibition")
public class ArtExhibitionConfiguration {
    public ArtExhibitionConfiguration(){
        System.out.println("created ArtExhibitionConfiguration...");
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        return  new InternalResourceViewResolver("/",".jsp");
    }
}
