package com.xworkz.diary.service;

import com.xworkz.diary.entity.ApplicationEntity;
import com.xworkz.diary.repository.ApplicationRepository;
import com.xworkz.diary.repository.ApplicationRepositoryImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ApplicationServiceImpl implements ApplicationService{

    ApplicationRepository applicationRepository;

    @Override
    public boolean validate(ApplicationEntity entity) {
        System.out.println("running validate in ApplicationServiceImpl");

        if(entity!=null){
            System.out.println("entity is not null");
            if(entity.getApplicationName()!=null){
                System.out.println("valid name");
            }
            else{
                System.out.println("invalid name");
                return false;
            }
            if(entity.getApplicationSize()!=null){
                System.out.println("valid size");
            }
            else{
                System.out.println("invalid size");
                return false;
            }

            if(entity.getCompany()!=null){
                System.out.println("valid company");
            }
            else{
                System.out.println("invalid company");
                return false;
            }

            if(entity.getRating()!=0){
                System.out.println("valid rating");
            }
            else{
                System.out.println("rating cannot be zero");
                return false;
            }

            if(entity.getLaunchDate()!=null){
                System.out.println("valid date");
            }
            else{
                System.out.println("invalid date");
                return false;
            }

            if(entity.getNoOfUsers()!=null){
                System.out.println("valid number of users");
            }
            else{
                System.out.println("invalid number of users");
                return false;
            }

            ApplicationRepository applicationRepository=new ApplicationRepositoryImpl();
            applicationRepository.saveApplication(entity);
            return true;
        }
        return false;
    }

    @Override
    public ApplicationEntity findByID(int id) {

        ApplicationRepository repo=new ApplicationRepositoryImpl();
        ApplicationEntity entity=repo.readByID(id);

        return entity;
    }

    @Override
    public void deleteByID(int id) {
        ApplicationRepository repository=new ApplicationRepositoryImpl();
        repository.deleteByID(id);
    }

    @Override
    public ApplicationEntity findByApplicationName(String name) {
        ApplicationEntity entity=null;

        ApplicationRepository repo=new ApplicationRepositoryImpl();
        entity=repo.findByApplicationName(name);

        return entity;
    }

    @Override
    public List<ApplicationEntity> fetchAll() {
        applicationRepository=new ApplicationRepositoryImpl();
        List<ApplicationEntity> list=applicationRepository.fetchAll();
        if(list!=null){
            return list;
        }
        return Collections.emptyList();
    }
}
