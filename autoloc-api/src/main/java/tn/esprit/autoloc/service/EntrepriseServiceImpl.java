package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Entreprise;
import tn.esprit.autoloc.repository.IEntrepriseRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class EntrepriseServiceImpl implements IEntrepriseService {
    IEntrepriseRepository entrepriseRepository;

    @Override
    public List<Entreprise> retrieveAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    @Override
    public Entreprise addEntreprise(Entreprise e) {
        if (e.getIdEntreprise() != null && e.getIdEntreprise() != 0) {
            throw new IllegalArgumentException("L'ID doit être null ou 0 pour une création");
        }
        e.setIdEntreprise(null);
        return entrepriseRepository.save(e);
    }

    @Override
    public Entreprise updateEntreprise(Entreprise e) {
        if (!entrepriseRepository.existsById(e.getIdEntreprise())) {
            throw new ResourceNotFoundException("Entreprise", e.getIdEntreprise());
        }
        return entrepriseRepository.save(e);
    }

    @Override
    public Entreprise retrieveEntreprise(Long idEntreprise) {
        return entrepriseRepository.findById(idEntreprise)
                .orElseThrow(() -> new ResourceNotFoundException("Entreprise", idEntreprise));
    }

    @Override
    public void removeEntreprise(Long idEntreprise) {
        if (!entrepriseRepository.existsById(idEntreprise)) {
            throw new ResourceNotFoundException("Entreprise", idEntreprise);
        }
        entrepriseRepository.deleteById(idEntreprise);
    }
}
