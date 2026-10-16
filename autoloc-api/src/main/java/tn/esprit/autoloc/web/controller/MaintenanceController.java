package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @PostMapping("/create")
    public Maintenance create(@RequestBody Maintenance maintenance) {
        return maintenanceService.create(maintenance);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        maintenanceService.deleteById(id);
    }

    @GetMapping("/find-all")
    public List<Maintenance> findAll() {
        return maintenanceService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Maintenance findById(@PathVariable("id") Long id) {
        return maintenanceService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Maintenance update(@PathVariable("id") Long id, @RequestBody Maintenance maintenance) {
        return maintenanceService.update(id, maintenance);
    }
}
