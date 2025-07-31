package com.xworkz.contact.service;

import com.xworkz.contact.dto.ContactDTO;
import com.xworkz.contact.repository.ContactRepo;
import com.xworkz.contact.repository.ContactRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    ContactRepo contactRepo;

    public ContactServiceImpl(){
        System.out.println("created ContactServiceImpl...");
    }

    public boolean validate(ContactDTO contactDTO){
        System.out.println("running validate in ContactServiceImpl");
        if(contactDTO!=null){
            if(contactDTO.getName()!=null && contactDTO.getName().length()>3){
                System.out.println("valid name");
            }
            else{
                System.out.println("invalid name");
                return false;
            }
            if(contactDTO.getEmail()!=null && contactDTO.getEmail().endsWith(".com")){
                System.out.println("valid email");
            }
            else{
                System.out.println("invalid email");
                return false;
            }

            if(contactDTO.getMobile()!=0 && contactDTO.getMobile()>999999999l){
                System.out.println("valid phone number");
            }
            else{
                System.out.println("invalid phone number");
                return false;
            }

            if(contactDTO.getComments()!=null){
                System.out.println("valid comments");
            }
            else{
                System.out.println("comments cannot be null");
                return false;
            }
            int savedRows=contactRepo.save(contactDTO);
            System.out.println(savedRows+" rows saved");

            return true;
        }
        return false;
    }
}
