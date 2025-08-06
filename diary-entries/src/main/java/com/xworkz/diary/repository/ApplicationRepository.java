package com.xworkz.diary.repository;

import com.xworkz.diary.entity.ApplicationEntity;
import com.xworkz.diary.runner.ApplicationRead;

import java.util.List;

public interface ApplicationRepository {
    void saveApplication(ApplicationEntity applicationEntity);

    ApplicationEntity readByID(int id);

    void deleteByID(int id);

    void update(int id, Object updatedValue);

    ApplicationEntity findByApplicationName(String name);

    List<ApplicationEntity> fetchAll();

    ApplicationEntity findByCompanyName(String company);

    int updateNameAndNoOfUsersByCompanyAndID(String name,Integer noOfUsers, String company, Integer id);

    List<Object> getAllApplicationName();

    List<List<Object>> getAllApplicationNameAndCompany();

    List<Object> getAllAppLaunchDate();

    List<Object[]> getAllAppNameAndNoOfUsers();

}
