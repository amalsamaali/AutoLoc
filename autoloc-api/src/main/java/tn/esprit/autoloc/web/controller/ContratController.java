package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@Tag(name = "Gestion Contrat")
@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
public class ContratController {
    private final IContratService contratService;

    @Operation(description = "créer un contrat")
    @PostMapping("/create")
    public Contrat create(@RequestBody Contrat contrat) {
        return contratService.create(contrat);
    }

    @Operation(description = "supprimer un contrat par son id")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        contratService.deleteById(id);
    }

    @Operation(description = "récupérer tous les contrats")
    @GetMapping("/find-all")
    public List<Contrat> findAll() {
        return contratService.findAll();
    }

    @Operation(description = "récupérer un contrat par son id")
    @GetMapping("/find-by-id/{id}")
    public Contrat findById(@PathVariable("id") Long id) {
        return contratService.findById(id);
    }

    @Operation(description = "modifier un contrat")
    @PutMapping("/update/{id}")
    public Contrat update(@PathVariable("id") Long id, @RequestBody Contrat contrat) {
        return contratService.update(id, contrat);
    }
}
