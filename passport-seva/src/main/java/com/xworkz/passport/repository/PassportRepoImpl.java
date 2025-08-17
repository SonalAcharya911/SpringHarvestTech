package com.xworkz.passport.repository;

import com.xworkz.passport.dto.UserDTO;
import com.xworkz.passport.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class PassportRepoImpl implements PassportRepo {

    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("x-workz");
    @Override
    public boolean save(UserEntity entity) {
        System.out.println("running save in Repo");
        if(entity!=null){
            EntityManager em=null;
            EntityTransaction et=null;

            System.out.println("save in Repo: "+entity);
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

            return  true;
        }
        return false;
    }

    @Override
    public List<UserEntity> getAll() {
        System.out.println("running getAll in Repo");
        List<UserEntity> list=null;

        EntityManager em=null;

        try{
            em= emf.createEntityManager();
            list=em.createNamedQuery("getAll").getResultList();
            System.out.println("Passport List in Repo: ");
            list.forEach(System.out::println);
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(em!=null){
                em.close();
            }
        }
        return list;
    }

    public boolean checkEmailExist(String email){
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            Query query=em.createNamedQuery("checkEmailExist").setParameter("email",email);
            UserEntity entity= (UserEntity) query.getSingleResult();
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
    public boolean checkloginIdExist(String loginID) {
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            Query query=em.createNamedQuery("checkLoginIdExist").setParameter("loginID",loginID);
            UserEntity entity= (UserEntity) query.getSingleResult();
            if(entity!=null){
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
    public boolean checkContactExist(Long contact) {
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            Query query=em.createNamedQuery("checkContactExist").setParameter("contact",contact);
            UserEntity entity= (UserEntity) query.getSingleResult();
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
    public UserEntity findByID(Integer id) {
        System.out.println("running findByID in Repository");
        EntityManager em=null;
        UserEntity entity=null;
        try{
            em=emf.createEntityManager();
            entity = em.find(UserEntity.class,id);
            System.out.println("User entity in Repo:"+entity);
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
    public boolean updatePassport(UserEntity entity) {
        System.out.println("running updatePassword in Repo");
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            em.getTransaction().begin();
            int rows=em.createNamedQuery("updatePassport").setParameter("passportOffice",entity.getPassportOffice())
                    .setParameter("givenName",entity.getGivenName())
                    .setParameter("surname",entity.getSurname())
                    .setParameter("dob",entity.getDob())
                    .setParameter("email",entity.getEmail())
                    .setParameter("contact",entity.getContact())
                    .setParameter("loginID",entity.getLoginID())
                    .setParameter("password",entity.getPassword())
                    .setParameter("confirmPassword",entity.getConfirmPassword())
                    .setParameter("hintQuestion",entity.getHintQuestion())
                    .setParameter("hintAnswer",entity.getHintAnswer())
                    .setParameter("id",entity.getUserID())
                    .executeUpdate();
            em.getTransaction().commit();

            if(rows>0){
                return true;
            }
        }catch(PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(em!=null){
                em.close();
            }
        }
        return false;
    }

    @Override
    public boolean deletePassportByID(Integer id) {
        System.out.println("running deletePassportByID in Repo");
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            UserEntity entity=em.find(UserEntity.class,id);
            em.getTransaction().begin();
            if(entity!=null){
                int rows=em.createNamedQuery("deletePassport").setParameter("userID",entity.getUserID()).executeUpdate();
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


    public static void closeFactory(){
        if(emf.isOpen() && emf!=null){
            emf.close();
        }
    }
}
