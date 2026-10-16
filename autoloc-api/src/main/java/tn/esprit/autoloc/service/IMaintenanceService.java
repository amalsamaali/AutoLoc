package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Maintenance;
import java.util.List;
import java.util.Set;

public interface IMaintenanceService {
    Maintenance create(Maintenance entite);
    Maintenance findById(Long id);
    List<Maintenance> findAll();
    Maintenance update(Long id, Maintenance entite);
    void deleteById(Long id);
}
