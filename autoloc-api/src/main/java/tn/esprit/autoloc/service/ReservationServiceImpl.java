package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Reservation;
import tn.esprit.autoloc.repository.IReservationRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    private final IReservationRepository reservationRepository;

    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void supprimerReservation(long idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public List<Reservation> recupererReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Set<Reservation> findReservations() {
        return new HashSet<>(reservationRepository.findAll());
    }

    @Override
    public Reservation recupererReservationById(long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }
}
