package com.xworkz.onlineauction.repository;

import com.xworkz.onlineauction.entity.MemberEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class AuctionRepositoryImpl implements AuctionRepository {

    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("x-workz");

    @Override
    public boolean save(MemberEntity memberEntity) {
        System.out.println("running save in Repo, entity: "+memberEntity);
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

    @Override
    public boolean checkEmailExist(String email) {
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            Query query=em.createNamedQuery("checkEmailExist").setParameter("email",email);
            MemberEntity entity= (MemberEntity) query.getSingleResult();
            System.out.println("entity in repo: "+entity);
            if(entity!=null){
                System.out.println("email already exists");
                return true;
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
        return false;
    }

    @Override
    public boolean checkContactExist(Long contact) {
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            Query query=em.createNamedQuery("checkContactExist").setParameter("contact",contact);
            MemberEntity entity= (MemberEntity) query.getSingleResult();
            if(entity!=null){
                System.out.println("contact exists");
                return true;
            }
        }catch(PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(em!=null){
                em.close();
            }
        }
        return false;
    }
}
