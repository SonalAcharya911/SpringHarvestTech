package com.xworkz.exam.service;

import com.xworkz.exam.dto.StudentDTO;

public interface EmailSender {
    void mailSend(String email, String otp, StudentDTO dto);
}
