package com.xworkz.diary.repository;

import com.xworkz.diary.entity.ApplicationEntity;
import com.xworkz.diary.runner.ApplicationRead;

import javax.persistence.*;
import java.util.List;

public class ApplicationRepositoryImpl implements ApplicationRepository{

    private EntityManagerFactory emf=Persistence.createEntityManagerFactory("x-workz");

    @Override
    public void saveApplication(ApplicationEntity applicationEntity) {

        EntityManager em=null;
        EntityTransaction et=null;

        try{
            em=emf.createEntityManager();

            et=em.getTransaction();

            et.begin();
            em.persist(applicationEntity);
            et.commit();
        }
        catch(PersistenceException e){
            System.out.println("exception occured");
            System.out.println(e.getMessage());

            et.rollback();
        }
        finally {
            if(emf!=null){
                System.out.println("closing emf");
                emf.close();
            }
            if(em!=null){
                System.out.println("closing em");
                em.close();
            }
        }
    }

    @Override
    public ApplicationEntity readByID(int id) {
        EntityManager em=null;
        ApplicationEntity entity=null;

        try{

            em=emf.createEntityManager();

            entity=em.find(ApplicationEntity.class,id);


        }
        catch(PersistenceException e){
            System.out.println("exception occured");
            System.out.println(e.getMessage());

        }
        finally {
            if(emf!=null){
                System.out.println("closing emf");
                emf.close();
            }
            if(em!=null){
                System.out.println("closing em");
                em.close();
            }
        }
        return entity;
    }

    @Override
    public void deleteByID(int id) {
        EntityManager em=null;
        EntityTransaction et=null;

        try{
            em=emf.createEntityManager();

            et=em.getTransaction();

            et.begin();
            ApplicationEntity entity=em.find(ApplicationEntity.class,1);
            em.remove(entity);
            et.commit();
        }
        catch(PersistenceException e){
            System.out.println("exception occured");
            System.out.println(e.getMessage());

            et.rollback();
        }
        finally {
            if(emf!=null){
                System.out.println("closing emf");
                emf.close();
            }
            if(em!=null){
                System.out.println("closing em");
                em.close();
            }
        }
    }


    @Override
    public void update(int id, Object updatedEntity) {

        EntityManager em=null;
        EntityTransaction et=null;

        try{
            em=emf.createEntityManager();

            et=em.getTransaction();

            et.begin();
            em.merge(updatedEntity);

            et.commit();
        }
        catch(PersistenceException e){
            System.out.println("exception occured");
            System.out.println(e.getMessage());

            et.rollback();
        }
        finally {
            if(emf!=null){
                System.out.println("closing emf");
                emf.close();
            }
            if(em!=null){
                System.out.println("closing em");
                em.close();
            }
        }
    }

    @Override
    public ApplicationEntity findByApplicationName(String name) {
        EntityManager entityManager=null;
        ApplicationEntity entity=null;
        try{
            entityManager=emf.createEntityManager();

            entity= (ApplicationEntity) entityManager.createNamedQuery("findByApplicationName").setParameter("appName",name).getSingleResult();
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(emf!=null){
                System.out.println("closing emf");
                emf.close();
            }
            if(entityManager!=null){
                System.out.println("closing em");
                entityManager.close();
            }
        }

        return entity;

    }

    @Override
    public ApplicationEntity find(Object property, Object value) {
        EntityManager entityManager=null;
        ApplicationEntity entity=null;
        try{
            entityManager=emf.createEntityManager();

            entity= (ApplicationEntity) entityManager.createNamedQuery("findByApplicationName").setParameter("property",property).setParameter("value",value).getSingleResult();
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(emf!=null){
                System.out.println("closing emf");
                emf.close();
            }
            if(entityManager!=null){
                System.out.println("closing em");
                entityManager.close();
            }
        }

        return entity;


    }
}
