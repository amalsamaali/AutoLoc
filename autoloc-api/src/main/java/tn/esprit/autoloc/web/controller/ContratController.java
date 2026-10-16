package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
public class ContratController {
    private final IContratService contratService;

    @PostMapping("/create")
    public Contrat create(@RequestBody Contrat contrat) {
        return contratService.create(contrat);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        contratService.deleteById(id);
    }

    @GetMapping("/find-all")
    public List<Contrat> findAll() {
        return contratService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Contrat findById(@PathVariable("id") Long id) {
        return contratService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Contrat update(@PathVariable("id") Long id, @RequestBody Contrat contrat) {
        return contratService.update(id, contrat);
    }
}
