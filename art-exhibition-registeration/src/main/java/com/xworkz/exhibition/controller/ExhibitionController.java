package com.xworkz.exhibition.controller;

import com.xworkz.exhibition.dto.ArtDTO;
import com.xworkz.exhibition.service.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ExhibitionController {

    @Autowired
    private ArtService service;
    public ExhibitionController(){
        System.out.println("created ExhibitionController...");
    }

    @GetMapping("redirectToExhibitionRegistration")
    public String redirectToExhibitionRegisteration(){
        System.out.println("redirecting to registration form");
        return "RegistrationForm";
    }

    @PostMapping("register")
    public String onRegister(ArtDTO dto, Model model){

        service.save(dto);
        model.addAttribute("saved successfully");
        List<ArtDTO> dtoList=service.getAllArtworks();
        model.addAttribute("dtoList",dtoList);
        return "ArtworkList";
    }

    @GetMapping("getAllArtworks")
    public String getAllArtworks(Model model){
        List<ArtDTO> dtoList=service.getAllArtworks();
        model.addAttribute("dtoList",dtoList);
        return "ArtworkList";
    }

    @GetMapping("backToIndex")
    public String backToIndex(){
        return "index";
    }
}
