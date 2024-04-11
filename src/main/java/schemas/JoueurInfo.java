package schemas;

import jakarta.persistence.*;

@Entity
@Table(name = "joueur_info")
public class JoueurInfo {
    @EmbeddedId
    private JoueurInfoId id;

    @MapsId("pays")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pays", nullable = false)
    private Equipe pays;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "jour_naiss")
    private Integer jourNaiss;

    @Column(name = "mois_naiss")
    private Integer moisNaiss;

    @Column(name = "annee_naiss")
    private Integer anneeNaiss;

    @Column(name = "\"position\"", length = 50)
    private String position;

    @Column(name = "nb_buts")
    private Integer nbButs;

    @Column(name = "nb_matchs_joues")
    private Integer nbMatchsJoues;

    public JoueurInfoId getId() {
        return id;
    }

    public void setId(JoueurInfoId id) {
        this.id = id;
    }

    public Equipe getPays() {
        return pays;
    }

    public void setPays(Equipe pays) {
        this.pays = pays;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getNbButs() {
        return nbButs;
    }

    public void setNbButs(Integer nbButs) {
        this.nbButs = nbButs;
    }

    public Integer getNbMatchsJoues() {
        return nbMatchsJoues;
    }

    public void setNbMatchsJoues(Integer nbMatchsJoues) {
        this.nbMatchsJoues = nbMatchsJoues;
    }

}