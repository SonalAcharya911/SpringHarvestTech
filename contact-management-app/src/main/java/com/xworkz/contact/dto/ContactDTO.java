package com.xworkz.contact.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ContactDTO {
    private int contactID;
    private String name;
    private String email;
    private long mobile;
    private String comments;
}
