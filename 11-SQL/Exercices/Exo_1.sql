DROP TABLE IF EXISTS personne,adresse;
CREATE table personne
(
    personne_id INT PRIMARY KEY NOT NULL,
    titre varchar(10) NOT NULL,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100)NOT NULL,
    telephone varchar(12)NOT NULL,
    email VARCHAR(255)NOT NULL   
);

CREATE table adresse
(
adresse_id INT PRIMARY KEY NOT NULL,
id_personne int,
FOREIGN KEY (id_personne) REFERENCES personne(personne_id),
numero VARCHAR(10)NOT NULL,
rue VARCHAR(100) NOT NULL,
ville VARCHAR(100) NOT NULL,
code_postal INT(10) NOT NULL

);
SHOW TABLES;