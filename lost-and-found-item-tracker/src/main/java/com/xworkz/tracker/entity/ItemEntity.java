package com.xworkz.tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "item_details")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemID;

    @Column(name = "holder_name")
    private String holderName;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "lost_or_found")
    private String lostOrFound;

    @Column(name = "location")
    private String location;

    @Column(name = "lost_found_date")
    private Date lostOrFoundDate;

    @Column(name = "holder_email")
    private String email;

    @Column(name = "holder_contact")
    private Long contact;
}
