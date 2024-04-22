begin TRANSACTION;

CREATE TABLE Equipe (
                        pays VARCHAR(255) PRIMARY KEY,
                        nb_coupes_gagnees INT,
                        nb_participations INT
);

CREATE TABLE Joueur_info (
                             numero INT,
                             pays VARCHAR(255),
                             nom VARCHAR(255),
                             prenom VARCHAR(255),
                             jour_naiss INT,
                             mois_naiss INT,
                             annee_naiss INT,
                             position VARCHAR(50),
                             nb_buts INT,
                             nb_matchs_joues INT,
                             PRIMARY KEY (numero, pays),
                             FOREIGN KEY (pays) REFERENCES Equipe(pays)
);

CREATE TABLE Match (
                       NoMatch INT PRIMARY KEY,
                       score_final VARCHAR(50),
                       Equipe1 VARCHAR(255),
                       Equipe2 VARCHAR(255),
                       rang INT,
                       jour INT,
                       mois INT,
                       annee INT,
                       lieu VARCHAR(255),
                       FOREIGN KEY (Equipe1) REFERENCES Equipe(pays),
                       FOREIGN KEY (Equipe2) REFERENCES Equipe(pays)
);

CREATE TABLE Joueur_sanction (
                                 numero INT,
                                 pays VARCHAR(255),
                                 NoMatch INT,
                                 type_carton VARCHAR(50),
                                 raison TEXT,
                                 PRIMARY KEY (numero, pays, NoMatch),
                                 FOREIGN KEY (numero, pays) REFERENCES Joueur_info(numero, pays),
                                 FOREIGN KEY (NoMatch) REFERENCES Match(NoMatch)
);

CREATE TABLE Arbitre (
                         NoArbitre INT PRIMARY KEY,
                         type VARCHAR(50),
                         nb_matchs INT,
                         jour_naiss INT,
                         mois_naiss INT,
                         annee_naiss INT,
                         nom VARCHAR(255),
                         prenom VARCHAR(255),
                         nationalite VARCHAR(255)
);

CREATE TABLE Gestion (
                         NoMatch INT,
                         NoArbitre INT,
                         PRIMARY KEY (NoMatch, NoArbitre),
                         FOREIGN KEY (NoMatch) REFERENCES Match(NoMatch),
                         FOREIGN KEY (NoArbitre) REFERENCES Arbitre(NoArbitre)
);

CREATE TABLE Staff (
                       NoStaff INT,
                       pays VARCHAR(255),
                       poste VARCHAR(255),
                       nationalite VARCHAR(255),
                       nom VARCHAR(255),
                       prenom VARCHAR(255),
                       jour_naiss INT,
                       mois_naiss INT,
                       annee_naiss INT,
                       PRIMARY KEY (NoStaff, pays),
                       FOREIGN KEY (pays) REFERENCES Equipe(pays)
);

CREATE TABLE Coupe (
                       edition INT PRIMARY KEY,
                       annee INT,
                       lieu VARCHAR(255),
                       vainqueur VARCHAR(255)
);

CREATE TABLE Participation (
                               pays VARCHAR(255),
                               edition INT,
                               PRIMARY KEY (pays, edition),
                               FOREIGN KEY (pays) REFERENCES Equipe(pays),
                               FOREIGN KEY (edition) REFERENCES Coupe(edition)
);

CREATE TABLE Jouer (
                       pays VARCHAR(255),
                       NoMatch INT,
                       PRIMARY KEY (pays, NoMatch),
                       FOREIGN KEY (pays) REFERENCES Equipe(pays),
                       FOREIGN KEY (NoMatch) REFERENCES Match(NoMatch)
);

commit;