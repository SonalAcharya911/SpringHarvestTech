package com.xworkz.icecream.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class OrderDTO {
    private String name;
    private String flavour;
    private int quantity;
    private boolean takeAway;
    private String addOn;
    private String couponCode;
}
