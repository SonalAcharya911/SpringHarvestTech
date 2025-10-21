package com.xworkz.onlineauction.repository;

import com.xworkz.onlineauction.entity.MemberEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalTime;

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
                memberEntity.setExpiryTime(LocalTime.now().plusMinutes(2));
                memberEntity.setLoginCount(-1);
                memberEntity.setLoggedIn(false);
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
            String sentOTP= (String) em.createNamedQuery("verifyOTP").setParameter("email",email).getSingleResult();
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
    public boolean savePassword(String email, String password) {
        System.out.println("running savePassword in Repository");
        System.out.println("email in savePassword repo: "+email);
        System.out.println("password in savePassword repo: "+password);
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
//            Query query=em.createNamedQuery("savePassword").setParameter("password",password).setParameter(

            em.getTransaction().begin();
            int rows=em.createQuery("update MemberEntity m set m.password=: password where m.email=: email").setParameter("password",password).setParameter("email",email).executeUpdate();
            em.getTransaction().commit();

            System.out.println("no of rows affected: "+rows);
            if(rows>0){
                System.out.println("password saved successfully");
                return true;
            }
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            if(em!=null){
                em.close();
            }
        }
        return false;
    }

    @Override
    public MemberEntity login(String email, String password) {
        System.out.println("running login in Repository");
        String savedPassword=null;
        MemberEntity entity=null;
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            entity = (MemberEntity) em.createNamedQuery("checkEmailExist").setParameter("email",email).getSingleResult();
            System.out.println("entity in login repo: "+entity);
            savedPassword=entity.getPassword();
            System.out.println("savedPassword: "+savedPassword);
            if(savedPassword.equals(password)){
                System.out.println("password is correct");
            }
            else{
                System.out.println("password is incorrect");
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
        return entity;
    }

    public static void closeFactory(){
        if(emf!=null && emf.isOpen()  ){
            emf.close();
        }
    }
}
