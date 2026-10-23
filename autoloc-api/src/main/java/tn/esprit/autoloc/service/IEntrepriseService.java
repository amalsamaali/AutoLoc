package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Entreprise;
import java.util.List;

public interface IEntrepriseService {
    List<Entreprise> retrieveAllEntreprises();
    Entreprise addEntreprise(Entreprise e);
    Entreprise updateEntreprise(Entreprise e);
    Entreprise retrieveEntreprise(Long idEntreprise);
    void removeEntreprise(Long idEntreprise);
}
