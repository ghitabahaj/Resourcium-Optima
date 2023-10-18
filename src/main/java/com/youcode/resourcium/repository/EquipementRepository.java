package com.youcode.resourcium.repository;

import com.youcode.resourcium.Entities.Equipement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EquipementRepository {

    private EntityManager entityManager;

    public List<Equipement> findAll() {
        TypedQuery<Equipement> query = entityManager.createQuery("SELECT e FROM Equipement e", Equipement.class);
        return query.getResultList();
    }

    public Equipement findById(int id) {
        return entityManager.find(Equipement.class, id);
    }

    public void save(Equipement equipement) {
        entityManager.persist(equipement);
    }

    public void update(Equipement equipement) {
        entityManager.merge(equipement);
    }

    public void delete(Equipement equipement) {
        entityManager.remove(equipement);
    }



}
