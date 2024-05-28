CREATE DATABASE IF NOT EXISTS talbetoptreasures_database;
USE talbetoptreasures_database;

DROP TABLE IF EXISTS Clients,Jeux,Categorie,Commandes;

CREATE TABLE IF NOT EXISTS Clients(
id_client int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nom VARCHAR(50) NOT NULL,
prenom VARCHAR(50) NOT NULL,
adresse_mail VARCHAR(50) NOT NULL,
adresse_livraison VARCHAR(50) NOT NULL,
telephone VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS Categorie(
id_categorie int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nom VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Jeux(
id_jeu int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nom VARCHAR(50) NOT NULL,
game_description VARCHAR(500) ,
prix VARCHAR(50) NOT NULL,
id_categorie int,
FOREIGN KEY (id_categorie) REFERENCES Categorie(id_categorie)
);

CREATE TABLE IF NOT EXISTS Commandes(
id_commande int PRIMARY KEY NOT NULL AUTO_INCREMENT,
client_id int NOT NULL,
FOREIGN KEY (client_id) REFERENCES Clients(id_client),
date_de_commande DATE NOT NULL,
adresse_livraison VARCHAR(50) NOT NULL,
etat boolean
);

INSERT INTO Categorie (nom)
VALUES ('Stratégie'),
('Familial'),
('Aventure');

INSERT INTO Jeux (nom,game_description,prix,id_categorie)
VALUES ('Catan', 'Jeu de stratégie et de développement de colonies', 30, 1),
('Dixit', 'Jeu d''association d''images', 25, 2),
('Les Aventuriers', 'Jeu de plateau d''aventure', 40, 3),
('Carcassonne', 'Jeu de placement de tuiles', 28, 1),
('Codenames', 'Jeu de mots et d''indices', 20, 2),
('Pandemic', 'Jeu de coopération pour sauver le monde', 35, 3),
('7 Wonders', 'Jeu de cartes et de civilisations', 29, 1),
('Splendor', 'Jeu de développement économique', 27, 2),
('Horreur à Arkham', 'Jeu d''enquête et d''horreur', 45, 3),
('Risk', 'Jeu de conquête mondiale', 22, 1),
('Citadelles', 'Jeu de rôles et de bluff', 23, 2),
('Terraforming Mars', 'Jeu de stratégie de colonisation de Mars', 55, 3),
('Small World', 'Jeu de civilisations fantastiques', 32, 1),
('7 Wonders Duel', 'Jeu de cartes pour 2 joueurs', 26, 2),
('Horreur à l''Outreterre', 'Jeu d''aventure horrifique', 38, 3);

INSERT INTO Clients (nom,prenom,adresse_mail,adresse_livraison,telephone)
VALUES
('Dubois', 'Marie', 'marie.dubois@example.com', '123 Rue de la Libération, Ville', '+1234567890'),
('Lefebvre', 'Thomas', 'thomas.lefebvre@example.com', '456 Avenue des Roses, Ville', '+9876543210'),
('Martinez', 'Léa', 'lea.martinez@example.com', '789 Boulevard de la Paix, Ville', '+2345678901'),
('Dupuis', 'Antoine', 'antoine.dupuis@example.com', '567 Avenue de la Liberté, Ville', '+3456789012'),
('Morin', 'Camille', 'camille.morin@example.com', '890 Rue de l''Avenir, Ville', '+4567890123'),
('Girard', 'Lucas', 'lucas.girard@example.com', '234 Avenue des Champs, Ville', '+5678901234'),
('Petit', 'Emma', 'emma.petit@example.com', '123 Rue des Étoiles, Ville', '+6789012345'),
('Sanchez', 'Gabriel', 'gabriel.sanchez@example.com', '345 Boulevard du Bonheur, Ville', '+7890123456'),
('Rossi', 'Clara', 'clara.rossi@example.com', '678 Avenue de la Joie, Ville', '+8901234567'),
('Lemoine', 'Hugo', 'hugo.lemoine@example.com', '456 Rue de la Nature, Ville', '+9012345678'),
('Moreau', 'Eva', 'eva.moreau@example.com', '789 Avenue de la Créativité, Ville', '+1234567890'),
('Fournier', 'Noah', 'noah.fournier@example.com', '234 Rue de la Découverte, Ville', '+2345678901'),
('Leroy', 'Léa', 'lea.leroy@example.com', '567 Avenue de l''Imagination, Ville', '+3456789012'),
('Robin', 'Lucas', 'lucas.robin@example.com', '890 Rue de la Création, Ville', '+4567890123'),
('Marchand', 'Anna', 'anna.marchand@example.com', '123 Boulevard de l''Innovation, Ville', '+5678901234');

INSERT INTO Commandes (client_id,date_de_commande,adresse_livraison,etat)
Values 
(1,'2023-12-20','123 Rue de la Libération, Ville',false),
(8,'2023-12-01','345 Boulevard du Bonheur, Ville',false),
(15,'2023-12-24','123 Boulevard de l''Innovation, Ville',false);

UPDATE Jeux
SET Prix = 35
WHERE id_jeu = 3;


DELETE FROM Jeux
WHERE id_jeu = 2;



SELECT DISTINCT nom FROM Categorie;

SELECT nom FROM Categorie
WHERE nom LIKE 'A%' OR 'S%';

SELECT * FROM Categorie
WHERE id_categorie in(2,3,4,5);

SELECT COUNT(distinct nom)  FROM Categorie;

SELECT id_categorie,nom,length(nom)
from Categorie
ORDER BY length(nom) DESC 
LIMIT 1 
;

-- 6 Montrer le nombre de jeux dans chaque catégorie

SELECT C.Nom AS Nom, COUNT(J.id_jeu) AS Nombre_de_jeux
FROM CATEGORIE C
LEFT JOIN JEUX J ON C.id_categorie = J.Id_CATEGORIE
GROUP BY C.Nom
