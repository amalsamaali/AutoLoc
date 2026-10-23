package tn.esprit.autoloc.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;
    private String nomEquipe;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @ManyToMany
    @JoinTable(
        name = "equipe_projet",
        joinColumns = @JoinColumn(name = "id_equipe"),
        inverseJoinColumns = @JoinColumn(name = "id_projet")
    )
    private Set<Projet> projets;
}
