package com.xworkz.onlineauction.repository;

import com.xworkz.onlineauction.entity.MemberEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

@Repository
public class AuctionRepositoryImpl implements AuctionRepository {

    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("x-wrokz");

    @Override
    public boolean save(MemberEntity memberEntity) {
        EntityManager em=null;
        try{
            if(memberEntity!=null){
                em=emf.createEntityManager();
                em.getTransaction().begin();
                em.persist(memberEntity);
                em.getTransaction().commit();
                return true;
            }
        }catch(PersistenceException e){
            System.out.println(e.getMessage());
        }finally {
            if(em!=null){
                em.close();
            }
        }
        return false;
    }
}
