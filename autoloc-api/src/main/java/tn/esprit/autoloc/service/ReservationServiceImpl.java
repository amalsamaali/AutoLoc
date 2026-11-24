package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.dto.ReservationResponseDto;
import tn.esprit.autoloc.entity.Reservation;
import tn.esprit.autoloc.mapper.ReservationMapper;
import tn.esprit.autoloc.repository.IClientRepository;
import tn.esprit.autoloc.repository.IReservationRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    private final IReservationRepository reservationRepository;
    private final IClientRepository clientRepository;
    private final ReservationMapper reservationMapper;

    @Override
    public Reservation create(Reservation entite) {
        if (entite.getIdReservation() != null && entite.getIdReservation() != 0) {
            throw new IllegalArgumentException("L'ID doit être null ou 0 pour une création");
        }
        entite.setIdReservation(null);
        if (entite.getDateFin() != null && entite.getDateFin().isBefore(entite.getDateDebut())) {
            throw new IllegalArgumentException("La date de fin ne peut pas être antérieure à la date de début");
        }
        return reservationRepository.save(entite);
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", id));
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation update(Long id, Reservation entite) {
        Reservation existant = findById(id);
        if (entite.getDateFin() != null && entite.getDateFin().isBefore(entite.getDateDebut())) {
            throw new IllegalArgumentException("La date de fin ne peut pas être antérieure à la date de début");
        }
        existant.setDateDebut(entite.getDateDebut());
        existant.setDateFin(entite.getDateFin());
        existant.setStatut(entite.getStatut());
        existant.setClient(entite.getClient());
        existant.setVehicule(entite.getVehicule());
        return reservationRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reservation", id);
        }
        reservationRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservationResponseDto> getAllReservations() {
        return reservationMapper.toResponseDtoList(reservationRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservationResponseDto> getReservationsByClient(Long idClient) {
        // Le client doit exister, sinon 404
        if (!clientRepository.existsById(idClient)) {
            throw new ResourceNotFoundException("Client", idClient);
        }
        return reservationMapper.toResponseDtoList(
                reservationRepository.findByClient_IdClient(idClient));
    }
}
