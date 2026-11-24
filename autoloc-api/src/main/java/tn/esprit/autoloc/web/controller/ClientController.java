package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.dto.ClientRequestDto;
import tn.esprit.autoloc.dto.ClientResponseDto;
import tn.esprit.autoloc.entity.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@Tag(name = "Gestion Client")
@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final IClientService clientService;

    // ---------------------------------------------------------------------
    // Endpoints exposes via DTO (le controller ne manipule QUE des DTO)
    // ---------------------------------------------------------------------

    @Operation(description = "créer un client à partir d'un DTO")
    @PostMapping
    public ResponseEntity<ClientResponseDto> ajouterClient(@Valid @RequestBody ClientRequestDto dto) {
        ClientResponseDto cree = clientService.ajouterClient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cree);
    }

    @Operation(description = "récupérer un client par son id (DTO)")
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> getClientById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    // ---------------------------------------------------------------------
    // Endpoints existants (conservés, exposant l'entité)
    // ---------------------------------------------------------------------

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
