package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
public class EquipementController {
    private final IEquipementService equipementService;

    @PostMapping("/create")
    public Equipement create(@RequestBody Equipement equipement) {
        return equipementService.create(equipement);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        equipementService.deleteById(id);
    }

    @GetMapping("/find-all")
    public List<Equipement> findAll() {
        return equipementService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Equipement findById(@PathVariable("id") Long id) {
        return equipementService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Equipement update(@PathVariable("id") Long id, @RequestBody Equipement equipement) {
        return equipementService.update(id, equipement);
    }
}
