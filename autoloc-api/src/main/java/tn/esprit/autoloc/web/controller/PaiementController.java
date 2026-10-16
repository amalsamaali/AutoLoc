package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/paiements")
@AllArgsConstructor
public class PaiementController {
    private final IPaiementService paiementService;

    @PostMapping("/ajouter")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerPaiement(@PathVariable("id") long idPaiement) {
        paiementService.supprimerPaiement(idPaiement);
    }

    @GetMapping("/recuperer-tous")
    public List<Paiement> recupererPaiements() {
        return paiementService.recupererPaiements();
    }

    @GetMapping("/trouver-tous")
    public Set<Paiement> findPaiements() {
        return paiementService.findPaiements();
    }

    @GetMapping("/recuperer/{id}")
    public Paiement recupererPaiementById(@PathVariable("id") long idPaiement) {
        return paiementService.recupererPaiementById(idPaiement);
    }
}
