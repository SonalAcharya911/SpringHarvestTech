package com.xworkz.diary.runner;

import com.xworkz.diary.entity.ApplicationEntity;
import com.xworkz.diary.service.ApplicationService;
import com.xworkz.diary.service.ApplicationServiceImpl;

import java.time.LocalDate;

public class ApplicationCreate {
    public static void main(String[] args) {
        ApplicationEntity entity=new ApplicationEntity(0,"IntelliJ IDEA","1GB","JetBrains",50000,9.5f, LocalDate.of(2025,7,31));

        ApplicationService service=new ApplicationServiceImpl();

        ApplicationEntity entity1=new ApplicationEntity(0,"PyCharm","500MB","Jetbrains",7000,8.5f,LocalDate.of(2020,2,6));
        boolean valid=service.validate(entity);

        service.validate(entity1);

        if(valid){
            System.out.println("saved data successfully");
        }
        else{
            System.out.println("couldn't save data");
        }
    }
}
