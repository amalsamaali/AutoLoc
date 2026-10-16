package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Contrat;
import tn.esprit.autoloc.repository.IContratRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService {
    private final IContratRepository contratRepository;

    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void supprimerContrat(long idContrat) {
        contratRepository.deleteById(idContrat);
    }

    @Override
    public List<Contrat> recupererContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Set<Contrat> findContrats() {
        return new HashSet<>(contratRepository.findAll());
    }

    @Override
    public Contrat recupererContratById(long idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }
}
