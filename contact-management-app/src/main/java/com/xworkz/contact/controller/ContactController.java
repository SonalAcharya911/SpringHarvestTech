package com.xworkz.contact.controller;

import com.xworkz.contact.dto.ContactDTO;
import com.xworkz.contact.service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/")
public class ContactController {
    @Autowired
    ContactServiceImpl contactServiceImpl;

    public ContactController(){
        System.out.println("created ContactController..");
    }

    @RequestMapping("/submit")
    public String onSubmit(ContactDTO contactDTO, Model model) throws IOException {
        System.out.println("running onSubmit in ContactController...");
        model.addAttribute("dto",contactDTO);

        System.out.println(contactDTO+" dto...........");

        byte[] bytes = contactDTO.getMultipartFile().getBytes();
        Path path = Paths.get("C:\\Users\\sonal\\Desktop\\multipartFiles\\"+contactDTO.getName()+System.currentTimeMillis());
        Files.write(path,bytes);

        boolean valid= contactServiceImpl.validate(contactDTO);
        if(valid){
            System.out.println("saving success");
            return "ContactSuccess.jsp";
        }

        return "Contact.jsp";
    }
}
