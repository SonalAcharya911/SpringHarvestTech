package com.xworkz.passport.restcontroller;

import com.xworkz.passport.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserRegistrationRestController {

    @Autowired
    PassportService service;
    public UserRegistrationRestController(){
        System.out.println("created UserRegistrationRestController");
    }

//    @PostMapping("checkEmail")
//    public String checkEmailExist(String email, Model model){
//        System.out.println("running check email exist in rest Controller...");
//        boolean exists=service.checkEmailExist(email);
//        if(exists){
//            model.addAttribute("message","email already registered");
//        }
//        else{
//            model.addAttribute("message","email is not registered");
//        }
//        return "checkEmailPage";
//    }

    @GetMapping("loginemail")
    public String loginmailexist(@RequestParam("email")String email){
        System.out.println("calling loginemailexist in rest Controller");
        System.out.println("email: "+email);
        boolean result=service.checkEmailExist(email);
        if(result){
            return "email exist";
        }
        return "email does not exist! contact admin";
    }

    @GetMapping("loginIdexist")
    public String loginIdexist(@RequestParam("loginID") String loginID){
        System.out.println("running loginIdexist in rest controller");
        System.out.println("loginID: "+loginID);
        boolean result=service.checkloginIdExist(loginID);
        if(result){
            return "loginID already exists";
        }
        return "login id does not exist";
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
