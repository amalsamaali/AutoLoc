package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final IClientService clientService;

    @PostMapping("/create")
    public Client create(@RequestBody Client cl) {
        return clientService.create(cl);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        clientService.deleteById(id);
    }

    @GetMapping("/find-all")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Client findById(@PathVariable("id") Long id) {
        return clientService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Client update(@PathVariable("id") Long id, @RequestBody Client client) {
        return clientService.update(id, client);
    }
}
