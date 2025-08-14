package com.xworkz.passport.service;

import com.xworkz.passport.dto.UserDTO;
import com.xworkz.passport.entity.UserEntity;
import com.xworkz.passport.repository.PassportRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.crypto.spec.PSource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassportServiceImpl implements PassportService{

    @Autowired
    private PassportRepo repo;

    @Override
    public boolean save(UserDTO dto) {
        UserEntity entity=new UserEntity();
        BeanUtils.copyProperties(dto,entity);

        System.out.println("save in Service: "+dto);
        return repo.save(entity);
    }

    @Override
    public List<UserDTO> getAll() {
        System.out.println("running getAll in Service");
        List<UserEntity> entityList=repo.getAll();
        List<UserDTO> dtoList=entityList.stream().map(entity -> {
            UserDTO dto=new UserDTO();
            BeanUtils.copyProperties(entity,dto);
            return dto;
        }).collect(Collectors.toList());

        System.out.println("entity list:========= ");
        entityList.forEach(System.out::println);

        System.out.println("dto list :=================");
        dtoList.forEach(System.out::println);

        return dtoList;
    }

    @Override
    public boolean checkEmailExist(String email){
        System.out.println("running checkEmailExist in Service");
        boolean exists= repo.checkEmailExist(email);

        if(exists){
            System.out.println("email exists");
            return true;
        }
        return false;
    }

    @Override
    public boolean checkloginIdExist(String loginID) {
        System.out.println("running checkloginIdExist in Service");
        boolean exists= repo.checkloginIdExist(loginID);

        if(exists){
            System.out.println("loginID exists");
            return true;
        }
        return false;
    }

    @Override
    public boolean checkContactExist(Long contact) {
        System.out.println("running checkContactExist in Service");
        boolean exists= repo.checkContactExist(contact);

        if(exists){
            System.out.println("contact exists");
            return true;
        }
        return false;
    }
}
