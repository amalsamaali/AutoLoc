package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.dto.ClientRequestDto;
import tn.esprit.autoloc.dto.ClientResponseDto;
import tn.esprit.autoloc.entity.Client;

/**
 * Mapper MapStruct pour l'entite Client.
 * componentModel = "spring" : le mapper est genere comme un bean Spring injectable.
 */
@Mapper(componentModel = "spring")
public interface ClientMapper {

    /**
     * DTO -> entite. L'id, la relation reservations et les champs non exposes
     * (numPermis) sont ignores. La date d'inscription est positionnee a la date du jour.
     */
    @Mapping(target = "idClient", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "numPermis", ignore = true)
    @Mapping(target = "dateInscription", expression = "java(java.time.LocalDate.now())")
    Client toEntity(ClientRequestDto dto);

    /** Entite -> DTO. L'id de l'entite (idClient) est expose sous le nom "id". */
    @Mapping(source = "idClient", target = "id")
    ClientResponseDto toResponseDto(Client client);
}
