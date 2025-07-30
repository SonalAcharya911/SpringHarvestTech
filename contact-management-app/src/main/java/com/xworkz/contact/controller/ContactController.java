package com.xworkz.contact.controller;

import com.xworkz.contact.config.ContactConfiguration;
import com.xworkz.contact.dto.ContactDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ContactController {
    public ContactController(){
        System.out.println("created ContactController..");
    }

    @RequestMapping("/submit")
    public String onSubmit(ContactDTO contactDTO, Model model){
        System.out.println("running onSubmit in ContactController...");
        model.addAttribute("dto",contactDTO);
        return "Contact.jsp";
    }
}
