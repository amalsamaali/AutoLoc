package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@Tag(name = "Gestion Paiement")
@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
public class PaiementController {
    private final IPaiementService paiementService;

    @Operation(description = "récupérer tous les paiements")
    @GetMapping("/find-all")
    public List<Paiement> findAll() {
        return paiementService.findAll();
    }

    @Operation(description = "récupérer un paiement par son id")
    @GetMapping("/find-by-id/{id}")
    public Paiement findById(@PathVariable("id") Long id) {
        return paiementService.findById(id);
    }
}
