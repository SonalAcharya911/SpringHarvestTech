package com.xworkz.bakery.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name="")
public class ChocolateEntity {
    private String chocolateName;
    private String chocolateType;
    private String brand;
    private Date expiry;
    private int numOfChocolates;
}
