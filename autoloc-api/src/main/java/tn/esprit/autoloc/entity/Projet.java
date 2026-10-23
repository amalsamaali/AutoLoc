package tn.esprit.autoloc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjet;
    private String sujet;
    private String description;

    @ManyToOne
    private Entreprise entreprise;

    @JsonIgnore
    @ManyToMany(mappedBy = "projets")
    private Set<Equipe> equipes;

    @JsonIgnore
    @OneToOne(mappedBy = "projet", cascade = CascadeType.ALL)
    private ProjetDetail projetDetail;
}
