package tn.esprit.autoloc.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.dto.ReservationResponseDto;
import tn.esprit.autoloc.entity.Reservation;

/**
 * Mapper MapStruct pour l'entite Reservation.
 * Aplatit les relations client et vehicule dans le DTO de sortie.
 */
@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(source = "idReservation", target = "id")
    @Mapping(source = "client.nom", target = "clientNom")
    @Mapping(source = "client.prenom", target = "clientPrenom")
    @Mapping(source = "vehicule.marque", target = "vehiculeMarque")
    @Mapping(source = "vehicule.modele", target = "vehiculeModele")
    @Mapping(source = "vehicule.immatriculation", target = "vehiculeImmatriculation")
    ReservationResponseDto toResponseDto(Reservation reservation);

    List<ReservationResponseDto> toResponseDtoList(List<Reservation> reservations);
}
