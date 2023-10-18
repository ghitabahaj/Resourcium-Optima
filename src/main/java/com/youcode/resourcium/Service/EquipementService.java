package com.youcode.resourcium.Service;

import com.youcode.resourcium.Entities.Equipement;
import com.youcode.resourcium.repository.EquipementRepository;

import java.util.List;

public class EquipementService {
    private final EquipementRepository equipementRepository;

    public EquipementService(EquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }

    public Equipement getEquipementById(int id) {
        return equipementRepository.findById(id);
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

    // Add more methods as needed

}
