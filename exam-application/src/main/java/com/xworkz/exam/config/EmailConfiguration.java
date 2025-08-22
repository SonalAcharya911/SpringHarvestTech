package com.xworkz.exam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfiguration {


    public JavaMailSenderImpl mailSender(){
        JavaMailSenderImpl javaMailSender=new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("sonalacharya911@gmail.com");
        javaMailSender.setPassword("zpeq ajmm xqef rbyl");
        Properties properties =javaMailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol","smtp");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        return javaMailSender;
    }
}
