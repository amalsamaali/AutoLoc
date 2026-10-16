package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final IReservationService reservationService;

    @PostMapping("/create")
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationService.create(reservation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        reservationService.deleteById(id);
    }

    @GetMapping("/find-all")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Reservation findById(@PathVariable("id") Long id) {
        return reservationService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Reservation update(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        return reservationService.update(id, reservation);
    }
}
