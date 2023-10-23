package com.youcode.resourcium.repository;

import com.youcode.resourcium.Entities.Equipement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EquipementRepository {


    private EntityManagerFactory entityManagerFactory;


    public EquipementRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<Equipement> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Equipement> query = entityManager.createQuery("SELECT e FROM Equipement e", Equipement.class);
        return query.getResultList();
    }

    public Equipement findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Equipement.class, id);
    }

    public void save(Equipement equipement) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.persist(equipement);
    }

    public void update(Equipement equipement) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.merge(equipement);
    }

    public void delete(Equipement equipement) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.remove(equipement);
    }

    public Equipement getEquipementById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Equipement.class, id);
    }



}
