package com.youcode.resourcium.Service;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.repository.DepartementRepository;

import java.util.List;

public class DepartementService {
    private final DepartementRepository departmentRepository;

    public DepartementService(DepartementRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Departement> getAllDepartements() {
        return departmentRepository.findAll();
    }

    public Departement getDepartementById(int id) {
        return departmentRepository.findById(id);
    }

    public void saveDepartement(Departement department) {
        departmentRepository.save(department);
    }

    public void updateDepartement(Departement department) {
        departmentRepository.update(department);
    }

    public void deleteDepartement(Departement department) {
        departmentRepository.delete(department);
    }


}
