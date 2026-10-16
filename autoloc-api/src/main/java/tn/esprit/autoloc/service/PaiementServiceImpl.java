package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Paiement;
import tn.esprit.autoloc.repository.IPaiementRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements IPaiementService {
    private final IPaiementRepository paiementRepository;

    @Override
    public Paiement ajouterPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public void supprimerPaiement(long idPaiement) {
        paiementRepository.deleteById(idPaiement);
    }

    @Override
    public List<Paiement> recupererPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Set<Paiement> findPaiements() {
        return new HashSet<>(paiementRepository.findAll());
    }

    @Override
    public Paiement recupererPaiementById(long idPaiement) {
        return paiementRepository.findById(idPaiement).orElse(null);
    }
}
