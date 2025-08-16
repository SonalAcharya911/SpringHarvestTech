package com.xworkz.tracker.repository;

import com.xworkz.tracker.dto.ItemDTO;
import com.xworkz.tracker.entity.ItemEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository{

    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("x-workz");

    @Override
    public boolean save(ItemEntity entity) {
        System.out.println("running save in ItemRepoImpl");
        if(entity!=null){
            System.out.println("dto not null");
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
                if(em!=null) {
                    em.close();
                }
            }

            return  true;
        }
        return false;
    }

    @Override
    public List<ItemEntity> getAllItems() {

        EntityManager em=null;
        List<ItemEntity> entityList=null;
        try{
            em=emf.createEntityManager();
            entityList=em.createNamedQuery("getAllItems").getResultList();
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
    public ItemEntity findByID(Integer id) {
        EntityManager em=null;
        ItemEntity entity=null;
        try{
            em=emf.createEntityManager();
            entity= em.find(ItemEntity.class,id);
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
    public boolean updateItem(ItemEntity entity) {
        System.out.println("running updateItem in Repository");
        return false;
    }

    @Override
    public boolean deleteItemByID(Integer id) {
        System.out.println("running deleteItemByID in Repository");
        return false;
    }

    public static  void closeFactory(){
        if(emf!=null && emf.isOpen()){
            emf.close();
        }
    }
}
