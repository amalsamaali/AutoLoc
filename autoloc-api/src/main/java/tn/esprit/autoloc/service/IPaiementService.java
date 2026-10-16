package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Paiement;
import java.util.List;
import java.util.Set;

public interface IPaiementService {
    Paiement findById(Long id);
    List<Paiement> findAll();
}
