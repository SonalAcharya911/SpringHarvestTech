package com.xworkz.diary.repository;

import com.xworkz.diary.entity.ApplicationEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class ApplicationRepositoryImpl implements ApplicationRepository{

    private static final EntityManagerFactory emf=Persistence.createEntityManagerFactory("x-workz");

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

            Query query=entityManager.createNamedQuery("findByApplicationName");
            entity= (ApplicationEntity) query.setParameter("appName",name).getSingleResult();
            List resultList=entityManager.createNamedQuery("findByApplicationName").setParameter("appName",name).getResultList();
            resultList.forEach(System.out::println);
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
    public List<ApplicationEntity> fetchAll() {
        EntityManager em=emf.createEntityManager();
        try{
            List<ApplicationEntity> appList= em.createNamedQuery("fetchAll").getResultList();
            if(appList!=null){
                return appList;
            }
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(em!=null){
                em.close();
            }
        }

        return Collections.emptyList();
    }

    @Override
    public ApplicationEntity findByCompanyName(String company) {
        ApplicationEntity app=null;
        if(company!=null){
            EntityManager em=null;
            try{
                em=emf.createEntityManager();
                TypedQuery<ApplicationEntity> typedQuery= em.createQuery("select a from ApplicationEntity a where a.company = : company",ApplicationEntity.class).setParameter("company",company);

                app=typedQuery.getSingleResult();

                int rows=typedQuery.executeUpdate();

                System.out.println("rows affected: "+rows);

            }catch(PersistenceException e){
                System.out.println(e.getMessage());
            }
            finally{
                if(em!=null){
                    em.close();
                }
            }
        }
        return app;

    }

    @Override
    public int updateNameAndNoOfUsersByCompanyAndID(String name, Integer noOfUsers, String company, Integer id) {
        EntityManager em=null;
        EntityTransaction et=null;
        int rows=0;
        try{
            em=emf.createEntityManager();

            et=em.getTransaction();

            et.begin();
            Query query=em.createNamedQuery("updateNameAndNoOfUsersByCompanyAndID")
                    .setParameter("name",name)
                    .setParameter("company",company)
                    .setParameter("noOfUsers",noOfUsers)
                    .setParameter("id",id);

            rows= query.executeUpdate();
            et.commit();

        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
            et.rollback();
        }
        finally {
            if(em!=null){
                em.close();
            }
        }
        return rows;
    }

//    public static void closeEntityManagerFactory(){
//        System.out.println("closing entity manager factory...");
//        if(emf!=null && emf.isOpen()){
//
//            emf.close();
//        }
//    }

}
