package com.xworkz.onlineauction.controller;


import com.xworkz.onlineauction.dto.MemberDTO;
import com.xworkz.onlineauction.service.AuctionService;
import com.xworkz.onlineauction.util.OTPGenerator;
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
                model.addAttribute("email",dto.getEmail());
                model.addAttribute("message","data saved into successfully");
            }
            else{
                model.addAttribute("message","couldn't save data");
            }
        }

        return "EmailVerification";
    }

    @RequestMapping("sendMail")
    public String sendMail(@RequestParam("email") String email, Model model){
        System.out.println("running sendMail in Controller");
        System.out.println(email);
        String otp= OTPGenerator.generateNumericOTP(6);
        service.mailSend(email,otp);
        System.out.println("email sent");
        model.addAttribute("email", email);

        return "EmailVerification";
    }

    @GetMapping("verify")
    public void verifyOTP(String email, String otp, Model model){
        System.out.println("running verify in Controller");
        System.out.println("email: "+email+" otp: "+otp);
        boolean isVerified=service.verifyOTP(email,otp);
        if(isVerified){
            model.addAttribute("email",email);
        }
        else{
            model.addAttribute("message", "otp does not match");
        }
    }
    @PostMapping("savePassword")
    public String savePassword(MemberDTO dto, String password, String email){
        System.out.println("dto: "+dto+ " password: "+password+" email: "+email);
        service.savePassword(email, password);
        return "LoginForm";
    }

    @GetMapping("redirectToLogin")
    public String redirectToLogin(){
        System.out.println("running redirectToLogin in controller");
        return "LoginForm";
    }

    @GetMapping("logInToAccount")
    public String logInToAccount(String email, String password,  Model model){

        System.out.println("running logInToAccount in Controller");
        System.out.println("email: "+email+", password: "+password);
        MemberDTO dto=service.loginToAccount(email, password);
        model.addAttribute("username",dto.getName());

        return "UserHome";
    }
}
