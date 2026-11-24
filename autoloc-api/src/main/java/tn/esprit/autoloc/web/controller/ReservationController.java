package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.dto.ReservationResponseDto;
import tn.esprit.autoloc.entity.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@Tag(name = "Gestion Reservation")
@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final IReservationService reservationService;


    @Operation(description = "récupérer toutes les réservations (DTO plat)")
    @GetMapping
    public ResponseEntity<List<ReservationResponseDto>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @Operation(description = "récupérer les réservations d'un client (DTO plat)")
    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<ReservationResponseDto>> getReservationsByClient(
            @PathVariable("idClient") Long idClient) {
        return ResponseEntity.ok(reservationService.getReservationsByClient(idClient));
    }



    @Operation(description = "créer une réservation")
    @PostMapping("/create")
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationService.create(reservation);
    }

    @Operation(description = "supprimer une réservation par son id")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        reservationService.deleteById(id);
    }

    @Operation(description = "récupérer toutes les réservations")
    @GetMapping("/find-all")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @Operation(description = "récupérer une réservation par son id")
    @GetMapping("/find-by-id/{id}")
    public Reservation findById(@PathVariable("id") Long id) {
        return reservationService.findById(id);
    }

    @Operation(description = "modifier une réservation")
    @PutMapping("/update/{id}")
    public Reservation update(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        return reservationService.update(id, reservation);
    }
}
