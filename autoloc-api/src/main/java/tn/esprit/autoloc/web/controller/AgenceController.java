package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
public class AgenceController {
    private final IAgenceService agenceService;

    @PostMapping("/create")
    public Agence create(@RequestBody Agence agence) {
        return agenceService.create(agence);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        agenceService.deleteById(id);
    }

    @GetMapping("/find-all")
    public List<Agence> findAll() {
        return agenceService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Agence findById(@PathVariable("id") Long id) {
        return agenceService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Agence update(@PathVariable("id") Long id, @RequestBody Agence agence) {
        return agenceService.update(id, agence);
    }
}
