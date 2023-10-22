package com.youcode.resourcium.repository;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Entities.Tache;

import com.youcode.resourcium.Entities.Tache;
import jakarta.persistence.*;

import java.util.List;



public class TacheRepository {

    private EntityManagerFactory entityManagerFactory;

    public TacheRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<Tache> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Tache> query = entityManager.createQuery("SELECT t FROM Tache t", Tache.class);
        return query.getResultList();
    }

    public Tache findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Tache.class, id);
    }

    public Tache save(Tache task) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(task);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // Handle or log the exception as needed
        } finally {
            entityManager.close();
        }
        return task;
    }

    public void update(Tache task) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Tache mergedTask = entityManager.merge(task); // Capture the merged instance
            entityManager.persist(mergedTask); // Persist the changes
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle or log the exception as needed
        } finally {
            entityManager.close();
        }
    }

    public void delete(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Tache task = entityManager.find(Tache.class, id);
            if (task != null) {
                entityManager.remove(task);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle or log the exception as needed
        } finally {
            entityManager.close();
        }
    }


    public List<Tache> getTasksByEmployeeId(Long employeeId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Tache> query = entityManager.createQuery("SELECT t FROM Tache t WHERE t.assignedEmployee.id = :employeeId", Tache.class);
        query.setParameter("employeeId", employeeId);
        return query.getResultList();
    }
    }

