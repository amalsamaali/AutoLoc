package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
public class EmployeController {
    private final IEmployeService employeService;

    @PostMapping("/create")
    public Employe create(@RequestBody Employe employe) {
        return employeService.create(employe);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        employeService.deleteById(id);
    }

    @GetMapping("/find-all")
    public List<Employe> findAll() {
        return employeService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Employe findById(@PathVariable("id") Long id) {
        return employeService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Employe update(@PathVariable("id") Long id, @RequestBody Employe employe) {
        return employeService.update(id, employe);
    }
}
