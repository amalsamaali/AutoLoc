package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Projet;
import java.util.List;

public interface IProjetService {
    List<Projet> retrieveAllProjets();
    Projet addProjet(Projet p);
    Projet updateProjet(Projet p);
    Projet retrieveProjet(Long idProjet);
    void removeProjet(Long idProjet);
}
