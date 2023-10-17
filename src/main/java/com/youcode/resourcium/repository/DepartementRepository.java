package com.youcode.resourcium.repository;

import com.youcode.resourcium.Entities.Departement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DepartementRepository {

    private EntityManager entityManager;

    public List<Departement> findAll() {
        TypedQuery<Departement> query = entityManager.createQuery("SELECT d FROM Departement d", Departement.class);
        return query.getResultList();
    }

    public Departement findById(int id) {
        return entityManager.find(Departement.class, id);
    }

    public void save(Departement department) {
        entityManager.persist(department);
    }

    public void update(Departement department) {
        entityManager.merge(department);
    }

    public void delete(Departement department) {
        entityManager.remove(department);
    }

}
