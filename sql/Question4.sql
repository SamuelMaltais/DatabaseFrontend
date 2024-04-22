SELECT nom, prenom, nombre_de_cartons_jaune
FROM (
	select count(*) as nombre_de_cartons_jaune, NoMatch from joueur_sanction
	where type_carton = 'Yellow'
	GROUP BY NoMatch
) as tab
JOIN 
(
	select Gestion.NoArbitre, nom, prenom, NoMatch from arbitre
	JOIN Gestion
	ON Gestion.NoArbitre = arbitre.NoArbitre
	where "type" = 'Main'
) as tab1
ON tab.NoMatch = tab1.NoMatch
Order by nombre_de_cartons_jaune desc