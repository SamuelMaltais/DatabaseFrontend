Begin TRANSACTION;

INSERT INTO Equipe (pays, nb_coupes_gagnees, nb_participations) VALUES
                                                                    ('France', 2, 15),
                                                                    ('Brazil', 5, 21),
                                                                    ('Germany', 4, 19),
                                                                    ('Argentina', 2, 17),
                                                                    ('Italy', 4, 18),
                                                                    ('Spain', 1, 16),
                                                                    ('Netherlands', 1, 10),
                                                                    ('England', 1, 15),
                                                                    ('Uruguay', 2, 13),
                                                                    ('Portugal', 1, 8);

INSERT INTO Joueur_info (numero, pays, nom, prenom, jour_naiss, mois_naiss, annee_naiss, position, nb_buts, nb_matchs_joues) VALUES
                                                                                                                                 (7, 'France', 'Griezmann', 'Antoine', 21, 3, 1991, 'Forward', 30, 80),
                                                                                                                                 (10, 'Brazil', 'Jr', 'Neymar', 5, 2, 1992, 'Forward', 45, 90),
                                                                                                                                 (8, 'Germany', 'Kroos', 'Toni', 4, 1, 1990, 'Midfielder', 15, 70),
                                                                                                                                 (10, 'Argentina', 'Messi', 'Lionel', 24, 6, 1987, 'Forward', 70, 110),
                                                                                                                                 (3, 'Italy', 'Chiellini', 'Giorgio', 14, 8, 1984, 'Defender', 5, 60),
                                                                                                                                 (4, 'Spain', 'Ramos', 'Sergio', 30, 3, 1986, 'Defender', 15, 100),
                                                                                                                                 (4, 'Netherlands', 'van Dijk', 'Virgil', 8, 7, 1991, 'Defender', 5, 70),
                                                                                                                                 (9, 'England', 'Kane', 'Harry', 28, 7, 1993, 'Forward', 40, 90),
                                                                                                                                 (9, 'Uruguay', 'Suarez', 'Luis', 24, 1, 1987, 'Forward', 55, 85),
                                                                                                                                 (7, 'Portugal', 'Ronaldo', 'Cristiano', 5, 2, 1985, 'Forward', 75, 120);

INSERT INTO Match (NoMatch, score_final, Equipe1, Equipe2, rang, jour, mois, annee, lieu) VALUES
                                                                                              (1, '2-1', 'France', 'Brazil', 1, 12, 6, 2022, 'Doha'),
                                                                                              (2, '3-2', 'Germany', 'Argentina', 2, 13, 6, 2022, 'Lusail'),
                                                                                              (3, '1-1', 'Italy', 'Spain', 3, 14, 6, 2022, 'Al-Wakrah'),
                                                                                              (4, '0-0', 'Netherlands', 'England', 4, 15, 6, 2022, 'Al-Rayyan'),
                                                                                              (5, '2-0', 'Uruguay', 'Portugal', 5, 16, 6, 2022, 'Doha'),
                                                                                              (6, '3-1', 'France', 'Germany', 6, 17, 6, 2022, 'Lusail'),
                                                                                              (7, '1-0', 'Italy', 'Netherlands', 7, 18, 6, 2022, 'Al-Khor'),
                                                                                              (8, '2-1', 'Uruguay', 'France', 8, 19, 6, 2022, 'Doha'),
                                                                                              (9, '2-0', 'Germany', 'Italy', 9, 20, 6, 2022, 'Al-Wakrah'),
                                                                                              (10, '3-2', 'France', 'Uruguay', 10, 21, 6, 2022, 'Lusail');

INSERT INTO Joueur_sanction (numero, pays, NoMatch, type_carton, raison) VALUES
                                                                             (7, 'France', 1, 'Yellow', 'Unsporting behavior'),
                                                                             (10, 'Brazil', 1, 'Red', 'Violent conduct'),
                                                                             (8, 'Germany', 2, 'Yellow', 'Dissent'),
                                                                             (10, 'Argentina', 2, 'Yellow', 'Time-wasting'),
                                                                             (3, 'Italy', 3, 'Red', 'Serious foul play'),
                                                                             (4, 'Spain', 3, 'Yellow', 'Simulation'),
                                                                             (4, 'Netherlands', 4, 'Yellow', 'Delaying the restart of play'),
                                                                             (9, 'England', 4, 'Yellow', 'Unsporting behavior'),
                                                                             (9, 'Uruguay', 5, 'Yellow', 'Dissent'),
                                                                             (7, 'Portugal', 5, 'Yellow', 'Time-wasting');

