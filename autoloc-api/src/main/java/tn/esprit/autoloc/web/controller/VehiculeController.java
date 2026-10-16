package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @PostMapping("/create")
    public Vehicule create(@RequestBody Vehicule vehicule) {
        return vehiculeService.create(vehicule);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        vehiculeService.deleteById(id);
    }

    @GetMapping("/find-all")
    public List<Vehicule> findAll() {
        return vehiculeService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Vehicule findById(@PathVariable("id") Long id) {
        return vehiculeService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Vehicule update(@PathVariable("id") Long id, @RequestBody Vehicule vehicule) {
        return vehiculeService.update(id, vehicule);
    }
}
