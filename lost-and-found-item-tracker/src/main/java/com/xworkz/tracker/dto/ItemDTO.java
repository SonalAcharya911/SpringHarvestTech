package com.xworkz.tracker.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ItemDTO {
    private Integer itemID;
    private String holderName;
    private String itemName;
    private String itemDescription;
    private String lostOrFound;
    private String location;
    private String lostOrFoundDate;
    private String email;
    private Long contact;
}
