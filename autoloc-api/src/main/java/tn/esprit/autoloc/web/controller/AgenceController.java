package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@Tag(name = "Gestion Agence")
@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
public class AgenceController {
    private final IAgenceService agenceService;

    @Operation(description = "créer une agence")
    @PostMapping("/create")
    public Agence create(@RequestBody Agence agence) {
        return agenceService.create(agence);
    }

    @Operation(description = "supprimer une agence par son id")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        agenceService.deleteById(id);
    }

    @Operation(description = "récupérer toutes les agences")
    @GetMapping("/find-all")
    public List<Agence> findAll() {
        return agenceService.findAll();
    }

    @Operation(description = "récupérer une agence par son id")
    @GetMapping("/find-by-id/{id}")
    public Agence findById(@PathVariable("id") Long id) {
        return agenceService.findById(id);
    }

    @Operation(description = "modifier une agence")
    @PutMapping("/update/{id}")
    public Agence update(@PathVariable("id") Long id, @RequestBody Agence agence) {
        return agenceService.update(id, agence);
    }
}
