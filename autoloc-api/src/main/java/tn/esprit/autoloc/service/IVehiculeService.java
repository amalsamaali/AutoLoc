package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Vehicule;
import java.util.List;
import java.util.Set;

public interface IVehiculeService {
    Vehicule ajouterVehicule(Vehicule vehicule);
    void supprimerVehicule(long idVehicule);
    List<Vehicule> recupererVehicules();
    Set<Vehicule> findVehicules();
    Vehicule recupererVehiculeById(long idVehicule);
}
