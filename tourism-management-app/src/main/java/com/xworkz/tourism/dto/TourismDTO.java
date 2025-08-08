package com.xworkz.tourism.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString

public class TourismDTO {
    private Integer tourID;
    private String destination;
    private String startPoint;
    private Double packagePrice;
    private String vehicle;
    private String vehicleNumber;
    private Integer noOfPeople;
    private String startDate;
    private String endDate;

}
