package com.xworkz.exhibition.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ArtDTO {

    private Integer artID;
    private String artistName;
    private String artworkTitle;
    private Integer lengthInCm;
    private Integer widthInCm;
    private Double price;
    private String artistEmail;
    private Long artistContact;


}
