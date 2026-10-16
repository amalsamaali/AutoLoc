package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Contrat;
import tn.esprit.autoloc.repository.IContratRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {
    private final IContratRepository contratRepository;

    @Override
    public Contrat create(Contrat entite) {
        if (entite.getIdContrat() != null) {
            throw new IllegalArgumentException("L'ID doit être null pour une création");
        }
        if (entite.getMontantTotal() != null && entite.getMontantTotal().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Le montant total ne peut pas être négatif");
        }
        return contratRepository.save(entite);
    }

    @Override
    public Contrat findById(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat", id));
    }

    @Override
    public List<Contrat> findAll() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat update(Long id, Contrat entite) {
        Contrat existant = findById(id);
        if (entite.getMontantTotal() != null && entite.getMontantTotal().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Le montant total ne peut pas être négatif");
        }
        existant.setDateSignature(entite.getDateSignature());
        existant.setMontantTotal(entite.getMontantTotal());
        existant.setValide(entite.isValide());
        existant.setReservation(entite.getReservation());
        // On ne touche pas à la collection de paiements ici selon les instructions
        return contratRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!contratRepository.existsById(id)) {
            throw new ResourceNotFoundException("Contrat", id);
        }
        contratRepository.deleteById(id);
    }
}
