package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.entity.ProjetDetail;

public interface IProjetDetailRepository extends JpaRepository<ProjetDetail, Long> {
}
