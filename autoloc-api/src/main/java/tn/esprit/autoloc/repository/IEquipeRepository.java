package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.entity.Equipe;

public interface IEquipeRepository extends JpaRepository<Equipe, Long> {
}
