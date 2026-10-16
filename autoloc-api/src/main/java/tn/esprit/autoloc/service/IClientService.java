package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.Client;

import java.util.List;
import java.util.Set;

public interface IClientService {
    Client create(Client entite);
    Client findById(Long id);
    List<Client> findAll();
    Client update(Long id, Client entite);
    void deleteById(Long id);
}
