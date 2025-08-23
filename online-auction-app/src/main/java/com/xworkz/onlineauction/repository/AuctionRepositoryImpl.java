package com.xworkz.onlineauction.repository;

import com.xworkz.onlineauction.entity.MemberEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class AuctionRepositoryImpl implements AuctionRepository {

    private static final Logger log= LoggerFactory.getLogger(AuctionRepositoryImpl.class);
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("x-workz");

    @Override
    public boolean save(MemberEntity memberEntity) {
        System.out.println("running save in Repo, entity: "+memberEntity);
        EntityManager em=null;
        log.info("trying first log");
        try{
            if(memberEntity!=null){
                em=emf.createEntityManager();
                em.getTransaction().begin();
                em.persist(memberEntity);
                em.getTransaction().commit();
                log.info("saved data from repository");
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

    @Override
    public boolean verifyOTP(String email,String otp) {

        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            Integer sentOTP= (Integer) em.createNamedQuery("verifyOTP").setParameter("email",email).getSingleResult();
            if(sentOTP!=null){
                System.out.println("sentOTP: "+sentOTP);
                if(sentOTP.equals(otp)){
                    return true;
                }
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

    @Override
    public boolean savePassword(String password) {
        return false;
    }
}
