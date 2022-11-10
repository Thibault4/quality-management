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

## Springdoc Swagger
L'application utilise `org.springdoc.springdoc-openapi-ui` et `swagger-ui` pour présenter les opérations.

URL d'entrée : `http://localhost:8081/swagger-ui/index.html`