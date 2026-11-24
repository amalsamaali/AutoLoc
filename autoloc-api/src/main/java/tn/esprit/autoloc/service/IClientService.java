package tn.esprit.autoloc.service;

import tn.esprit.autoloc.dto.ClientRequestDto;
import tn.esprit.autoloc.dto.ClientResponseDto;
import tn.esprit.autoloc.entity.Client;

import java.util.List;
import java.util.Set;

public interface IClientService {
    Client create(Client entite);
    Client findById(Long id);
    List<Client> findAll();
    Client update(Long id, Client entite);
    void deleteById(Long id);

    /** Cree un client a partir d'un DTO et renvoie sa representation DTO. */
    ClientResponseDto ajouterClient(ClientRequestDto dto);

    /** Recupere un client par son id (exception 404 si introuvable) au format DTO. */
    ClientResponseDto getClientById(Long id);
}
