package com.xworkz.diary.service;

import com.xworkz.diary.entity.ApplicationEntity;

public interface ApplicationService {
    public boolean validate(ApplicationEntity applicationEntity);

    public ApplicationEntity findByID(int id);

    public void deleteByID(int id);

    public ApplicationEntity findByApplicationName(String name);

}
