package com.xworkz.passport.controller;

import com.xworkz.passport.config.PassportSevaConfiguration;
import com.xworkz.passport.dto.UserDTO;
import com.xworkz.passport.service.PassportService;
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
public class PassportController {

    @Autowired
    private PassportService service;

    public PassportController(){
        System.out.println("created PassportController");
    }

    @GetMapping("redirectToRegistration")
    public String redirectToRegistration(){
        System.out.println("redirecting to user registration...");
        return "UserRegistration";
    }

    @PostMapping("register")
    public String save(UserDTO dto, Model model){
        System.out.println("save in Controller: "+dto);
        boolean saved=service.save(dto);
        if(saved){
            System.out.println("saved into database");
            model.addAttribute("dto",dto);
            model.addAttribute("message","data saved");
        }
        return "UserRegistration";
    }

    @GetMapping("getAll")
    public String getAll(Model model){
        List<UserDTO> dtoList=service.getAll();
        System.out.println("Get All in Controller: ");
        dtoList.forEach(System.out::println);
        model.addAttribute("DTOList",dtoList);
        return "PassportList";
    }

    @GetMapping("getByID")
    public String getByID(Integer id, Model model){
        System.out.println("running getByID in Controller");
        UserDTO dto=service.findByID(id);
        System.out.println("dto in Controller: "+dto);
        model.addAttribute("dto",dto);
        return "PassportList";
    }

    @GetMapping("edit")
    public String redirectToEditPage(@RequestParam("id") String id, Model model){
        System.out.println("running redirectToEditPage, id= "+id);
        UserDTO dto=service.findByID(Integer.valueOf(id));
        System.out.println("dto in redirect to edit: "+dto);
        model.addAttribute("dto",dto);
        return "UpdatePassport";
    }

    @PostMapping("updatePassport")
    public String updatePassportDetails(UserDTO dto,Model model){
        System.out.println("running updatePassportDetails in Controller..., DTO: "+dto);
        String message=service.updatePassport(dto);
        model.addAttribute("message",message);
        List<UserDTO> dtoList=service.getAll();
        System.out.println("Get All in Controller: ");
        dtoList.forEach(System.out::println);
        model.addAttribute("DTOList",dtoList);
        return "PassportList";
    }
}
