package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Equipement;
import tn.esprit.autoloc.repository.IEquipementRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipementService {
    private final IEquipementRepository equipementRepository;

    @Override
    public Equipement create(Equipement entite) {
        if (entite.getIdEquipement() != null) {
            throw new IllegalArgumentException("L'ID doit être null pour une création");
        }
        if (entite.getLibelle() == null || entite.getLibelle().isEmpty()) {
            throw new IllegalArgumentException("Le libellé de l'équipement est obligatoire");
        }
        return equipementRepository.save(entite);
    }

    @Override
    public Equipement findById(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipement", id));
    }

    @Override
    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement update(Long id, Equipement entite) {
        Equipement existant = findById(id);
        if (entite.getLibelle() == null || entite.getLibelle().isEmpty()) {
            throw new IllegalArgumentException("Le libellé de l'équipement est obligatoire");
        }
        existant.setLibelle(entite.getLibelle());
        existant.setVehicules(entite.getVehicules());
        return equipementRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!equipementRepository.existsById(id)) {
            throw new ResourceNotFoundException("Equipement", id);
        }
        equipementRepository.deleteById(id);
    }
}
