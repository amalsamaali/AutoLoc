package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@Tag(name = "Gestion Maintenance")
@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @Operation(description = "créer une maintenance")
    @PostMapping("/create")
    public Maintenance create(@RequestBody Maintenance maintenance) {
        return maintenanceService.create(maintenance);
    }

    @Operation(description = "supprimer une maintenance par son id")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        maintenanceService.deleteById(id);
    }

    @Operation(description = "récupérer toutes les maintenances")
    @GetMapping("/find-all")
    public List<Maintenance> findAll() {
        return maintenanceService.findAll();
    }

    @Operation(description = "récupérer une maintenance par son id")
    @GetMapping("/find-by-id/{id}")
    public Maintenance findById(@PathVariable("id") Long id) {
        return maintenanceService.findById(id);
    }

    @Operation(description = "modifier une maintenance")
    @PutMapping("/update/{id}")
    public Maintenance update(@PathVariable("id") Long id, @RequestBody Maintenance maintenance) {
        return maintenanceService.update(id, maintenance);
    }
}
