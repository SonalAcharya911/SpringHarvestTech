package com.xworkz.diary.service;

import com.xworkz.diary.entity.ApplicationEntity;

import java.util.List;

public interface ApplicationService {
    public boolean validate(ApplicationEntity applicationEntity);

    public ApplicationEntity findByID(int id);

    public void deleteByID(int id);

    public ApplicationEntity findByApplicationName(String name);

    List<ApplicationEntity> fetchAll();

    List<Object> getAllApplicationName();

    List<List<Object>> getAllApplicationNameAndCompany();

    List<Object> getAllAppLaunchDate();

    List<Object[]> getAllApplicationNameAndNoOfUsers();

}
