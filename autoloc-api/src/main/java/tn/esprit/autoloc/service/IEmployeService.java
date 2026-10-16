package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Employe;
import java.util.List;
import java.util.Set;

public interface IEmployeService {
    Employe ajouterEmploye(Employe employe);
    void supprimerEmploye(long idEmploye);
    List<Employe> recupererEmployes();
    Set<Employe> findEmployes();
    Employe recupererEmployeById(long idEmploye);
}
