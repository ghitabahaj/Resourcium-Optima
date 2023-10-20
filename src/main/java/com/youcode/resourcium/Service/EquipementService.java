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

    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
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

    public void saveEquipement(Equipement equipement) {
        equipementRepository.save(equipement);
    }

    public void updateEquipement(Equipement equipement) {
        equipementRepository.update(equipement);
    }

    public void deleteEquipement(Equipement equipement) {
        equipementRepository.delete(equipement);
    }

}
