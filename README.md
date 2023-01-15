# Tournament Manager
Le magnifique et ambitieux projet de gestion de tournois en tout genre.

Powered By @Wijin

Concept By @Lautre3091

## Le crew
| NOM      | Prénom  |
|----------|---------|
| ASSOGBA  | Melvina |
| BARDEY   | Romain  | 
| LAIGNEAU | Magali  |

## Docker
Projet conteneurisé.

Lancer la commande `docker compose up -d` effectue les actions suivantes:
- Création d'une image `tournament-manager-api` permettant de *build* l'application
  - Basé sur `eclipse-temurin:17-jdk-alpine` (Ubuntu)
  - Exposition du port `8080`
- Création d'une stack `tournament-manager`:
  - `tournament-manager-api-1`
    - mapping `8081:8080` par défaut (modifiable dans `docker-compose.yml`)
  - `tournament-manager-db-1`
    - DBMS MySQL
    - mapping direct `3306` par défaut (modifiable dans `docker-compose.yml`)
    - nom de la base de données : `tournament-manager`
    - mot de passe Root: `root`
    - utilisateur par défaut: `examjava`
    - mot de passe par défaut: `examjavapassword`
  - `tournament-manager-adminer-1`
    - mapping `9000:8080` par défaut (modifiable dans `docker-compose.yml`)

## Springdoc Swagger
L'application utilise `org.springdoc.springdoc-openapi-ui` et `swagger-ui` pour présenter les opérations.

URL d'entrée : `http://localhost:8081/swagger-ui/index.html`

## Base de données
Le fichier `data.sql` peut être chargé via adminer ou autre utilitaire pour bénéficier de données de test.

Ce fichier charge 6 tournois, 36 équipes et 180 joueurs.

Sont aussi ajoutés deux utilisateurs:
- Administrateur:
  - nom d'utilisateur: admin
  - email: admin@tm.example.fr
  - mot de passe: admin
- Visiteur:
  - nom d'utilisateur: visitor
  - email: visitor@tm.example.fr
  - mot de passe: visitor
