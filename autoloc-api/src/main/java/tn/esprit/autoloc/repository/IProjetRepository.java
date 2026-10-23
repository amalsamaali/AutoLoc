package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.entity.Projet;

public interface IProjetRepository extends JpaRepository<Projet, Long> {
}
