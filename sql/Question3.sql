SELECT equipe_gagnante,equipe_perdante, difference
FROM (
    SELECT equipe1, equipe2, score_final, eq1.nb_coupes_gagnees as nb1, eq2.nb_coupes_gagnees as nb2, 
	(
		CASE
            WHEN CAST(SPLIT_PART(score_final, '-', 1) AS int) > CAST(SPLIT_PART(score_final, '-', -1) AS int)
                THEN eq2.nb_coupes_gagnees - eq1.nb_coupes_gagnees
			ELSE
                0 - ABS(eq1.nb_coupes_gagnees - eq2.nb_coupes_gagnees)
        END
	) as difference,
	 (
	 	CASE
            WHEN CAST(SPLIT_PART(score_final, '-', 1) AS int) > CAST(SPLIT_PART(score_final, '-', -1) AS int)
                THEN equipe1
		 	WHEN CAST(SPLIT_PART(score_final, '-', 1) AS int) = CAST(SPLIT_PART(score_final, '-', -1) AS int)
		 		THEN 'Egalite'
			ELSE equipe2
        END
	 ) as equipe_gagnante,
	(
	 	CASE
            WHEN CAST(SPLIT_PART(score_final, '-', 1) AS int) > CAST(SPLIT_PART(score_final, '-', -1) AS int)
                THEN equipe2
		 	WHEN CAST(SPLIT_PART(score_final, '-', 1) AS int) = CAST(SPLIT_PART(score_final, '-', -1) AS int)
		 		THEN 'Egalite'
			ELSE equipe1
        END
	 ) as equipe_perdante
	
    FROM "match"
    JOIN Equipe as eq1 ON equipe1 = eq1.pays
	JOIN Equipe as eq2 On equipe2 = eq2.pays
	where annee = 2022
) AS newTab
ORDER BY difference DESC
LIMIT 1



