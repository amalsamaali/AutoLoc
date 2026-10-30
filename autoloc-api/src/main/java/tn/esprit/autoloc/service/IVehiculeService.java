package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Vehicule;
import java.util.List;
import java.util.Set;

public interface IVehiculeService {
    Vehicule create(Vehicule entite);
    Vehicule findById(Long id);
    List<Vehicule> findAll();
    Vehicule update(Long id, Vehicule entite);
    void deleteById(Long id);
    Vehicule affecterVehicule(Long idVehicule, Long idAgence);
    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);
}
