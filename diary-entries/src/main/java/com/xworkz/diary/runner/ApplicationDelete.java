package com.xworkz.diary.runner;

import com.xworkz.diary.service.ApplicationService;
import com.xworkz.diary.service.ApplicationServiceImpl;

public class ApplicationDelete {
    public static void main(String[] args) {
        ApplicationService applicationService=new ApplicationServiceImpl();

        applicationService.deleteByID(1);

    }

}
