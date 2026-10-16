package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Client;

import java.util.List;
import java.util.Set;

public interface IClientService {

    Client ajouterClient(Client cl);

    void supprimerClient(long idClient);

    List<Client> recupererClients();

    Set<Client> findClients();

    Client recupererClientById(long idClient);
}
