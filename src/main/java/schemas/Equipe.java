package schemas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipe")
public class Equipe {
    @Id
    @Column(name = "pays", nullable = false)
    private String pays;

    @Column(name = "nb_coupes_gagnees")
    private Integer nbCoupesGagnees;

    @Column(name = "nb_participations")
    private Integer nbParticipations;

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Integer getNbCoupesGagnees() {
        return nbCoupesGagnees;
    }

    public void setNbCoupesGagnees(Integer nbCoupesGagnees) {
        this.nbCoupesGagnees = nbCoupesGagnees;
    }

    public Integer getNbParticipations() {
        return nbParticipations;
    }

    public void setNbParticipations(Integer nbParticipations) {
        this.nbParticipations = nbParticipations;
    }

}