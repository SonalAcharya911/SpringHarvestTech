package com.xworkz.complaint.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


public class ComplaintDTO {
    private Integer complaintID;
    private String complainantName;
    private String email;
    private Long contact;
    private String category;
    private String description;
    private String location;
}
