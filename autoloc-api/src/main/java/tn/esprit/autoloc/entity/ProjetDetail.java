package tn.esprit.autoloc.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjetDetail;
    private String description;
    private LocalDate dateDebut;

    @OneToOne
    @JoinColumn(name = "id_projet")
    private Projet projet;
}
