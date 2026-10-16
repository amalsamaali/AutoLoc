package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Employe;
import java.util.List;
import java.util.Set;

public interface IEmployeService {
    Employe create(Employe entite);
    Employe findById(Long id);
    List<Employe> findAll();
    Employe update(Long id, Employe entite);
    void deleteById(Long id);
}
