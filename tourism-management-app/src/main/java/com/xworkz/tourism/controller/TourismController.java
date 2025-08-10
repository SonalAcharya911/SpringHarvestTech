package com.xworkz.tourism.controller;

import com.xworkz.tourism.dto.TourismDTO;
import com.xworkz.tourism.service.TourismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TourismController {

    @Autowired
    TourismService service;

    public TourismController(){
        System.out.println("created TourismController");
    }

    @GetMapping("redirectToTourism")
    public String redirectToTourism(){
        System.out.println("redirecting to tourism.jsp");
        return "/tourism.jsp";
    }

    @PostMapping("saveData")
    public String saveData(TourismDTO dto, Model model){

        System.out.println(dto);
        boolean valid= service.saveTourism(dto);
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

        model.addAttribute("dto",dto);

        return "/tourism.jsp";
    }
}
