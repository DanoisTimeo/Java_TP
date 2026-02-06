Ce projet est le TP 3. Les TP 1 et 2 sont sur : https://github.com/DanoisTimeo/java_tp1

## Lancement de la BDD
### Docker
Lancement du conteneur
```console
docker-compose up --build -d
```

Trouver l'id du conteneur
```console
docker ps
```

Ouvrir le conteneur pour ecrire les scripts PostgreSQL
```console
docker exec -it <ID_CONTENEUR> psql -U javatp -d javatp  
```

### Script PostgreSQL
```
-- Suppression des tables si elles existent (ordre inverse des dépendances)
DROP TABLE IF EXISTS COMPO;
DROP TABLE IF EXISTS EMPRUNT;
DROP TABLE IF EXISTS LIVRE;
DROP TABLE IF EXISTS CLIENT;

-- Table CLIENT
CREATE TABLE CLIENT (
    ID SERIAL PRIMARY KEY,
    NOM VARCHAR(50) NOT NULL,
    PRENOM VARCHAR(50) NOT NULL
);

-- Table LIVRE
CREATE TABLE LIVRE (
    ID SERIAL PRIMARY KEY,
    TITRE VARCHAR(255) NOT NULL,
    AUTEUR VARCHAR(50) NOT NULL
);

-- Table EMPRUNT
CREATE TABLE EMPRUNT (
    ID SERIAL PRIMARY KEY,
    DATE_DEBUT TIMESTAMP NOT NULL,
    DATE_FIN TIMESTAMP,
    DELAI INTEGER,
    ID_CLIENT INTEGER NOT NULL,
    CONSTRAINT fk_client FOREIGN KEY (ID_CLIENT) REFERENCES CLIENT(ID)
);

-- Table COMPO (relation entre EMPRUNT et LIVRE)
CREATE TABLE COMPO (
    ID_LIV INTEGER NOT NULL,
    ID_EMP INTEGER NOT NULL,
    CONSTRAINT fk_livre FOREIGN KEY (ID_LIV) REFERENCES LIVRE(ID),
    CONSTRAINT fk_emprunt FOREIGN KEY (ID_EMP) REFERENCES EMPRUNT(ID),
    PRIMARY KEY (ID_LIV, ID_EMP)
);

-- Insertion des clients
INSERT INTO CLIENT (NOM, PRENOM) VALUES
    ('Brigand', 'Pierre'),
    ('YU', 'Cheng'),
    ('BERRAD', 'Hicham');

-- Insertion des livres
INSERT INTO LIVRE (TITRE, AUTEUR) VALUES
    ('Vingt mille lieues sous les mers', 'Jules Verne'),
    ('Germinal', 'Emile Zola'),
    ('Guerre et paix', 'Léon Tolstoï'),
    ('Apprendre à parler aux animaux', 'Gaston Pouet'),
    ('1001 recettes de Cuisine', 'Jean-Pierre Coffe');

-- Insertion des emprunts
INSERT INTO EMPRUNT (DATE_DEBUT, DATE_FIN, DELAI, ID_CLIENT) VALUES
    ('2017-11-12', '2017-11-18', 15, 1),
    ('2017-12-08', '2017-12-23', 30, 2),
    ('2017-12-09', '2018-01-04', 30, 3),
    ('2018-01-03', NULL, 21, 1),
    ('2018-01-13', NULL, 21, 3);

-- Insertion des compositions (livres empruntés)
INSERT INTO COMPO (ID_LIV, ID_EMP) VALUES
    (1, 1),
    (4, 1),
    (2, 2),
    (3, 2),
    (1, 3),
    (5, 4),
    (2, 4),
    (3, 5);
```
