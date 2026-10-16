package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/employes")
@AllArgsConstructor
public class EmployeController {
    private final IEmployeService employeService;

    @PostMapping("/ajouter")
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerEmploye(@PathVariable("id") long idEmploye) {
        employeService.supprimerEmploye(idEmploye);
    }

    @GetMapping("/recuperer-tous")
    public List<Employe> recupererEmployes() {
        return employeService.recupererEmployes();
    }

    @GetMapping("/trouver-tous")
    public Set<Employe> findEmployes() {
        return employeService.findEmployes();
    }

    @GetMapping("/recuperer/{id}")
    public Employe recupererEmployeById(@PathVariable("id") long idEmploye) {
        return employeService.recupererEmployeById(idEmploye);
    }
}
