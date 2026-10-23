package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@Tag(name = "Gestion Employe")
@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
public class EmployeController {
    private final IEmployeService employeService;

    @Operation(description = "créer un employé")
    @PostMapping("/create")
    public Employe create(@RequestBody Employe employe) {
        return employeService.create(employe);
    }

    @Operation(description = "supprimer un employé par son id")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        employeService.deleteById(id);
    }

    @Operation(description = "récupérer tous les employés")
    @GetMapping("/find-all")
    public List<Employe> findAll() {
        return employeService.findAll();
    }

    @Operation(description = "récupérer un employé par son id")
    @GetMapping("/find-by-id/{id}")
    public Employe findById(@PathVariable("id") Long id) {
        return employeService.findById(id);
    }

    @Operation(description = "modifier un employé")
    @PutMapping("/update/{id}")
    public Employe update(@PathVariable("id") Long id, @RequestBody Employe employe) {
        return employeService.update(id, employe);
    }
}
