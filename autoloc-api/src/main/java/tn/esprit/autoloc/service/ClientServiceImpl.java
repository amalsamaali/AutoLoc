package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Client;
import tn.esprit.autoloc.repository.IClientRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;

    @Override
    public Client ajouterClient(Client cl) {
        return clientRepository.save(cl);
    }

    @Override
    public void supprimerClient(long idClient) {
        clientRepository.deleteById(idClient);
    }

    @Override
    public List<Client> recupererClients() {
        return clientRepository.findAll();
    }

    @Override
    public Set<Client> findClients() {
        return new HashSet<>(clientRepository.findAll());
    }

    @Override
    public Client recupererClientByid(long idClient) {
        return clientRepository.findById(idClient).orElse(null);
    }
}
