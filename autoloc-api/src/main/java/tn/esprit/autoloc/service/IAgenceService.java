package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Agence;
import java.util.List;
import java.util.Set;

public interface IAgenceService {
    Agence create(Agence entite);
    Agence findById(Long id);
    List<Agence> findAll();
    Agence update(Long id, Agence entite);
    void deleteById(Long id);
}
