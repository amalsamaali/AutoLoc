package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/equipements")
@AllArgsConstructor
public class EquipementController {
    private final IEquipementService equipementService;

    @PostMapping("/ajouter")
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerEquipement(@PathVariable("id") long idEquipement) {
        equipementService.supprimerEquipement(idEquipement);
    }

    @GetMapping("/recuperer-tous")
    public List<Equipement> recupererEquipements() {
        return equipementService.recupererEquipements();
    }

    @GetMapping("/trouver-tous")
    public Set<Equipement> findEquipements() {
        return equipementService.findEquipements();
    }

    @GetMapping("/recuperer/{id}")
    public Equipement recupererEquipementById(@PathVariable("id") long idEquipement) {
        return equipementService.recupererEquipementById(idEquipement);
    }
}
