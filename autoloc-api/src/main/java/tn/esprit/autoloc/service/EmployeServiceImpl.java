package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.entity.Agence;
import tn.esprit.autoloc.entity.Employe;
import tn.esprit.autoloc.repository.IAgenceRepository;
import tn.esprit.autoloc.repository.IEmployeRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {
    private final IEmployeRepository employeRepository;
    private final IAgenceRepository agenceRepository;

    @Override
    public Employe create(Employe entite) {
        if (entite.getIdEmploye() != null && entite.getIdEmploye() != 0) {
            throw new IllegalArgumentException("L'ID doit être null ou 0 pour une création");
        }
        entite.setIdEmploye(null);
        if (entite.getNom() == null || entite.getNom().isEmpty() || entite.getRole() == null) {
            throw new IllegalArgumentException("Le nom et le rôle de l'employé sont obligatoires");
        }
        return employeRepository.save(entite);
    }

    @Override
    public Employe findById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employe", id));
    }

    @Override
    public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    @Override
    public Employe update(Long id, Employe entite) {
        Employe existant = findById(id);
        if (entite.getNom() == null || entite.getNom().isEmpty() || entite.getRole() == null) {
            throw new IllegalArgumentException("Le nom et le poste de l'employé sont obligatoires");
        }
        existant.setNom(entite.getNom());
        existant.setPrenom(entite.getPrenom());
        existant.setRole(entite.getRole());
        existant.setAgence(entite.getAgence());
        return employeRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!employeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employe", id);
        }
        employeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = findById(idEmploye);
        employe.setAgence(null);
        return employeRepository.save(employe);
    }

    @Override
    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = findById(idEmploye);
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new ResourceNotFoundException("Agence", idAgence));
        employe.setAgence(agence);
        return employeRepository.save(employe);
    }
}
