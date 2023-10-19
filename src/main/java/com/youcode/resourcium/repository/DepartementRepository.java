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

    public Departement findById(int id) {

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
        entityManager.merge(department);
    }

    public void delete(Departement department) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.remove(department);
    }

}
