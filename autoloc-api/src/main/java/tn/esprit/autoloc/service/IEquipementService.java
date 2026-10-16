package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Equipement;
import java.util.List;
import java.util.Set;

public interface IEquipementService {
    Equipement create(Equipement entite);
    Equipement findById(Long id);
    List<Equipement> findAll();
    Equipement update(Long id, Equipement entite);
    void deleteById(Long id);
}
