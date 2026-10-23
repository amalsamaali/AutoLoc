package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Equipe;
import tn.esprit.autoloc.service.IEquipeService;
import java.util.List;

@Tag(name = "Gestion Equipe")
@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeRestController {
    IEquipeService equipeService;

    @Operation(description = "récupérer toutes les équipes de la base de données")
    @GetMapping("/retrieve-all-equipes")
    public List<Equipe> getEquipes() {
        return equipeService.retrieveAllEquipes();
    }

    @Operation(description = "récupérer une équipe par son id")
    @GetMapping("/retrieve-equipe/{equipe-id}")
    public Equipe retrieveEquipe(@PathVariable("equipe-id") Long equipeId) {
        return equipeService.retrieveEquipe(equipeId);
    }

    @Operation(description = "ajouter une équipe")
    @PostMapping("/add-equipe")
    public Equipe addEquipe(@RequestBody Equipe e) {
        return equipeService.addEquipe(e);
    }

    @Operation(description = "supprimer une équipe")
    @DeleteMapping("/remove-equipe/{equipe-id}")
    public void removeEquipe(@PathVariable("equipe-id") Long equipeId) {
        equipeService.removeEquipe(equipeId);
    }

    @Operation(description = "modifier une équipe")
    @PutMapping("/modify-equipe")
    public Equipe modifyEquipe(@RequestBody Equipe e) {
        return equipeService.updateEquipe(e);
    }
}
