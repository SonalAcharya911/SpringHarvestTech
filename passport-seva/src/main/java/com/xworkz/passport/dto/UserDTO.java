package com.xworkz.passport.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private Integer userID;
    private String passportOffice;
    private String givenName;
    private String surname;
    private String dob;
    private String email;
    private Long contact;
    private String loginID;
    private String password;
    private String confirmPassword;
    private String hintQuestion;
    private String hintAnswer;
}
