package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.Maintenance;
import tn.esprit.autoloc.repository.IMaintenanceRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {
    private final IMaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance ajouterMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void supprimerMaintenance(long idMaintenance) {
        maintenanceRepository.deleteById(idMaintenance);
    }

    @Override
    public List<Maintenance> recupererMaintenances() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Set<Maintenance> findMaintenances() {
        return new HashSet<>(maintenanceRepository.findAll());
    }

    @Override
    public Maintenance recupererMaintenanceById(long idMaintenance) {
        return maintenanceRepository.findById(idMaintenance).orElse(null);
    }
}
