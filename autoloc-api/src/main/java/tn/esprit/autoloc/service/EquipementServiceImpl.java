package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Equipement;
import tn.esprit.autoloc.repository.IEquipementRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EquipementServiceImpl implements IEquipementService {
    private final IEquipementRepository equipementRepository;

    @Override
    public Equipement ajouterEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public void supprimerEquipement(long idEquipement) {
        equipementRepository.deleteById(idEquipement);
    }

    @Override
    public List<Equipement> recupererEquipements() {
        return equipementRepository.findAll();
    }

    @Override
    public Set<Equipement> findEquipements() {
        return new HashSet<>(equipementRepository.findAll());
    }

    @Override
    public Equipement recupererEquipementById(long idEquipement) {
        return equipementRepository.findById(idEquipement).orElse(null);
    }
}
