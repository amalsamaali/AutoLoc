package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.ProjetDetail;
import tn.esprit.autoloc.service.IProjetDetailService;
import java.util.List;

@Tag(name = "Gestion Projet Detail")
@RestController
@AllArgsConstructor
@RequestMapping("/projet-detail")
public class ProjetDetailRestController {
    IProjetDetailService projetDetailService;

    @Operation(description = "récupérer tous les détails de projets de la base de données")
    @GetMapping("/retrieve-all-projet-details")
    public List<ProjetDetail> getProjetDetails() {
        return projetDetailService.retrieveAllProjetDetails();
    }

    @Operation(description = "récupérer un détail de projet par son id")
    @GetMapping("/retrieve-projet-detail/{projet-detail-id}")
    public ProjetDetail retrieveProjetDetail(@PathVariable("projet-detail-id") Long projetDetailId) {
        return projetDetailService.retrieveProjetDetail(projetDetailId);
    }

    @Operation(description = "ajouter un détail de projet")
    @PostMapping("/add-projet-detail")
    public ProjetDetail addProjetDetail(@RequestBody ProjetDetail pd) {
        return projetDetailService.addProjetDetail(pd);
    }

    @Operation(description = "supprimer un détail de projet")
    @DeleteMapping("/remove-projet-detail/{projet-detail-id}")
    public void removeProjetDetail(@PathVariable("projet-detail-id") Long projetDetailId) {
        projetDetailService.removeProjetDetail(projetDetailId);
    }

    @Operation(description = "modifier un détail de projet")
    @PutMapping("/modify-projet-detail")
    public ProjetDetail modifyProjetDetail(@RequestBody ProjetDetail pd) {
        return projetDetailService.updateProjetDetail(pd);
    }
}
