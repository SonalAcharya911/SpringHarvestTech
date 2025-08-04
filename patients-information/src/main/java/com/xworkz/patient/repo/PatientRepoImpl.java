package com.xworkz.patient.repo;

import com.xworkz.patient.entity.PatientEntity;

import javax.persistence.*;

public class PatientRepoImpl implements PatientRepo {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
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
}
