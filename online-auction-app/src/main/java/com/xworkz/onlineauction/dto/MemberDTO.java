package com.xworkz.onlineauction.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    private Integer id;
    private String name;
    private String email;
    private Long contact;
    private String dob;
    private String gender;
    private String state;
    private String address;
    private String password;
    private String confirmPassword;

}
