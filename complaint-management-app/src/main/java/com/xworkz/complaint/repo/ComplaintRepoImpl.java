package com.xworkz.complaint.repo;

import com.xworkz.complaint.entity.ComplaintEntity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class ComplaintRepoImpl implements ComplaintRepo{

    private static  final EntityManagerFactory emf= Persistence.createEntityManagerFactory("x-workz");
    @Override
    public boolean save(ComplaintEntity entity) {
        if(entity!=null){
            System.out.println("Repository: "+entity);
            EntityManager em=null;
            EntityTransaction et=null;
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
            }
            return true;
        }
        return false;
    }

    @Override
    public List<ComplaintEntity> getAllComplaints() {
        EntityManager em=null;
        List<ComplaintEntity> entityList=null;
        try{
            em=emf.createEntityManager();
            entityList=em.createNamedQuery("getAllComplaints").getResultList();
        }
        catch (PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(em!=null){
                em.close();
            }

        }
        return entityList;
    }

    @Override
    public ComplaintEntity findByID(Integer id) {
        EntityManager em=null;
        ComplaintEntity entity=null;
        try{
            em=emf.createEntityManager();
            entity= em.find(ComplaintEntity.class,id);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {
            if(em!=null){
                em.close();
            }
        }

        return entity;
    }

    @Override
    public boolean updateComplaintDetails(ComplaintEntity entity) {
        return false;
    }

    @Override
    public boolean deleteComplaintByID(Integer id) {
        return false;
    }

    public static  void closeFactory(){
        if(emf!=null && emf.isOpen()){
            emf.close();
        }
    }
}
