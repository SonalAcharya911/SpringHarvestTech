package com.xworkz.onlineauction.service;

import com.xworkz.onlineauction.dto.MemberDTO;

public interface AuctionService {
    boolean validateAndSave(MemberDTO dto);

    boolean checkEmailExist(String email);

    boolean checkContactExist(Long contact);


    void mailSend(String email, String otp);

    boolean verifyOTP(String email,String otp);


}
