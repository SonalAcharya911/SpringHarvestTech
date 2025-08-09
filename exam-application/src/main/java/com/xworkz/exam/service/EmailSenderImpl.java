package com.xworkz.exam.service;

import com.xworkz.exam.config.EmailConfiguration;
import com.xworkz.exam.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderImpl implements  EmailSender{

    @Autowired
    EmailConfiguration configuration;

    @Override
    public void mailSend(String email, String otp, StudentDTO dto) {
        System.out.println("Invoking mailSend ");
        SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Otp to login");
        simpleMailMessage.setText("Otp for login "+otp+"\n Name:"+dto.getName()+"\nCourse: "+dto.getCourse());

//        simpleMailMessage.setText("Course: "+dto.getCourse());
//        simpleMailMessage.setText("Branch"+dto.getBranch());
//        simpleMailMessage.setText("Stream: "+dto.getStream());
        configuration.mailSender().send(simpleMailMessage);
        System.out.println("Otp sent for :"+email+" : "+otp);
    }
}
