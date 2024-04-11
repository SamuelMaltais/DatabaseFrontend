SELECT nom, prenom, nombre_de_cartons_jaune
FROM (
	select count(*) as nombre_de_cartons_jaune, NoMatch from joueur_sanction
	where type_carton = 'Yellow'
	GROUP BY NoMatch
) as tab
JOIN 
(
	select sanctionne_par.NoArbitre, nom, prenom, NoMatch from arbitre
	JOIN sanctionne_par
	ON sanctionne_par.NoArbitre = arbitre.NoArbitre
	where "type" = 'Main'
) as tab1
ON tab.NoMatch = tab1.NoMatch
Order by nombre_de_cartons_jaune desc