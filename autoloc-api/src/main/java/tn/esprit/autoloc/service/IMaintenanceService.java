package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Maintenance;
import java.util.List;
import java.util.Set;

public interface IMaintenanceService {
    Maintenance ajouterMaintenance(Maintenance maintenance);
    void supprimerMaintenance(long idMaintenance);
    List<Maintenance> recupererMaintenances();
    Set<Maintenance> findMaintenances();
    Maintenance recupererMaintenanceById(long idMaintenance);
}
