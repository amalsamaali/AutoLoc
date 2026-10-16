package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Contrat;
import java.util.List;
import java.util.Set;

public interface IContratService {
    Contrat ajouterContrat(Contrat contrat);
    void supprimerContrat(long idContrat);
    List<Contrat> recupererContrats();
    Set<Contrat> findContrats();
    Contrat recupererContratById(long idContrat);
}
