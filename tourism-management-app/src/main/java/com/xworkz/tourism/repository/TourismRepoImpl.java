package com.xworkz.tourism.repository;

import com.xworkz.tourism.dto.TourismDTO;
import com.xworkz.tourism.entity.TourismEntity;
import com.xworkz.tourism.service.TourismService;
import com.xworkz.tourism.service.TourismServiceImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class TourismRepoImpl implements TourismRepo{
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("x-workz");
    @Override
    public boolean saveTourism(TourismEntity entity) {
        System.out.println("running saveTourism in TourismRepoImpl" );

        if(entity!=null){
            EntityManager em=null;
            EntityTransaction et=null;

            System.out.println("Repo: "+entity);
            try{
                em=emf.createEntityManager();
                et=em.getTransaction();
                et.begin();
                em.persist(entity);
                et.commit();


                System.out.println("saved successfully...");

            }
            catch (PersistenceException e){
                System.out.println(e.getMessage());
            }
            finally {
                if(em!=null){
                    em.close();
                }
                if(emf!=null && emf.isOpen()){
                    emf.close();
                }
            }

            return  true;
        }
        return false;
    }

    @Override
    public List<TourismEntity> fetchAll() {
        System.out.println("running fetchAll");
        List<TourismEntity> list=null;

        EntityManager em=null;

        try{
            em= emf.createEntityManager();
            list=em.createNamedQuery("fetchAll").getResultList();

        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(em!=null){
                em.close();
            }
        }
        return list;
    }

    public static  void closeFactory(){
        if(emf!=null && emf.isOpen()){
            emf.close();
        }
    }
}
