package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final IClientService clientService;

    @PostMapping("/ajouter")
    public Client ajouterClient(@RequestBody Client cl) {
        return clientService.ajouterClient(cl);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerClient(@PathVariable("id") long idClient) {
        clientService.supprimerClient(idClient);
    }

    @GetMapping("/recuperer-tous")
    public List<Client> recupererClients() {
        return clientService.recupererClients();
    }

    @GetMapping("/trouver-tous")
    public Set<Client> findClients() {
        return clientService.findClients();
    }

    @GetMapping("/recuperer/{id}")
    public Client recupererClientById(@PathVariable("id") long idClient) {
        return clientService.recupererClientById(idClient);
    }
}
