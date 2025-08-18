package com.xworkz.exhibition.controller;

import com.xworkz.exhibition.dto.ArtDTO;
import com.xworkz.exhibition.service.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("findByID")
    public String findByID(Integer id,Model model){
        System.out.println("running findByID in controller");
        ArtDTO dto=service.findByID(id);
        System.out.println("dto: "+dto);
        model.addAttribute("dto",dto);
        return "ArtworkList";
    }

    @GetMapping("edit")
    public String redirectToUpdate(@RequestParam("id") String id, Model model){
        System.out.println("running redirectToUpdate in Controller, id"+id);
        ArtDTO dto=service.findByID(Integer.valueOf(id));
        model.addAttribute("dto",dto);
        return "UpdateArtworkDetails";
    }

    @PostMapping("updateArtwork")
    public String updateArtwork(ArtDTO dto, Model model){
        System.out.println("running updateArtwork in Controller, Dto: "+dto);
        String message=service.updateArtwork(dto);
        model.addAttribute("message",message);
        List<ArtDTO> dtoList=service.getAllArtworks();
        model.addAttribute("dtoList",dtoList);
        return "ArtworkList";
    }

    @GetMapping("delete")
    public String deleteArtwork(@RequestParam("id") Integer id,Model model){
        System.out.println("running deleteArtwork in Controller");
        String message=service.deleteArtwork(id);
        model.addAttribute("message",message);
        List<ArtDTO> dtoList=service.getAllArtworks();
        model.addAttribute("dtoList",dtoList);
        return "ArtworkList";
    }

}
