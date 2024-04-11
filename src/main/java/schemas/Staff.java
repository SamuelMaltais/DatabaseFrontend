package schemas;

import jakarta.persistence.*;

@Entity
@Table(name = "staff")
public class Staff {
    @EmbeddedId
    private StaffId id;

    @MapsId("pays")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pays", nullable = false)
    private Equipe pays;

    @Column(name = "poste")
    private String poste;

    @Column(name = "nationalite")
    private String nationalite;

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

    public StaffId getId() {
        return id;
    }

    public void setId(StaffId id) {
        this.id = id;
    }

    public Equipe getPays() {
        return pays;
    }

    public void setPays(Equipe pays) {
        this.pays = pays;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
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

}