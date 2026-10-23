package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Agence;
import tn.esprit.autoloc.repository.IAgenceRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {
    private final IAgenceRepository agenceRepository;

    @Override
    public Agence create(Agence entite) {
        if (entite.getIdAgence() != null && entite.getIdAgence() != 0) {
            throw new IllegalArgumentException("L'ID doit être null ou 0 pour une création");
        }
        entite.setIdAgence(null);
        if (entite.getNom() == null || entite.getNom().isEmpty() || entite.getVille() == null || entite.getVille().isEmpty()) {
            throw new IllegalArgumentException("Le nom et la ville de l'agence sont obligatoires");
        }
        return agenceRepository.save(entite);
    }

    @Override
    public Agence findById(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agence", id));
    }

    @Override
    public List<Agence> findAll() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence update(Long id, Agence entite) {
        Agence existant = findById(id);
        if (entite.getNom() == null || entite.getNom().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'agence est obligatoire");
        }
        existant.setNom(entite.getNom());
        existant.setVille(entite.getVille());
        existant.setAdresse(entite.getAdresse());
        existant.setTelephone(entite.getTelephone());
        return agenceRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!agenceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Agence", id);
        }
        agenceRepository.deleteById(id);
    }
}
