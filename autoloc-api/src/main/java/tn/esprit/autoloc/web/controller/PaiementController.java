package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
public class PaiementController {
    private final IPaiementService paiementService;

    @GetMapping("/find-all")
    public List<Paiement> findAll() {
        return paiementService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Paiement findById(@PathVariable("id") Long id) {
        return paiementService.findById(id);
    }
}
