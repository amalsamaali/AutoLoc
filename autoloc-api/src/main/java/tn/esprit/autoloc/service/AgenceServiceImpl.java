package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Agence;
import tn.esprit.autoloc.repository.IAgenceRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AgenceServiceImpl implements IAgenceService {
    private final IAgenceRepository agenceRepository;

    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void supprimerAgence(long idAgence) {
        agenceRepository.deleteById(idAgence);
    }

    @Override
    public List<Agence> recupererAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Set<Agence> findAgences() {
        return new HashSet<>(agenceRepository.findAll());
    }

    @Override
    public Agence recupererAgenceById(long idAgence) {
        return agenceRepository.findById(idAgence).orElse(null);
    }
}
