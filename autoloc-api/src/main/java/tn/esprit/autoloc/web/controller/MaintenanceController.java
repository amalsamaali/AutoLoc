package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/maintenances")
@AllArgsConstructor
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @PostMapping("/ajouter")
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerMaintenance(@PathVariable("id") long idMaintenance) {
        maintenanceService.supprimerMaintenance(idMaintenance);
    }

    @GetMapping("/recuperer-tous")
    public List<Maintenance> recupererMaintenances() {
        return maintenanceService.recupererMaintenances();
    }

    @GetMapping("/trouver-tous")
    public Set<Maintenance> findMaintenances() {
        return maintenanceService.findMaintenances();
    }

    @GetMapping("/recuperer/{id}")
    public Maintenance recupererMaintenanceById(@PathVariable("id") long idMaintenance) {
        return maintenanceService.recupererMaintenanceById(idMaintenance);
    }
}
