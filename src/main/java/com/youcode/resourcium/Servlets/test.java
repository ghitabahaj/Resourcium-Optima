package com.youcode.resourcium.Servlets;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Service.DepartementService;
import com.youcode.resourcium.repository.DepartementRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class test {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        DepartementRepository departementRepository = new DepartementRepository(entityManagerFactory);
        DepartementService departementService = new DepartementService(departementRepository);
        System.out.println(departementService.saveDepartement(new Departement("depp","dep")));

    }
}
