package com.xworkz.diary.runner;

import com.xworkz.diary.entity.ApplicationEntity;
import com.xworkz.diary.repository.ApplicationRepository;
import com.xworkz.diary.repository.ApplicationRepositoryImpl;
import com.xworkz.diary.service.ApplicationService;
import com.xworkz.diary.service.ApplicationServiceImpl;

import java.util.List;
import java.util.function.BiConsumer;

public class ApplicationRead {
    public static void main(String[] args) {
        ApplicationService applicationService=new ApplicationServiceImpl();

//        ApplicationEntity entity=applicationService.findByID(3);
//        System.out.println(entity);

//        ApplicationEntity entity1=applicationService.findByApplicationName("FaceBook");
//        System.out.println("findByApplicationName: "+entity1);
//
//        List<ApplicationEntity> list=applicationService.fetchAll();
//
//        if(list==null){
//            System.out.println("list is null");
//        }
//
//        list.forEach(System.out::println);

        List<Object> appNames=applicationService.getAllApplicationName();

//        appNames.forEach(System.out::println);

        List<List<Object>> appNameAndCompany=applicationService.getAllApplicationNameAndCompany();

//        List<Object> appNameAndDate=applicationService.getAllAppLaunchDate();

//        appNameAndDate.forEach(System.out::println);

        List<Object[]> list=applicationService.getAllApplicationNameAndNoOfUsers();

        list.forEach(objects -> System.out.println("name: "+objects[0]+", noOfUsers: "+objects[1]));

    }
}
