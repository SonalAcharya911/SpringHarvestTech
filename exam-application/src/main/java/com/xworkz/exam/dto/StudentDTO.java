package com.xworkz.exam.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@Data

public class StudentDTO {
    private String name;
    private String email;
    private String stream;
    private String branch;
    private String course;
    private MultipartFile multipartFile;
}
