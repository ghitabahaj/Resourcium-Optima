package com.youcode.resourcium.Servlets;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Exceptions.CustomEquipementException;
import com.youcode.resourcium.Service.DepartementService;
import com.youcode.resourcium.Service.EquipementService;
import com.youcode.resourcium.repository.DepartementRepository;
import com.youcode.resourcium.repository.EquipementRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class test {
    public static void main(String[] args) throws CustomEquipementException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EquipementRepository departementRepository = new EquipementRepository(entityManagerFactory);
        EquipementService departementService = new EquipementService(departementRepository);
        try {
            System.out.println(departementService.getAllEquipements());
        } catch (CustomEquipementException e) {
            throw new RuntimeException(e);
        }


    }
}
