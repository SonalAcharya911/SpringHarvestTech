package com.xworkz.onlineauction.repository;

import com.xworkz.onlineauction.entity.MemberEntity;

public interface AuctionRepository {
    boolean save(MemberEntity memberEntity);

    boolean checkEmailExist(String email);

    boolean checkContactExist(Long contact);

    boolean verifyOTP(String email,String otp);

    boolean savePassword(String password);
}
