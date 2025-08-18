package com.xworkz.onlineauction.controller;


import com.xworkz.onlineauction.dto.MemberDTO;
import com.xworkz.onlineauction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
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
        System.out.println("running saveIntoDatabase in Controller");
        if(dto!=null){
            boolean isSaved=service.validateAndSave(dto);
            if(isSaved){
                model.addAttribute("message","data saved into successfully");
            }
            else{
                model.addAttribute("message","couldn't save data");
            }
        }

        return "DataSavedSuccess";
    }
}
