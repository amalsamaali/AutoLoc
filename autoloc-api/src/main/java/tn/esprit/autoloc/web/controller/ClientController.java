package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@Tag(name = "Gestion Client")
@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final IClientService clientService;

    @Operation(description = "créer un client")
    @PostMapping("/create")
    public Client create(@RequestBody Client cl) {
        return clientService.create(cl);
    }

    @Operation(description = "supprimer un client par son id")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        clientService.deleteById(id);
    }

    @Operation(description = "récupérer tous les clients")
    @GetMapping("/find-all")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @Operation(description = "récupérer un client par son id")
    @GetMapping("/find-by-id/{id}")
    public Client findById(@PathVariable("id") Long id) {
        return clientService.findById(id);
    }

    @Operation(description = "modifier un client")
    @PutMapping("/update/{id}")
    public Client update(@PathVariable("id") Long id, @RequestBody Client client) {
        return clientService.update(id, client);
    }
}
