package com.xworkz.library.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class LibraryDTO {

    private Integer libraryID;
    private String libraryName;
    private String libraryLocation;
    private Integer noOfBooks;
    private Long phone;
    private String email;

}
