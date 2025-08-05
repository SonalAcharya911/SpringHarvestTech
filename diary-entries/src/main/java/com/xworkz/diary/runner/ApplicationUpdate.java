package com.xworkz.diary.runner;

import com.xworkz.diary.repository.ApplicationRepository;
import com.xworkz.diary.repository.ApplicationRepositoryImpl;

public class ApplicationUpdate {
    public static void main(String[] args) {

        ApplicationRepository repository=new ApplicationRepositoryImpl();

        int rowsAffected=repository.updateNameAndNoOfUsersByCompanyAndID("PyCharm",45000,"JetBrains",3);

        System.out.println(rowsAffected);
    }
}
