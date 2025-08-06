package com.xworkz.icecream.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class OrderDTO {

    @Size(min=3,max=30)
    private String name;

    @Size(min=3,max=40)
    private String flavour;

    @Min(1)
    private int quantity;

    private boolean takeAway;

    @Size(max=100)
    private String addOn;

    @Size(max = 7)
    private String couponCode;

    private MultipartFile multipartFile;
}
