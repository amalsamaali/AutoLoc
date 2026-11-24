package tn.esprit.autoloc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.entity.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {

    /**
     * Charge les relations client et vehicule en une seule requete
     * (evite la LazyInitializationException lors du mapping DTO).
     */
    @Override
    @EntityGraph(attributePaths = {"client", "vehicule"})
    List<Reservation> findAll();

    /** Reservations d'un client donne, relations client/vehicule chargees. */
    @EntityGraph(attributePaths = {"client", "vehicule"})
    List<Reservation> findByClient_IdClient(Long idClient);
}
