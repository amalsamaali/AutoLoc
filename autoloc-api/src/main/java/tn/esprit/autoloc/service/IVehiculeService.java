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
}
