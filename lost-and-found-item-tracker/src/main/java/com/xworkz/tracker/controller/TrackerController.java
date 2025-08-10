package com.xworkz.tracker.controller;

import com.xworkz.tracker.dto.ItemDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class TrackerController {
    public TrackerController(){
        System.out.println("created TrackerController...");
    }

    @GetMapping("")
    public String redirectToLostAndFound(){
        System.out.println("redirecting to item lostAndFound");
        return "/lostAndFound.jsp";
    }

    public String onSubmit(ItemDTO dto, Model model){

        System.out.println(dto);
        if(dto!=null){

            boolean valid=false;
            if(valid){
                System.out.println("data is valid");
                System.out.println("Controller: "+dto);
                model.addAttribute("success","success");
                System.out.println("data saved into database");
            }
            else{
                System.out.println("validation gone wrong");
                model.addAttribute("error","data invalid...check console");
            }
        }
        model.addAttribute("dto",dto);
        return "/index.jsp";
    }
}
