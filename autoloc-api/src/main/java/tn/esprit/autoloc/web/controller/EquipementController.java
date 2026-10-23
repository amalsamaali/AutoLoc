package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@Tag(name = "Gestion Equipement")
@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
public class EquipementController {
    private final IEquipementService equipementService;

    @Operation(description = "créer un équipement")
    @PostMapping("/create")
    public Equipement create(@RequestBody Equipement equipement) {
        return equipementService.create(equipement);
    }

    @Operation(description = "supprimer un équipement par son id")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        equipementService.deleteById(id);
    }

    @Operation(description = "récupérer tous les équipements")
    @GetMapping("/find-all")
    public List<Equipement> findAll() {
        return equipementService.findAll();
    }

    @Operation(description = "récupérer un équipement par son id")
    @GetMapping("/find-by-id/{id}")
    public Equipement findById(@PathVariable("id") Long id) {
        return equipementService.findById(id);
    }

    @Operation(description = "modifier un équipement")
    @PutMapping("/update/{id}")
    public Equipement update(@PathVariable("id") Long id, @RequestBody Equipement equipement) {
        return equipementService.update(id, equipement);
    }
}
