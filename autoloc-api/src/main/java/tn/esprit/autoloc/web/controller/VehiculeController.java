package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/vehicules")
@AllArgsConstructor
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @PostMapping("/ajouter")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerVehicule(@PathVariable("id") long idVehicule) {
        vehiculeService.supprimerVehicule(idVehicule);
    }

    @GetMapping("/recuperer-tous")
    public List<Vehicule> recupererVehicules() {
        return vehiculeService.recupererVehicules();
    }

    @GetMapping("/trouver-tous")
    public Set<Vehicule> findVehicules() {
        return vehiculeService.findVehicules();
    }

    @GetMapping("/recuperer/{id}")
    public Vehicule recupererVehiculeById(@PathVariable("id") long idVehicule) {
        return vehiculeService.recupererVehiculeById(idVehicule);
    }
}
