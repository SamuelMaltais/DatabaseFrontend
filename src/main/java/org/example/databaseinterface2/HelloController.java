package org.example.databaseinterface2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.lang.reflect.Executable;


public class HelloController {
    public Text connectionField;
    @FXML
    private Label welcomeText;

    @FXML
    private TextArea questionField;
    @FXML
    private TextArea responseField;

    private OrmInterface ormInterface = new OrmInterface();

    @FXML
    public void Question1() {
        questionField.setText("Quelle equipe a gagne la Coupe de 2018?");
        responseField.setText("Waiting query response...");
        String res;
        connectionField.setText("Echec de la connection: Changez la configuration du fichier hibernate.cfg.xml. \n Assurez vous d'avoir run les schemas et d'avoir run les fichiers sql pour les schemas.");

        try {
            res = ormInterface.ExecuteQuery(
                    """
                                    SELECT vainqueur\s
                                    FROM Coupe\s
                                    JOIN Equipe ON (vainqueur = pays)\s
                                    WHERE annee = 2018;
                            """);
            connectionField.setText("Connection est un succès !");

        }
        catch(Exception e){
            res = """
                    Ce résultat ne vient pas de la db, un bug c'est produit\n
                    France                  
                   """;
        }
        responseField.setText(res);
    }
    @FXML
    protected void Question2() {
        questionField.setText("""
                De tous les joueurs de la France, de l'Argentine et de Brezil, Qui(Nom, Prenom) sont les joueurs (qui ne sont pas gardiens) les plus prometteurs? CAD dont le ratio buts/Nb de matchs joues > 0.5?
                """);
        responseField.setText("Waiting query response...");
        String res;
        try{
        res = ormInterface.ExecuteQuery(
                """
                        SELECT nom, prenom\s
                                FROM Joueur_info as joueurs
                                WHERE (pays IN ('France', 'Argentina', 'Brazil'))\s
                                AND (position != 'Goalkeeper')\s
                                AND joueurs.nb_matchs_joues != 0
                                AND (CAST(joueurs.nb_buts AS float) / CAST(joueurs.nb_matchs_joues AS float)) >= 0.5 ;
                """);
            connectionField.setText("Connection est un succès !");

        }
        catch(Exception e){
            connectionField.setText("Echec de la connection: Changez la configuration du fichier hibernate.cfg.xml. \n Assurez vous d'avoir run les schemas et d'avoir run les fichiers sql pour les schemas.");

            res = """
                    Ce résultat ne vient pas de la db, un bug c'est produit\n
                    Jr , Neymar ,\s
                    Messi , Lionel ,\s
                                       
                   """;
        }
        responseField.setText(res);

    }
    @FXML
    protected void Question3() {
        questionField.setText("""
                Quel(s) sont matchs avec les resultats les plus innatendues de 2022? CAD ou le resultat d'une partie, lequipe gagnante avait un ecart de coupes gagnees avec l'equipe perdante maximale?
                """);
        responseField.setText("Waiting query response...");
        String res;
        try{
        res = ormInterface.ExecuteQuery(
                """
                                SELECT equipe_gagnante,equipe_perdante, difference
                                        FROM (
                                            SELECT equipe1, equipe2, score_final, eq1.nb_coupes_gagnees as nb1, eq2.nb_coupes_gagnees as nb2,\s
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
                        """);
            connectionField.setText("Connection est un succès !");

    }
        catch (Exception e){
            connectionField.setText("Echec de la connection: Changez la configuration du fichier hibernate.cfg.xml. \n Assurez vous d'avoir run les schemas et d'avoir run les fichiers sql pour les schemas.");

            res =
                    "Ce résultat ne vient pas de la db, un bug c'est produit\n" +
                            "France , Brazil , 3";
        }
        responseField.setText(res);
    }
    @FXML
    protected void Question4() {
        questionField.setText("Qui(Nom, Prenom) est l'arbitre ayant donne le plus de cartons jaunes?");
        responseField.setText("Waiting query response...");
        String res;
        try {
            res = ormInterface.ExecuteQuery(
                    """
                                    SELECT nom, prenom, nombre_de_cartons_jaune
                                            FROM (
                                            	select count(*) as nombre_de_cartons_jaune, NoMatch from joueur_sanction
                                            	where type_carton = 'Yellow'
                                            	GROUP BY NoMatch
                                            ) as tab
                                            JOIN\s
                                            (
                                            	select sanctionne_par.NoArbitre, nom, prenom, NoMatch from arbitre
                                            	JOIN sanctionne_par
                                            	ON sanctionne_par.NoArbitre = arbitre.NoArbitre
                                            	where "type" = 'Main'
                                            ) as tab1
                                            ON tab.NoMatch = tab1.NoMatch
                                            Order by nombre_de_cartons_jaune desc
                            """);
            connectionField.setText("Connection est un succès !");

        }
        catch (Exception e){
            res =
                    """
                    MÃ¼ller , Gerard , 2 ,\s
                    Silva , Ana , 2 ,\s
                    van der Berg , Pieter , 2 ,\s
                    Fernandez , Carlos , 2 ,\s
                    Smith , John , 1 ,\s
                    Martinez , Pedro , 1 ,\s
                    """;
            connectionField.setText("Echec de la connection: Changez la configuration du fichier hibernate.cfg.xml. \n Assurez vous d'avoir run les schemas et d'avoir run les fichiers sql pour les schemas.");

        }
        responseField.setText(res);
    }
}