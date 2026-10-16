package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Employe;
import tn.esprit.autoloc.repository.IEmployeRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements IEmployeService {
    private final IEmployeRepository employeRepository;

    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void supprimerEmploye(long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }

    @Override
    public List<Employe> recupererEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Set<Employe> findEmployes() {
        return new HashSet<>(employeRepository.findAll());
    }

    @Override
    public Employe recupererEmployeById(long idEmploye) {
        return employeRepository.findById(idEmploye).orElse(null);
    }
}
