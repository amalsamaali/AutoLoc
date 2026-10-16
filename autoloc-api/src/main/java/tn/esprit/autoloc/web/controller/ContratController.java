package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/contrats")
@AllArgsConstructor
public class ContratController {
    private final IContratService contratService;

    @PostMapping("/ajouter")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerContrat(@PathVariable("id") long idContrat) {
        contratService.supprimerContrat(idContrat);
    }

    @GetMapping("/recuperer-tous")
    public List<Contrat> recupererContrats() {
        return contratService.recupererContrats();
    }

    @GetMapping("/trouver-tous")
    public Set<Contrat> findContrats() {
        return contratService.findContrats();
    }

    @GetMapping("/recuperer/{id}")
    public Contrat recupererContratById(@PathVariable("id") long idContrat) {
        return contratService.recupererContratById(idContrat);
    }
}
