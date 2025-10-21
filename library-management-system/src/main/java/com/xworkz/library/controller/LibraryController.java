package com.xworkz.library.controller;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.service.LibraryService;
import com.xworkz.library.util.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class LibraryController {

    @Autowired
    LibraryService service;

    public LibraryController(){
        System.out.println("created LibraryController");
    }

    @GetMapping("redirectToLibraryForm")
    public String redirectToLibraryForm(){
        System.out.println("running redirectToLibraryForm in Controller");
        return "LibraryRegisterationForm";
    }

    @PostMapping("save")
    public String saveLibraryDetails(LibraryDTO dto, Model model){
        System.out.println("running saveLibraryDetails in Controller");
        System.out.println("dto in Controller: "+dto);
        String message=service.save(dto);
        model.addAttribute("message",message);
        List<LibraryDTO> dtoList=service.getAllLibraries();
        model.addAttribute("dtoList",dtoList);
        return "AllLibraries";
    }

    @GetMapping("fetchAll")
    public String fetchAll(Model model){
        System.out.println("running fetchAll in Controller");
        List<LibraryDTO> dtoList=service.getAllLibraries();
        model.addAttribute("dtoList",dtoList);
        return "AllLibraries";
    }

    @GetMapping("findByID")
    public String findByID(@RequestParam("id") Integer id, Model model){
        System.out.println("running findByID in Controller");
        LibraryDTO dto= service.findByID(id);
        model.addAttribute("dto",dto);
        return "AllLibraries";
    }

    @RequestMapping("deleteByID")
    public String deleteByID(@RequestParam("id") Integer id, Model model){
        System.out.println("running deleteByID in Controller");
        String message=service.deleteByID(id);
        model.addAttribute("message", message);
        List<LibraryDTO> dtoList=service.getAllLibraries();
        model.addAttribute("dtoList",dtoList);
        return "AllLibraries";
    }

    @GetMapping("edit")
    public String redirectToEdit(@RequestParam("id") Integer id, Model model){
        System.out.println("running redirect ti edit in Controller");
        LibraryDTO dto= service.findByID(id);
        model.addAttribute("dto",dto);
        return "EditLibraryForm";
    }

    @PostMapping("updateByID")
    public String updateByID(LibraryDTO dto, Model model){
        System.out.println("running updateByID in Controller");
        System.out.println("dto in controller: "+dto);
        String message=service.updateByID(dto);

        model.addAttribute("message",message);
        List<LibraryDTO> dtoList=service.getAllLibraries();
        model.addAttribute("dtoList",dtoList);
        return "AllLibraries";
    }

    @GetMapping("redirectToIndex")
    public String redirectToIndex(){
        System.out.println("running redirectToIndex");
        return "index";
    }


}
