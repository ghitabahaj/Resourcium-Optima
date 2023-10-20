package com.youcode.resourcium.repository;

import com.youcode.resourcium.Entities.Departement;
import jakarta.persistence.*;

import java.util.List;

public class DepartementRepository {


    private EntityManagerFactory entityManagerFactory;

    public DepartementRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<Departement> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Departement> query = entityManager.createQuery("SELECT d FROM Departement d", Departement.class);
        return query.getResultList();
    }

    public Departement findById(Long id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Departement.class, id);
    }

    public Departement save(Departement department) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(department);
        tx.commit();
        return  department;
    }

    public void update(Departement department) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Departement mergedDepartment = entityManager.merge(department); // Capture the merged instance
            entityManager.persist(mergedDepartment); // Persist the changes
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

    public void delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Departement department = entityManager.find(Departement.class, id);
            if (department != null) {
                entityManager.remove(department);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            // Handle the exception appropriately
        } finally {
            entityManager.close();
        }
    }

}
