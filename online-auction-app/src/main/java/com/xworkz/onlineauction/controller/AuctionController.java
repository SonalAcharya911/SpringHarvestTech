package com.xworkz.onlineauction.controller;


import com.xworkz.onlineauction.dto.MemberDTO;
import com.xworkz.onlineauction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class AuctionController {

    @Autowired
    private AuctionService service;


    public AuctionController(){
        System.out.println("created AuctionController...");
    }

    @GetMapping("redirectToIndex")
    public String redirectToIndex(){
        System.out.println("running redirectToIndex in Controller");
        return "index";
    }

    @GetMapping("redirectToMemberRegistrationForm")
    public String redirectToMemberForm(){
        System.out.println("running redirectToMemberForm in Controller");
        return "MemberRegistrationForm";
    }

    @PostMapping("save")
    public String saveIntoDatabase(MemberDTO dto, Model model){
        System.out.println("running saveIntoDatabase in Controller, dto: "+dto);
        if(dto!=null){
            boolean isSaved=service.validateAndSave(dto);
            if(isSaved){
                model.addAttribute("dto",dto);
                model.addAttribute("message","data saved into successfully");
            }
            else{
                model.addAttribute("message","couldn't save data");
            }
        }

        return "EmailVerification";
    }

    @GetMapping("redirectToLogin")
    public String redirectToLogin(){
        System.out.println("running redirectToLogin in controller");
        return "LoginForm";
    }

    @RequestMapping("sendMail")
    public String sendMail(@RequestParam("email") String email){
        System.out.println("running sendMail in Controller");
        System.out.println(email);
        service.mailSend(email,"1234");
        System.out.println("email sent");
        return "LoginForm";
    }

    @GetMapping("verify")
    public String verifyOTP(String email, String otp){
        return "";
    }

}
