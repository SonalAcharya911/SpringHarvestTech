package com.xworkz.contact.repository;

import com.xworkz.contact.dto.ContactDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ContactRepoImpl implements ContactRepo{

    @Autowired
    private JdbcTemplate template;

    public ContactRepoImpl(){
        System.out.println("created ContactRepoImpl");
    }

    public int save(ContactDTO contactDTO){
        System.out.println("running save in ContactRepoImpl");
        int rows=0;
        if(contactDTO!=null){
            System.out.println("dto is not null");
            String insertQuery="insert into contact_info(contact_id, contact_name, contact_email, contact_phone, contact_comments) values (?,?,?,?,?)";
            rows=template.update(insertQuery,contactDTO.getContactID(),contactDTO.getName(),contactDTO.getEmail(),contactDTO.getMobile(),contactDTO.getComments());
            System.out.println("rows affected in save= "+rows);
            System.out.println("added");

        }
        else{
            System.out.println("dto is null in repo");
        }
        return rows;
    }

    public List<ContactDTO> findAll(){
        List<ContactDTO> contacts=new ArrayList<>();
        return contacts;
    }
}
