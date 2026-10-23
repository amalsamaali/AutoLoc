package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Entreprise;
import tn.esprit.autoloc.service.IEntrepriseService;
import java.util.List;

@Tag(name = "Gestion Entreprise")
@RestController
@AllArgsConstructor
@RequestMapping("/entreprise")
public class EntrepriseRestController {
    IEntrepriseService entrepriseService;

    @Operation(description = "récupérer toutes les entreprises de la base de données")
    @GetMapping("/retrieve-all-entreprises")
    public List<Entreprise> getEntreprises() {
        return entrepriseService.retrieveAllEntreprises();
    }

    @Operation(description = "récupérer une entreprise par son id")
    @GetMapping("/retrieve-entreprise/{entreprise-id}")
    public Entreprise retrieveEntreprise(@PathVariable("entreprise-id") Long entrepriseId) {
        return entrepriseService.retrieveEntreprise(entrepriseId);
    }

    @Operation(description = "ajouter une entreprise")
    @PostMapping("/add-entreprise")
    public Entreprise addEntreprise(@RequestBody Entreprise e) {
        return entrepriseService.addEntreprise(e);
    }

    @Operation(description = "supprimer une entreprise")
    @DeleteMapping("/remove-entreprise/{entreprise-id}")
    public void removeEntreprise(@PathVariable("entreprise-id") Long entrepriseId) {
        entrepriseService.removeEntreprise(entrepriseId);
    }

    @Operation(description = "modifier une entreprise")
    @PutMapping("/modify-entreprise")
    public Entreprise modifyEntreprise(@RequestBody Entreprise e) {
        return entrepriseService.updateEntreprise(e);
    }
}
