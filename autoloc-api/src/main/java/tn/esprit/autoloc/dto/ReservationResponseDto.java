package tn.esprit.autoloc.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.autoloc.entity.StatutReservation;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDto {

    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private StatutReservation statut;

    private String clientNom;
    private String clientPrenom;

    private String vehiculeMarque;
    private String vehiculeModele;
    private String vehiculeImmatriculation;
}
