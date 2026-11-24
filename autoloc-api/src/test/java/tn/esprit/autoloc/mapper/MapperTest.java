package tn.esprit.autoloc.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import tn.esprit.autoloc.dto.ClientRequestDto;
import tn.esprit.autoloc.dto.ClientResponseDto;
import tn.esprit.autoloc.dto.ReservationResponseDto;
import tn.esprit.autoloc.entity.Client;
import tn.esprit.autoloc.entity.Reservation;
import tn.esprit.autoloc.entity.StatutReservation;
import tn.esprit.autoloc.entity.Vehicule;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests unitaires (sans contexte Spring) des mappers MapStruct.
 * Verifie notamment que les DTO exposes ne contiennent pas de champs/objets interdits.
 */
class MapperTest {

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();

    private final ClientMapper clientMapper = new ClientMapperImpl();
    private final ReservationMapper reservationMapper = new ReservationMapperImpl();

    @Test
    void toEntity_ignoreIdEtPositionneLaDateInscription() {
        ClientRequestDto dto = new ClientRequestDto();
        dto.setNom("Ben Ali");
        dto.setPrenom("Sami");

        Client client = clientMapper.toEntity(dto);

        assertThat(client.getIdClient()).isNull();
        assertThat(client.getEmail()).isNull();
        assertThat(client.getTelephone()).isNull();
        assertThat(client.getDateInscription()).isEqualTo(LocalDate.now());
    }

    @Test
    void clientResponseDto_neContientPasLEmail() throws Exception {
        Client client = new Client();
        client.setIdClient(1L);
        client.setNom("Ben Ali");
        client.setPrenom("Sami");
        client.setEmail("sami@example.com");
        client.setTelephone("20123456");

        ClientResponseDto dto = clientMapper.toResponseDto(client);
        String json = objectMapper.writeValueAsString(dto);

        assertThat(json).contains("\"id\":1");
        assertThat(json).contains("\"nom\":\"Ben Ali\"");
        assertThat(json).contains("\"telephone\":\"20123456\"");
        assertThat(json).doesNotContain("email");
    }

    @Test
    void reservationResponseDto_estPlatEtSansObjetsImbriques() throws Exception {
        Client client = new Client();
        client.setNom("Ben Ali");
        client.setPrenom("Sami");

        Vehicule vehicule = new Vehicule();
        vehicule.setMarque("Renault");
        vehicule.setModele("Clio");
        vehicule.setImmatriculation("TN-123-AB");

        Reservation reservation = new Reservation();
        reservation.setIdReservation(7L);
        reservation.setDateDebut(LocalDate.of(2026, 1, 1));
        reservation.setDateFin(LocalDate.of(2026, 1, 5));
        reservation.setStatut(StatutReservation.CONFIRMEE);
        reservation.setClient(client);
        reservation.setVehicule(vehicule);

        ReservationResponseDto dto = reservationMapper.toResponseDto(reservation);
        String json = objectMapper.writeValueAsString(dto);

        assertThat(json).contains("\"id\":7");
        assertThat(json).contains("\"statut\":\"CONFIRMEE\"");
        assertThat(json).contains("\"clientNom\":\"Ben Ali\"");
        assertThat(json).contains("\"clientPrenom\":\"Sami\"");
        assertThat(json).contains("\"vehiculeMarque\":\"Renault\"");
        assertThat(json).contains("\"vehiculeModele\":\"Clio\"");
        assertThat(json).contains("\"vehiculeImmatriculation\":\"TN-123-AB\"");

        // Aucun objet imbrique client / vehicule
        assertThat(json).doesNotContain("\"client\":");
        assertThat(json).doesNotContain("\"vehicule\":");
    }
}
