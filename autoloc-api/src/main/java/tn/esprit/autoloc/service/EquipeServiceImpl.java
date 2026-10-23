package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Equipe;
import tn.esprit.autoloc.repository.IEquipeRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService {
    IEquipeRepository equipeRepository;

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        if (e.getIdEquipe() != null && e.getIdEquipe() != 0) {
            throw new IllegalArgumentException("L'ID doit être null ou 0 pour une création");
        }
        e.setIdEquipe(null);
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        if (!equipeRepository.existsById(e.getIdEquipe())) {
            throw new ResourceNotFoundException("Equipe", e.getIdEquipe());
        }
        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Long idEquipe) {
        return equipeRepository.findById(idEquipe)
                .orElseThrow(() -> new ResourceNotFoundException("Equipe", idEquipe));
    }

    @Override
    public void removeEquipe(Long idEquipe) {
        if (!equipeRepository.existsById(idEquipe)) {
            throw new ResourceNotFoundException("Equipe", idEquipe);
        }
        equipeRepository.deleteById(idEquipe);
    }
}
