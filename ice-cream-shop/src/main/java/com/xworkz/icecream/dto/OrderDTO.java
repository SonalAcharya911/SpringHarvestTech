package com.xworkz.icecream.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDTO {
    private String name;
    private String flavour;
    private int quantity;
    private boolean takeAway;
    private boolean addOn;
    private String couponCode;
}
