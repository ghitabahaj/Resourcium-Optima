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
        return this.departmentRepository.findAll();
    }

    public Departement getDepartementById(Long id) {
        return departmentRepository.findById(id);
    }

    public Departement saveDepartement(Departement department) {

        if (department.getName() == null || department.getName().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be null or empty");
        }
         return departmentRepository.save(department);
    }

    public void updateDepartement(Departement department) {
        departmentRepository.update(department);
    }

    public void deleteDepartement(Long id) {
        departmentRepository.delete(id);
    }


}
