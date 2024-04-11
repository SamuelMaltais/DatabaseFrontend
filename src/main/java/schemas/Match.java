package schemas;

import jakarta.persistence.*;

@Entity
@Table(name = "match")
public class Match {
    @Id
    @Column(name = "nomatch", nullable = false)
    private Integer id;

    @Column(name = "score_final", length = 50)
    private String scoreFinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe1")
    private Equipe equipe1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe2")
    private Equipe equipe2;

    @Column(name = "rang")
    private Integer rang;

    @Column(name = "jour")
    private Integer jour;

    @Column(name = "mois")
    private Integer mois;

    @Column(name = "annee")
    private Integer annee;

    @Column(name = "lieu")
    private String lieu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScoreFinal() {
        return scoreFinal;
    }

    public void setScoreFinal(String scoreFinal) {
        this.scoreFinal = scoreFinal;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public Integer getRang() {
        return rang;
    }

    public void setRang(Integer rang) {
        this.rang = rang;
    }

    public Integer getJour() {
        return jour;
    }

    public void setJour(Integer jour) {
        this.jour = jour;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

}