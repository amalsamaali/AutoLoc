package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Reservation;
import java.util.List;
import java.util.Set;

public interface IReservationService {
    Reservation ajouterReservation(Reservation reservation);
    void supprimerReservation(long idReservation);
    List<Reservation> recupererReservations();
    Set<Reservation> findReservations();
    Reservation recupererReservationById(long idReservation);
}
