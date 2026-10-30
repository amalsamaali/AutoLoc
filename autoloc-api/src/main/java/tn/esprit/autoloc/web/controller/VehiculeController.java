package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@Tag(name = "Gestion Vehicule")
@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @Operation(description = "créer un véhicule")
    @PostMapping("/create")
    public Vehicule create(@RequestBody Vehicule vehicule) {
        return vehiculeService.create(vehicule);
    }

    @Operation(description = "supprimer un véhicule par son id")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        vehiculeService.deleteById(id);
    }

    @Operation(description = "récupérer tous les véhicules")
    @GetMapping("/find-all")
    public List<Vehicule> findAll() {
        return vehiculeService.findAll();
    }

    @Operation(description = "récupérer un véhicule par son id")
    @GetMapping("/find-by-id/{id}")
    public Vehicule findById(@PathVariable("id") Long id) {
        return vehiculeService.findById(id);
    }

    @Operation(description = "modifier un véhicule")
    @PutMapping("/update/{id}")
    public Vehicule update(@PathVariable("id") Long id, @RequestBody Vehicule vehicule) {
        return vehiculeService.update(id, vehicule);
    }

    @Operation(description = "affecter un véhicule à une agence")
    @PutMapping("/affecter-agence/{idVehicule}/{idAgence}")
    public Vehicule affecterVehicule(@PathVariable("idVehicule") Long idVehicule, @PathVariable("idAgence") Long idAgence) {
        return vehiculeService.affecterVehicule(idVehicule, idAgence);
    }

    @Operation(description = "affecter un équipement à un véhicule")
    @PutMapping("/affecter-equipement/{idVehicule}/{idEquipement}")
    public Vehicule affecterEquipement(@PathVariable("idVehicule") Long idVehicule, @PathVariable("idEquipement") Long idEquipement) {
        return vehiculeService.affecterEquipement(idVehicule, idEquipement);
    }

    @Operation(description = "désaffecter un équipement d'un véhicule")
    @PutMapping("/desaffecter-equipement/{idVehicule}/{idEquipement}")
    public Vehicule desaffecterEquipement(@PathVariable("idVehicule") Long idVehicule, @PathVariable("idEquipement") Long idEquipement) {
        return vehiculeService.desaffecterEquipement(idVehicule, idEquipement);
    }
}
