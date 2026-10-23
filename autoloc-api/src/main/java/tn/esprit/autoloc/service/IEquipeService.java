package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Equipe;
import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();
    Equipe addEquipe(Equipe e);
    Equipe updateEquipe(Equipe e);
    Equipe retrieveEquipe(Long idEquipe);
    void removeEquipe(Long idEquipe);
}