INSERT INTO Arbitre (NoArbitre, type, nb_matchs, jour_naiss, mois_naiss, annee_naiss, nom, prenom, nationalite) VALUES
                                                                                                                    (1, 'Main', 10, 12, 4, 1980, 'Smith', 'John', 'England'),
                                                                                                                    (2, 'Assistant', 15, 21, 8, 1975, 'Garcia', 'Maria', 'Spain'),
                                                                                                                    (3, 'Main', 8, 5, 12, 1982, 'MÃ¼ller', 'Gerard', 'Germany'),
                                                                                                                    (4, 'Main', 12, 10, 6, 1978, 'Silva', 'Ana', 'Portugal'),
                                                                                                                    (5, 'Assistant', 10, 14, 10, 1985, 'Rossi', 'Luca', 'Italy'),
                                                                                                                    (6, 'Main', 14, 25, 3, 1983, 'Martinez', 'Pedro', 'Spain'),
                                                                                                                    (7, 'Assistant', 9, 7, 9, 1980, 'Lopez', 'Maria', 'Argentina'),
                                                                                                                    (8, 'Main', 11, 18, 7, 1976, 'van der Berg', 'Pieter', 'Netherlands'),
                                                                                                                    (9, 'Assistant', 13, 3, 5, 1988, 'Dubois', 'Julie', 'France'),
                                                                                                                    (10, 'Main', 10, 9, 2, 1981, 'Fernandez', 'Carlos', 'Argentina');

INSERT INTO Gestion (NoMatch, NoArbitre) VALUES
                                             (1, 1),
                                             (2, 2),
                                             (3, 3),
                                             (4, 4),
                                             (5, 5),
                                             (6, 6),
                                             (7, 7),
                                             (8, 8),
                                             (9, 9),
                                             (10, 10);

INSERT INTO Staff (NoStaff, pays, poste, nationalite, nom, prenom, jour_naiss, mois_naiss, annee_naiss) VALUES
                                                                                                            (1, 'France', 'Coach', 'France', 'Dupont', 'Jean', 10, 2, 1970),
                                                                                                            (2, 'Brazil', 'Trainer', 'Brazil', 'Santos', 'Maria', 15, 6, 1975),
                                                                                                            (3, 'Germany', 'Coach', 'Germany', 'Schmidt', 'Hans', 20, 9, 1968),
                                                                                                            (4, 'Argentina', 'Trainer', 'Argentina', 'Gomez', 'Carlos', 5, 11, 1980),
                                                                                                            (5, 'Italy', 'Coach', 'Italy', 'Ricci', 'Giulia', 30, 4, 1973),
                                                                                                            (6, 'Spain', 'Trainer', 'Spain', 'Fernandez', 'Elena', 25, 8, 1982),
                                                                                                            (7, 'Netherlands', 'Coach', 'Netherlands', 'Jansen', 'Peter', 14, 3, 1965),
                                                                                                            (8, 'England', 'Trainer', 'England', 'Smith', 'David', 8, 10, 1977),
                                                                                                            (9, 'Uruguay', 'Coach', 'Uruguay', 'Lopez', 'Juan', 23, 5, 1972),
                                                                                                            (10, 'Portugal', 'Trainer', 'Portugal', 'Sousa', 'Ana', 7, 12, 1985);

INSERT INTO Coupe (edition, annee, lieu, vainqueur) VALUES
                                                        (22, 2022, 'Qatar', 'Argentina'),
                                                        (21, 2018, 'Russia', 'France'),
                                                        (20, 2014, 'Brazil', 'Germany'),
                                                        (19, 2010, 'South Africa', 'Spain'),
                                                        (18, 2006, 'Germany', 'Italy'),
                                                        (17, 2002, 'South Korea & Japan', 'Brazil'),
                                                        (16, 1998, 'France', 'France'),
                                                        (15, 1994, 'United States', 'Brazil'),
                                                        (14, 1990, 'Italy', 'Germany'),
                                                        (13, 1986, 'Mexico', 'Argentina');

INSERT INTO Participation (pays, edition) VALUES
                                              ('France', 22),
                                              ('Brazil', 22),
                                              ('Germany', 22),
                                              ('Argentina', 22),
                                              ('Italy', 22),
                                              ('Spain', 22),
                                              ('Netherlands', 22),
                                              ('England', 22),
                                              ('Uruguay', 22),
                                              ('Portugal', 22);

INSERT INTO Jouer (pays, NoMatch) VALUES
                                      ('France', 1),
                                      ('Brazil', 1),
                                      ('Germany', 2),
                                      ('Argentina', 2),
                                      ('Italy', 3),
                                      ('Spain', 3),
                                      ('Netherlands', 4),
                                      ('England', 4),
                                      ('Uruguay', 5),
                                      ('Portugal', 5);

INSERT INTO Sanctionne_par (NoMatch, NoArbitre) VALUES
                                                    (1, 1),
                                                    (1, 2),
                                                    (2, 3),
                                                    (2, 4),
                                                    (3, 5),
                                                    (3, 6),
                                                    (4, 7),
                                                    (4, 8),
                                                    (5, 9),
                                                    (5, 10);

COMMIT;