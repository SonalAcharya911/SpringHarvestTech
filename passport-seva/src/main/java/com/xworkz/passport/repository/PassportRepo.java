package com.xworkz.passport.repository;

import com.xworkz.passport.entity.UserEntity;

import java.util.List;

public interface PassportRepo {
    boolean save(UserEntity entity);

    List<UserEntity> getAll();

    boolean checkEmailExist(String email);

    boolean checkloginIdExist(String loginID);

    boolean checkContactExist(Long contact);

    boolean updatePassport(UserEntity entity);
}
