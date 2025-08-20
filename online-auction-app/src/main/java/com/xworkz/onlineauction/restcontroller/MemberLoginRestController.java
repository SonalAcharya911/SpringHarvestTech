package com.xworkz.onlineauction.restcontroller;

import com.xworkz.onlineauction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MemberLoginRestController {

    @Autowired
    private AuctionService service;

    public MemberLoginRestController(){
        System.out.println("created MemberLoginRestController");
    }

    @GetMapping("loginemail")
    public String loginmailexist(@RequestParam("email")String email){
        System.out.println("calling loginemailexist in rest Controller");
        System.out.println("email: "+email);
        boolean result=service.checkEmailExist(email);
        if(result){
            System.out.println("email exists in RestController");
            return "email already exist. Cannot Register";
        }
        return "";
    }

    @GetMapping("contactExist")
    public String contactExist(@RequestParam("contact") Long contact){
        System.out.println("running contactExist in restController");
        System.out.println("contact: "+contact);

        boolean result=service.checkContactExist(contact);
        if(result){
            return "contact number exists";
        }
        return "contact number does not exist";
    }





}
