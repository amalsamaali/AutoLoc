package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Equipement;
import java.util.List;
import java.util.Set;

public interface IEquipementService {
    Equipement ajouterEquipement(Equipement equipement);
    void supprimerEquipement(long idEquipement);
    List<Equipement> recupererEquipements();
    Set<Equipement> findEquipements();
    Equipement recupererEquipementById(long idEquipement);
}
