package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Projet;
import tn.esprit.autoloc.service.IProjetService;
import java.util.List;

@Tag(name = "Gestion Projet")
@RestController
@AllArgsConstructor
@RequestMapping("/projet")
public class ProjetRestController {
    IProjetService projetService;

    @Operation(description = "récupérer tous les projets de la base de données")
    @GetMapping("/retrieve-all-projets")
    public List<Projet> getProjets() {
        return projetService.retrieveAllProjets();
    }

    @Operation(description = "récupérer un projet par son id")
    @GetMapping("/retrieve-projet/{projet-id}")
    public Projet retrieveProjet(@PathVariable("projet-id") Long projetId) {
        return projetService.retrieveProjet(projetId);
    }

    @Operation(description = "ajouter un projet")
    @PostMapping("/add-projet")
    public Projet addProjet(@RequestBody Projet p) {
        return projetService.addProjet(p);
    }

    @Operation(description = "supprimer un projet")
    @DeleteMapping("/remove-projet/{projet-id}")
    public void removeProjet(@PathVariable("projet-id") Long projetId) {
        projetService.removeProjet(projetId);
    }

    @Operation(description = "modifier un projet")
    @PutMapping("/modify-projet")
    public Projet modifyProjet(@RequestBody Projet p) {
        return projetService.updateProjet(p);
    }
}
