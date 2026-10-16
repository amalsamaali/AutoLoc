package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Reservation;
import java.util.List;
import java.util.Set;

public interface IReservationService {
    Reservation create(Reservation entite);
    Reservation findById(Long id);
    List<Reservation> findAll();
    Reservation update(Long id, Reservation entite);
    void deleteById(Long id);
}
