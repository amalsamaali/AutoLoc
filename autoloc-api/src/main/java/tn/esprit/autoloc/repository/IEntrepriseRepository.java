package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.entity.Entreprise;

public interface IEntrepriseRepository extends JpaRepository<Entreprise, Long> {
}
