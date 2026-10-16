package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Paiement;
import java.util.List;
import java.util.Set;

public interface IPaiementService {
    Paiement ajouterPaiement(Paiement paiement);
    void supprimerPaiement(long idPaiement);
    List<Paiement> recupererPaiements();
    Set<Paiement> findPaiements();
    Paiement recupererPaiementById(long idPaiement);
}
