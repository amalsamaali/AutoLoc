# Note de l'Atelier 4 : Couche Service, IoC et Injection de Dépendances

## A. Modes d'injection comparés

| Critère | Injection par constructeur | Injection par attribut (@Autowired) |
| :--- | :--- | :--- |
| Champ final possible ? | **Oui** | Non |
| Dépendance visible dans la signature ? | **Oui** | Non |
| Utilisable avec new hors conteneur sans dépendance null ? | **Oui** | Non |
| Signalé par SonarQube ? | Non (Recommandé) | Oui (Règle S6813) |

## B. Services

| Service | Dépendances injectées | Mode d'injection | Justification |
| :--- | :--- | :--- | :--- |
| AgenceServiceImpl | IAgenceRepository | Constructeur | Assure que le service est toujours initialisé avec ses dépendances. |
| ClientServiceImpl | IClientRepository | Constructeur | Injection recommandée pour la testabilité et l'immutabilité. |
| ContratServiceImpl | IContratRepository | Constructeur | Permet de rendre le repository `final`. |
| EmployeServiceImpl | IEmployeRepository | Constructeur | Dépendance explicite et obligatoire. |
| EquipementServiceImpl | IEquipementRepository | Constructeur | Suit la convention AutoLoc. |
| MaintenanceServiceImpl | IMaintenanceRepository | Constructeur | Garantit un état cohérent du bean. |
| PaiementServiceImpl | IPaiementRepository | Constructeur | Lecture seule, dépendance unique injectée. |
| ReservationServiceImpl | IReservationRepository | Constructeur | Facilite le mocking dans les tests. |
| VehiculeServiceImpl | IVehiculeRepository | Constructeur | Injection par constructeur privilégiée. |

## C. Messages d'erreur

### Message 1 (Bean not found)
- **Causes probables** : 
    1. L'annotation `@Service` est manquante sur la classe `ContratServiceImpl`.
    2. La classe `ContratServiceImpl` n'est pas dans un package scanné par `@SpringBootApplication`.
- **Correction** : Ajouter `@Service` sur la classe et vérifier le package.

### Message 2 (Ambiguous bean)
- **Corrections** :
    1. Utiliser `@Primary` sur l'une des implémentations (ex: `@Primary` sur `EmailNotificateur`).
    2. Utiliser `@Qualifier` lors de l'injection (ex: `@Qualifier("smsNotificateur")` dans le constructeur).

### Message 3 (Circular dependency)
- **Pourquoi l'injection par constructeur bloque ?** : Le conteneur ne peut pas instancier le premier bean car il a besoin du second, qui lui-même a besoin du premier (non encore créé).
- **Piste de conception** : Introduire une troisième classe ou un service médiateur pour casser le cycle, ou utiliser des événements Spring.

## D. Anomalies SonarQube for IDE

| Règle | Explication | Correction apportée |
| :--- | :--- | :--- |
| S6813 | Éviter l'injection par attribut (@Autowired sur champ). | Remplacé par une injection par constructeur avec `final`. |
| S112 | Éviter de lever des exceptions génériques comme `RuntimeException`. | Création et utilisation de `ResourceNotFoundException`. |
| S1166 | Les exceptions doivent être soit loguées, soit propagées. | Les exceptions métiers sont propagées correctement. |

## E. Questions de compréhension

1. **Où est le new de ContratServiceImpl et qui l'exécute ?**
   Il est exécuté par le conteneur Spring (IoC) au démarrage lors du scan des composants (`@Service`).

2. **Pourquoi un contrôleur dépendra-t-il de IContratService et non de ContratServiceImpl ?**
   Pour respecter le principe de découplage. Cela permet de changer l'implémentation sans toucher au contrôleur et facilite les tests unitaires.

3. **Pourquoi un service singleton doit-il rester sans état ?**
   Parce qu'il est partagé. Si un service a un champ modifiable, les actions d'un utilisateur peuvent corrompre les données pour un autre (problèmes de thread-safety).

4. **Pourquoi update charge-t-il l'entité existante avant d'appeler save ?**
   Pour ne pas écraser les champs non fournis par l'utilisateur et protéger les relations (collections) qui ne doivent pas être modifiées directement.

5. **Différences et cas particuliers :**
   - `@Component` est pour la détection automatique, `@Bean` pour la déclaration manuelle dans une config.
   - `@Primary` définit un choix par défaut, `@Qualifier` fait un choix explicite.
   - `IPaiementService` est en lecture seule car les paiements sont créés/supprimés via le `Contrat` (cycle de vie lié).
