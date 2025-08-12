package com.xworkz.exhibition.repo;

import com.xworkz.exhibition.entity.ArtEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class ArtRepositoryImpl implements ArtRepository{
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("x-workz");

    @Override
    public boolean save(ArtEntity entity) {
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
    public List<ArtEntity> getAllArtworks() {
        EntityManager em=null;
        List<ArtEntity> entityList=null;
        try{
            em=emf.createEntityManager();
            entityList=em.createNamedQuery("getAllArtworks").getResultList();
        }
        catch (PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(em!=null){
                em.close();
            }
//
        }
        return entityList;
    }

    public static  void closeFactory(){
        if(emf!=null && emf.isOpen()){
            emf.close();
        }
    }
}
