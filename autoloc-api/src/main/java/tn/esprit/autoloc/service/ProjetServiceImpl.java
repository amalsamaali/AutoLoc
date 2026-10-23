package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Projet;
import tn.esprit.autoloc.repository.IProjetRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjetServiceImpl implements IProjetService {
    IProjetRepository projetRepository;

    @Override
    public List<Projet> retrieveAllProjets() {
        return projetRepository.findAll();
    }

    @Override
    public Projet addProjet(Projet p) {
        if (p.getIdProjet() != null && p.getIdProjet() != 0) {
            throw new IllegalArgumentException("L'ID doit être null ou 0 pour une création");
        }
        p.setIdProjet(null);
        return projetRepository.save(p);
    }

    @Override
    public Projet updateProjet(Projet p) {
        if (!projetRepository.existsById(p.getIdProjet())) {
            throw new ResourceNotFoundException("Projet", p.getIdProjet());
        }
        return projetRepository.save(p);
    }

    @Override
    public Projet retrieveProjet(Long idProjet) {
        return projetRepository.findById(idProjet)
                .orElseThrow(() -> new ResourceNotFoundException("Projet", idProjet));
    }

    @Override
    public void removeProjet(Long idProjet) {
        if (!projetRepository.existsById(idProjet)) {
            throw new ResourceNotFoundException("Projet", idProjet);
        }
        projetRepository.deleteById(idProjet);
    }
}
