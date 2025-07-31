package com.xworkz.contact.controller;

import com.xworkz.contact.dto.ContactDTO;
import com.xworkz.contact.service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ContactController {
    @Autowired
    ContactServiceImpl contactServiceImpl;

    public ContactController(){
        System.out.println("created ContactController..");
    }

    @RequestMapping("/submit")
    public String onSubmit(ContactDTO contactDTO, Model model){
        System.out.println("running onSubmit in ContactController...");
        model.addAttribute("dto",contactDTO);

        System.out.println(contactDTO+" dto...........");

        boolean valid= contactServiceImpl.validate(contactDTO);
        if(valid){
            System.out.println("saving success");
            return "ContactSuccess.jsp";
        }

        return "Contact.jsp";
    }
}
