#  Notes – Couche Repository (Atelier 3)

##  Choix d'interface

| Interface | Étend | Justification |
|---|---|---|
| IAgenceRepository | JpaRepository<Agence, Long> | CRUD complet, findAll renvoie une List, saveAndFlush disponible, tri et pagination inclus. Permet de gérer les agences avec leurs listes d'employés et de véhicules. |
| IClientRepository | JpaRepository<Client, Long> | Même choix pour l'entité Client : accès direct aux réservations via la liste, tri possible sur la date d'inscription. |
| IContratRepository | JpaRepository<Contrat, Long> | CRUD complet. **Limite connue** : `deleteAllInBatch` contourne la cascade et `orphanRemoval` sur les paiements, à éviter. Préférer `delete` / `deleteAll` classique. |
| IEmployeRepository | JpaRepository<Employe, Long> | Gestion des employés, tri possible par rôle ou par agence, requêtes de recherche par nom. |
| IEquipementRepository | JpaRepository<Equipement, Long> | Gestion du référentiel d'équipements (ManyToMany avec Véhicule). |
| IMaintenanceRepository | JpaRepository<Maintenance, Long> | Suivi des maintenances des véhicules, filtre possible par période. |
| IPaiementRepository | JpaRepository<Paiement, Long> | Créé pour lire les paiements ; la création et la suppression passent par le Contrat (composition, `cascade = CascadeType.ALL` + `orphanRemoval = true`). |
| IReservationRepository | JpaRepository<Reservation, Long> | Réservations : tri/pagination indispensable pour l'historique, filtres par client, véhicule, statut. |
| IVehiculeRepository | JpaRepository<Vehicule, Long> | Véhicules : recherche par catégorie, statut, agence ; pagination pour le catalogue. |

### Pourquoi `JpaRepository` plutôt que `CrudRepository` ?

- **CRUD + listes** : `findAll()` renvoie une `List` (pas un `Iterable`), pratique pour le mapping direct côté service/vue.
- **Flush** : `saveAndFlush()` / `flush()` permettent de forcer l'écriture en base immédiatement (utile après une mise à jour avant une lecture).
- **Tri et pagination** : héritage de `PagingAndSortingRepository` via `findAll(Sort)` et `findAll(Pageable)`, sans avoir à étendre une interface supplémentaire.
- **Suppression en lot** : méthodes `deleteInBatch` / `deleteAllInBatch` (à utiliser avec précaution, voir ci-dessous).

### Limite : `deleteAllInBatch` sur `Contrat`

`Contrat` possède une composition avec `Paiement` (`@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)`). La méthode `deleteAllInBatch` génère un `DELETE` SQL brut qui contourne complètement le cycle de vie JPA : ni cascade ni orphanRemoval ne sont déclenchés, ce qui laisserait des lignes orphelines en base et viole l'intégrité référentielle. Sur cette entité, il faut donc systématiquement utiliser `delete(contrat)` ou `deleteAll()`.

---

##  Anomalies SonarQube for IDE

| Anomalie | Règle / explication | Correction apportée |
|---|---|---|
| `Agence.java` : imports `java.util.HashSet` et `java.util.Set` déclarés mais jamais utilisés | **java:S1128** — Unused imports should be removed. Les imports non utilisés polluent le fichier et trompent le lecteur sur les types réellement employés. | Suppression des 2 lignes d'imports inutilisés. La classe n'ayant que des `List` et `ArrayList`. |
| `pom.xml` : `groupId` incohérent `esprit.tntn.esprit.autoloc` | **xml:S3457Maven** / Convention de nommage Maven. Le `groupId` doit correspondre au package de base du projet et être en notation inversé : `tn.esprit.autoloc`. | Remplacement par `tn.esprit.autoloc`. La compilation affiche maintenant correctement dans les logs. |
| `pom.xml` : dépendances de test `spring-boot-starter-data-jpa-test`, `-validation-test`, `-webmvc-test` inexistantes | **java:S3457Maven** — Dépendance inconnue / starter non résolue. Spring Boot ne fournit pas ces starters; le starter unique est `spring-boot-starter-test`. | Remplacement des 3 dépendances par le starter `spring-boot-starter-test`, qui embarque JUnit, Mockito, AssertJ et le support de test JPA/Web/Validation. |
| `Maintenance.java` : champ `description` sans `@Column`, longueur VARCHAR(255) implicite sans contrainte explicite | **java:S2384** — Schema definition should be explicit. Une description peut dépasser 255 caractères; sans longueur, les insertions longues échouent. | Ajout de `@Column(length = 500)` sur le champ `description` pour contraindre le schéma et rendre l'intention claire. |

---

##  Vérification au démarrage

Au lancement de `AutolocApiApplication`, Spring Data JPA scanne le package `tn.esprit.autoloc.repository` et détecte les interfaces.

Log attendu :
```
Found 9 JPA repository interfaces
```

Aucune annotation `@Repository` ni classe d'implémentation n'est nécessaire : Spring génère dynamiquement un proxy au démarrage (implémentation par `SimpleJpaRepository`).
