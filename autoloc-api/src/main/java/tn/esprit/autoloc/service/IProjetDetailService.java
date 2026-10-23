package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entity.ProjetDetail;
import java.util.List;

public interface IProjetDetailService {
    List<ProjetDetail> retrieveAllProjetDetails();
    ProjetDetail addProjetDetail(ProjetDetail pd);
    ProjetDetail updateProjetDetail(ProjetDetail pd);
    ProjetDetail retrieveProjetDetail(Long idProjetDetail);
    void removeProjetDetail(Long idProjetDetail);
}
