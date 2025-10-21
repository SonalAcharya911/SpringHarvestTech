package com.xworkz.onlineauction.service;

import com.xworkz.onlineauction.config.EmailConfiguration;
import com.xworkz.onlineauction.dto.MemberDTO;
import com.xworkz.onlineauction.entity.MemberEntity;
import com.xworkz.onlineauction.repository.AuctionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class AuctionServiceImpl implements AuctionService{

    @Autowired
    private AuctionRepository repo;

    @Autowired
    EmailConfiguration configuration;


    @Override
    public boolean validateAndSave(MemberDTO dto) {
        System.out.println("running validateAndSave in Service, DTO: "+dto);
        MemberEntity entity=null;
        boolean isSaved=false;
        if(dto!=null){
            entity=new MemberEntity();
            BeanUtils.copyProperties(dto,entity);
            isSaved=repo.save(entity);
        }
        return isSaved;
    }

    @Override
    public boolean checkEmailExist(String email) {
        System.out.println("running checkEmailExist in Service");
        boolean exists= repo.checkEmailExist(email);

        if(exists){
            System.out.println("email exists");
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

    @Override
    public void mailSend(String email, String otp) {
        System.out.println("Invoking mailSend");
        SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Otp to login");
        simpleMailMessage.setText("Otp for login "+otp);
        configuration.mailSender().send(simpleMailMessage);
        repo.savePassword(email, otp);
        System.out.println("Otp sent for :"+email+" : "+otp);
    }

    @Override
    public boolean verifyOTP(String email, String otp) {
        System.out.println("running verifyOTP in service...");
        boolean isVerified=repo.verifyOTP(email,otp);
        if(isVerified){
            System.out.println("otp verified");
        }
        else{
            System.out.println("otp does not match");
        }
        return isVerified;
    }

    @Override
    public boolean savePassword(String email, String password) {

        System.out.println("running savePassword in Service");
        boolean isSaved=repo.savePassword(email, password);
        if(isSaved){
            System.out.println("password saved ");
            return true;
        }
        else{
            System.out.println("couldn't save password");
        }
        return false;
    }

    @Override
    public MemberDTO loginToAccount(String email, String password) {
        System.out.println("running loginToAccount in Service");
        MemberDTO dto=new MemberDTO();
        if(email!=null){
            MemberEntity entity= repo.login(email,password);
            BeanUtils.copyProperties(entity,dto);
        }
        return dto;
    }
}
