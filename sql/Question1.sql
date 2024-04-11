--1
SELECT vainqueur 
FROM Coupe 
JOIN Equipe ON (vainqueur = pays) 
WHERE annee = 2018;