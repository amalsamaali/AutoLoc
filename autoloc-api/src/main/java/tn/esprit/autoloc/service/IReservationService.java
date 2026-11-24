package tn.esprit.autoloc.service;

import tn.esprit.autoloc.dto.ReservationResponseDto;
import tn.esprit.autoloc.entity.Reservation;
import java.util.List;
import java.util.Set;

public interface IReservationService {
    Reservation create(Reservation entite);
    Reservation findById(Long id);
    List<Reservation> findAll();
    Reservation update(Long id, Reservation entite);
    void deleteById(Long id);

    /** Liste toutes les reservations au format DTO plat. */
    List<ReservationResponseDto> getAllReservations();

    /** Liste les reservations d'un client (404 si le client n'existe pas). */
    List<ReservationResponseDto> getReservationsByClient(Long idClient);
}
