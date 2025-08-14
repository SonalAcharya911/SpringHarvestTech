package com.xworkz.passport.service;

import com.xworkz.passport.dto.UserDTO;

import java.util.List;

public interface PassportService {
    boolean save(UserDTO dto);

    List<UserDTO> getAll();

    boolean checkEmailExist(String email);

    boolean checkloginIdExist(String loginID);

    boolean checkContactExist(Long contact);
}
