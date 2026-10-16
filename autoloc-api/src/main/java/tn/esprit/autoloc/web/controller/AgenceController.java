package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/agences")
@AllArgsConstructor
public class AgenceController {
    private final IAgenceService agenceService;

    @PostMapping("/ajouter")
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerAgence(@PathVariable("id") long idAgence) {
        agenceService.supprimerAgence(idAgence);
    }

    @GetMapping("/recuperer-tous")
    public List<Agence> recupererAgences() {
        return agenceService.recupererAgences();
    }

    @GetMapping("/trouver-tous")
    public Set<Agence> findAgences() {
        return agenceService.findAgences();
    }

    @GetMapping("/recuperer/{id}")
    public Agence recupererAgenceById(@PathVariable("id") long idAgence) {
        return agenceService.recupererAgenceById(idAgence);
    }
}
