package com.xworkz.diary.runner;

import com.xworkz.diary.entity.ApplicationEntity;
import com.xworkz.diary.repository.ApplicationRepository;
import com.xworkz.diary.repository.ApplicationRepositoryImpl;
import com.xworkz.diary.service.ApplicationService;
import com.xworkz.diary.service.ApplicationServiceImpl;

public class ApplicationRead {
    public static void main(String[] args) {
        ApplicationService applicationService=new ApplicationServiceImpl();

//        ApplicationEntity entity=applicationService.findByID(3);
//        System.out.println(entity);

//        ApplicationEntity entity1=applicationService.findByApplicationName("PyCharm");
//        System.out.println("findByApplicationName: "+entity1);

        ApplicationRepository repository=new ApplicationRepositoryImpl();
        ApplicationEntity entity2=repository.find("company","META");
    }
}
