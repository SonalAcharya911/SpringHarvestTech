package com.xworkz.bakery.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name="")
public class BakedGoodEntity {
    private String name;
    private String type;
    private String madeOf;
    private Date packedDate;
    private Date useBeforeDate;
}
