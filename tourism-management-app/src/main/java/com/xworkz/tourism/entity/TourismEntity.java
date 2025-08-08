package com.xworkz.tourism.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity

@Table(name = "tourism_details")
public class TourismEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id")
    private Integer tourID;

    @Column(name = "tour_destination")
    private String destination;

    @Column(name = "tour_start_point")
    private String startPoint;

    @Column(name = "package_price")
    private Double packagePrice;

    @Column(name = "vehicle")
    private String vehicle;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "no_of_people")
    private Integer noOfPeople;

    @Column(name = "start_date")
    private String startDate;

    @Column(name ="end_date" )
    private String endDate;

}
