package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Contrat;
import java.util.List;
import java.util.Set;

public interface IContratService {
    Contrat create(Contrat entite);
    Contrat findById(Long id);
    List<Contrat> findAll();
    Contrat update(Long id, Contrat entite);
    void deleteById(Long id);
}
