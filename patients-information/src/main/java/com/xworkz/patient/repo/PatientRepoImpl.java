package com.xworkz.patient.repo;

import com.xworkz.patient.entity.PatientEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class PatientRepoImpl implements PatientRepo {

    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
    private EntityManager em;
    private EntityTransaction transaction;

    @Override
    public boolean save(PatientEntity entity) {
        if (entity != null) {
            try {
                em = emf.createEntityManager();
                transaction = em.getTransaction();
                transaction.begin();
                em.persist(entity);
                transaction.commit();
                return true;
            } catch (PersistenceException e) {
                System.out.println("Exception in save: " + e.getMessage());
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
            } finally {
                if (em != null) em.close();
                if (emf != null) emf.close();
            }
        }
        return false;
    }

    @Override
    public boolean deletePatient(int id) {
        if (id > 0) {
            try {
                em = emf.createEntityManager();
                transaction = em.getTransaction();
                transaction.begin();
                PatientEntity entity = em.find(PatientEntity.class, id);
                if (entity != null) {
                    em.remove(entity);
                    transaction.commit();
                    return true;
                }
            } catch (PersistenceException e) {
                System.out.println("Exception in deletePatient: " + e.getMessage());
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
            } finally {
                if (em != null) em.close();
                if (emf != null) emf.close();
            }
        }
        return false;
    }

    @Override
    public boolean updatePatientContact(int id, Long contact) {
        if (id > 0 && contact != null) {
            try {
                em = emf.createEntityManager();
                transaction = em.getTransaction();
                transaction.begin();
                PatientEntity entity = em.find(PatientEntity.class, id);
                if (entity != null) {
                    entity.setContact(contact);
                    transaction.commit();
                    return true;
                }
            } catch (PersistenceException e) {
                System.out.println("Exception in updatePatientContact: " + e.getMessage());
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
            } finally {
                if (em != null) em.close();
                if (emf != null) emf.close();
            }
        }
        return false;
    }

    @Override
    public PatientEntity findByID(int id) {
        PatientEntity entity = null;
        if (id > 0) {
            try {
                em = emf.createEntityManager();
                entity = em.find(PatientEntity.class, id);
            } catch (PersistenceException e) {
                System.out.println("Exception in findByID: " + e.getMessage());
            } finally {
                if (em != null) em.close();
                if (emf != null) emf.close();
            }
        }
        return entity;
    }

    @Override
    public PatientEntity findByName(String name) {
        PatientEntity entity = null;
        if (name != null) {
            try {
                em = emf.createEntityManager();
                entity= (PatientEntity) em.createNamedQuery("findByName").setParameter("name",name).getSingleResult();

                em.createNamedQuery("findByName").setParameter("name",name).getResultStream().forEach(System.out::println);
            } catch (NoResultException e) {
                System.out.println("No patient found with name: " + name);
            } catch (PersistenceException e) {
                System.out.println("Exception in findByName: " + e.getMessage());
            } finally {
                if (em != null) em.close();
                if (emf != null) emf.close();
            }
        }
        return entity;
    }

    @Override
    public PatientEntity findByWardNumber(Integer wardNo) {
        PatientEntity entity = null;
        if (wardNo != null) {
            try {
                em = emf.createEntityManager();
                entity= (PatientEntity) em.createNamedQuery("findByWardNumber").setParameter("wardNumber",wardNo).getSingleResult();
            } catch (NoResultException e) {
                System.out.println("No patient found in ward number: " + wardNo);
            } catch (PersistenceException e) {
                System.out.println("Exception in findByWardNumber: " + e.getMessage());
            } finally {
                if (em != null) em.close();
                if (emf != null) emf.close();
            }
        }
        return entity;
    }

    @Override
    public int updateDoctorByBloodGroupAndSickness(String doctor, String bloodGroup, String sickness) {
        EntityManager em=null;
        EntityTransaction et=null;
        int rows=0;
        try{
            em=emf.createEntityManager();
            et=em.getTransaction();

            et.begin();
            Query query=em.createNamedQuery("updateDoctorByBloodGroupAndSickness").setParameter("doctor",doctor).setParameter("bloodGroup",bloodGroup).setParameter("sickness",sickness);
            rows=query.executeUpdate();
            et.commit();
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
            et.rollback();
        }
        finally{
            if(em!=null){
                em.close();
            }
        }
        return rows;
    }

    @Override
    public int updateAgeByID(Integer age, Integer id) {
        EntityManager em=null;
        EntityTransaction et=null;
        int rows=0;
        try{
            em=emf.createEntityManager();
            et=em.getTransaction();

            et.begin();
            Query query=em.createNamedQuery("updateAgeByID").setParameter("age",age).setParameter("id",id);
            rows=query.executeUpdate();
            et.commit();
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
            et.rollback();
        }
        finally{
            if(em!=null){
                em.close();
            }
        }
        return rows;
    }

    @Override
    public int updateContactByNameAndID(Long contact, String name, Integer id) {
        EntityManager em=null;
        EntityTransaction et=null;
        int rows=0;
        try{
            em=emf.createEntityManager();
            et=em.getTransaction();

            et.begin();
            Query query=em.createNamedQuery("updateContactByNameAndID").setParameter("contact",contact).setParameter("name",name).setParameter("id",id);
            rows=query.executeUpdate();
            et.commit();
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
            et.rollback();
        }
        finally{
            if(em!=null){
                em.close();
            }
        }
        return rows;
    }

    @Override
    public List<Object> getAllPatientNames() {
        List<Object> patientNames=null;
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            patientNames=em.createNamedQuery("getAllPatientNames").getResultList();
        }catch(PersistenceException e){
            System.out.println(e.getMessage());
        }finally {
            if(em!=null){
                em.close();
            }
        }
        return patientNames;
    }

    @Override
    public List<Integer> getAllWardNos() {
        List<Integer> wardNos=null;
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            wardNos=em.createNamedQuery("getAllWardNos").getResultList();
        }catch(PersistenceException e){
            System.out.println(e.getMessage());
        }finally {
            if(em!=null){
                em.close();
            }
        }
        return wardNos;
    }

    @Override
    public List<String[]> getAllPatientsDoctorSickness() {
        List<String[]> list=null;
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            list=em.createNamedQuery("getAllWardNos").getResultList();
        }catch(PersistenceException e){
            System.out.println(e.getMessage());
        }finally {
            if(em!=null){
                em.close();
            }
        }
        return list;
    }
}
