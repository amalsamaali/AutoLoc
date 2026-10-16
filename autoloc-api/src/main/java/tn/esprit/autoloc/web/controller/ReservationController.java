package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {
    private final IReservationService reservationService;

    @PostMapping("/ajouter")
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerReservation(@PathVariable("id") long idReservation) {
        reservationService.supprimerReservation(idReservation);
    }

    @GetMapping("/recuperer-tous")
    public List<Reservation> recupererReservations() {
        return reservationService.recupererReservations();
    }

    @GetMapping("/trouver-tous")
    public Set<Reservation> findReservations() {
        return reservationService.findReservations();
    }

    @GetMapping("/recuperer/{id}")
    public Reservation recupererReservationById(@PathVariable("id") long idReservation) {
        return reservationService.recupererReservationById(idReservation);
    }
}
