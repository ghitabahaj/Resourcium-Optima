package com.youcode.resourcium.Service;

import com.youcode.resourcium.Entities.Equipement;
import com.youcode.resourcium.Exceptions.CustomEquipementException;
import com.youcode.resourcium.Exceptions.EquipementNotFoundException;
import com.youcode.resourcium.repository.EquipementRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class EquipementService {
    private final EquipementRepository equipementRepository;

    public EquipementService(EquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    public List<Equipement> getAllEquipements() throws CustomEquipementException {
        try {
            return equipementRepository.findAll();
        } catch (Exception e) {
            throw new CustomEquipementException("Failed to retrieve all equipements", e);
        }
    }

    public Equipement getEquipementById(int id) throws EquipementNotFoundException, CustomEquipementException {
        try {
            return equipementRepository.findById(id);
        } catch (NoSuchElementException e) {
            throw new EquipementNotFoundException("Equipement not found with ID: " + id, e);
        } catch (Exception e) {
            throw new CustomEquipementException("Failed to retrieve equipement with ID: " + id, e);
        }
    }

    public void saveEquipement(Equipement equipement) throws CustomEquipementException {
        try {
            equipementRepository.save(equipement);
        } catch (Exception e) {
            throw new CustomEquipementException("Failed to save equipement", e);
        }
    }

    public void updateEquipement(Equipement equipement) throws CustomEquipementException {
        try {
            equipementRepository.update(equipement);
        } catch (Exception e) {
            throw new CustomEquipementException("Failed to update equipement", e);
        }
    }

    public void deleteEquipement(Equipement equipement) throws CustomEquipementException {
        try {
            equipementRepository.delete(equipement);
        } catch (Exception e) {
            throw new CustomEquipementException("Failed to delete equipement", e);
        }
    }

    public Equipement getEquipementById(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid equipement ID");
        }
        Equipement equipement = equipementRepository.getEquipementById(id);
        if (equipement == null) {
            throw new IllegalArgumentException("Equipement not found for ID: " + id);
        }
        return equipement;
    }

}
