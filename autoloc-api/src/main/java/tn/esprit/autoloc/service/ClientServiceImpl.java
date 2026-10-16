package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Client;
import tn.esprit.autoloc.repository.IClientRepository;

import tn.esprit.autoloc.exception.ResourceNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;

    @Override
    public Client create(Client entite) {
        if (entite.getIdClient() != null) {
            throw new IllegalArgumentException("L'ID doit être null pour une création");
        }
        if (entite.getNom() == null || entite.getNom().isEmpty() || entite.getEmail() == null || entite.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Le nom et l'email du client sont obligatoires");
        }
        return clientRepository.save(entite);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", id));
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client update(Long id, Client entite) {
        Client existant = findById(id);
        if (entite.getNom() == null || entite.getNom().isEmpty() || entite.getEmail() == null || entite.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Le nom et l'email du client sont obligatoires");
        }
        existant.setNom(entite.getNom());
        existant.setPrenom(entite.getPrenom());
        existant.setEmail(entite.getEmail());
        existant.setTelephone(entite.getTelephone());
        existant.setNumPermis(entite.getNumPermis());
        existant.setDateInscription(entite.getDateInscription());
        return clientRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Client", id);
        }
        clientRepository.deleteById(id);
    }
}
