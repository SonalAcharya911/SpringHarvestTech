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

    @Override
    public ArtEntity findByID(Integer id) {
        EntityManager em=null;
        ArtEntity entity=null;
        try{
            em=emf.createEntityManager();
            entity= em.find(ArtEntity.class,id);
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
    public boolean updateArtworkDetails(ArtEntity entity) {
        System.out.println("running updateArtworkDetails in Repository");
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            em.getTransaction().begin();
            int rows=em.createNamedQuery("updateArtwork").setParameter("artistName",entity.getArtistName())
                    .setParameter("artworkTitle",entity.getArtworkTitle())
                    .setParameter("lengthInCm",entity.getLengthInCm())
                    .setParameter("widthInCm",entity.getWidthInCm())
                    .setParameter("price",entity.getPrice())
                    .setParameter("artistEmail",entity.getArtistEmail())
                    .setParameter("artistContact",entity.getArtistContact())
                    .setParameter("artID",entity.getArtID())
                    .executeUpdate();
            if(rows>0){
                em.getTransaction().commit();
                return true;
            }
        }catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {
            if(em!=null){
                em.close();
            }
        }
        return false;
    }

    @Override
    public boolean deleteArtworktByID(Integer id) {
        System.out.println("running deleteArtworktByID in Repository");
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            ArtEntity entity=em.find(ArtEntity.class,id);
            em.getTransaction().begin();
            if(entity!=null){
                int rows=em.createNamedQuery("deleteArtwork").setParameter("artID",entity.getArtID()).executeUpdate();
                System.out.println("rows affected: "+rows);
                if(rows>0){
                    em.getTransaction().commit();
                    return true;
                }
            }
        }
        catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {
            if(em!=null){
                em.close();
            }
        }
        return false;
    }

    public static  void closeFactory(){
        if(emf!=null && emf.isOpen()){
            emf.close();
        }
    }
}
