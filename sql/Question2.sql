SELECT nom, prenom 
FROM Joueur_info as joueurs
WHERE (pays IN ('France', 'Argentina', 'Brazil')) 
AND (position != 'Goalkeeper') 
AND joueurs.nb_matchs_joues != 0
AND (CAST(joueurs.nb_buts AS float) / CAST(joueurs.nb_matchs_joues AS float)) >= 0.5 ;