package schemas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "arbitre")
public class Arbitre {
    @Id
    @Column(name = "noarbitre", nullable = false)
    private Integer id;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "nb_matchs")
    private Integer nbMatchs;

    @Column(name = "jour_naiss")
    private Integer jourNaiss;

    @Column(name = "mois_naiss")
    private Integer moisNaiss;

    @Column(name = "annee_naiss")
    private Integer anneeNaiss;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nationalite")
    private String nationalite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNbMatchs() {
        return nbMatchs;
    }

    public void setNbMatchs(Integer nbMatchs) {
        this.nbMatchs = nbMatchs;
    }

    public Integer getJourNaiss() {
        return jourNaiss;
    }

    public void setJourNaiss(Integer jourNaiss) {
        this.jourNaiss = jourNaiss;
    }

    public Integer getMoisNaiss() {
        return moisNaiss;
    }

    public void setMoisNaiss(Integer moisNaiss) {
        this.moisNaiss = moisNaiss;
    }

    public Integer getAnneeNaiss() {
        return anneeNaiss;
    }

    public void setAnneeNaiss(Integer anneeNaiss) {
        this.anneeNaiss = anneeNaiss;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

}