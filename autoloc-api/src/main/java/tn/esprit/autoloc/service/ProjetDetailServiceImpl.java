package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entity.ProjetDetail;
import tn.esprit.autoloc.repository.IProjetDetailRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjetDetailServiceImpl implements IProjetDetailService {
    IProjetDetailRepository projetDetailRepository;

    @Override
    public List<ProjetDetail> retrieveAllProjetDetails() {
        return projetDetailRepository.findAll();
    }

    @Override
    public ProjetDetail addProjetDetail(ProjetDetail pd) {
        if (pd.getIdProjetDetail() != null && pd.getIdProjetDetail() != 0) {
            throw new IllegalArgumentException("L'ID doit être null ou 0 pour une création");
        }
        pd.setIdProjetDetail(null);
        return projetDetailRepository.save(pd);
    }

    @Override
    public ProjetDetail updateProjetDetail(ProjetDetail pd) {
        if (!projetDetailRepository.existsById(pd.getIdProjetDetail())) {
            throw new ResourceNotFoundException("ProjetDetail", pd.getIdProjetDetail());
        }
        return projetDetailRepository.save(pd);
    }

    @Override
    public ProjetDetail retrieveProjetDetail(Long idProjetDetail) {
        return projetDetailRepository.findById(idProjetDetail)
                .orElseThrow(() -> new ResourceNotFoundException("ProjetDetail", idProjetDetail));
    }

    @Override
    public void removeProjetDetail(Long idProjetDetail) {
        if (!projetDetailRepository.existsById(idProjetDetail)) {
            throw new ResourceNotFoundException("ProjetDetail", idProjetDetail);
        }
        projetDetailRepository.deleteById(idProjetDetail);
    }
}
