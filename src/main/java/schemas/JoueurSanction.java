package schemas;

import jakarta.persistence.*;

@Entity
@Table(name = "joueur_sanction")
public class JoueurSanction {
    @EmbeddedId
    private JoueurSanctionId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private JoueurInfo joueurInfo;

    @MapsId("nomatch")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nomatch", nullable = false)
    private Match nomatch;

    @Column(name = "type_carton", length = 50)
    private String typeCarton;

    @Column(name = "raison", length = Integer.MAX_VALUE)
    private String raison;

    public JoueurSanctionId getId() {
        return id;
    }

    public void setId(JoueurSanctionId id) {
        this.id = id;
    }

    public JoueurInfo getJoueurInfo() {
        return joueurInfo;
    }

    public void setJoueurInfo(JoueurInfo joueurInfo) {
        this.joueurInfo = joueurInfo;
    }

    public Match getNomatch() {
        return nomatch;
    }

    public void setNomatch(Match nomatch) {
        this.nomatch = nomatch;
    }

    public String getTypeCarton() {
        return typeCarton;
    }

    public void setTypeCarton(String typeCarton) {
        this.typeCarton = typeCarton;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

}