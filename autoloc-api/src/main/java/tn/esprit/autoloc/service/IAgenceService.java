package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Agence;
import java.util.List;
import java.util.Set;

public interface IAgenceService {
    Agence ajouterAgence(Agence agence);
    void supprimerAgence(long idAgence);
    List<Agence> recupererAgences();
    Set<Agence> findAgences();
    Agence recupererAgenceById(long idAgence);
}
