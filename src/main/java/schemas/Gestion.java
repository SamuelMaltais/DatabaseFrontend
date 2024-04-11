package schemas;

import jakarta.persistence.*;

@Entity
@Table(name = "gestion")
public class Gestion {
    @EmbeddedId
    private GestionId id;

    @MapsId("nomatch")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nomatch", nullable = false)
    private Match nomatch;

    @MapsId("noarbitre")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "noarbitre", nullable = false)
    private Arbitre noarbitre;

    public GestionId getId() {
        return id;
    }

    public void setId(GestionId id) {
        this.id = id;
    }

    public Match getNomatch() {
        return nomatch;
    }

    public void setNomatch(Match nomatch) {
        this.nomatch = nomatch;
    }

    public Arbitre getNoarbitre() {
        return noarbitre;
    }

    public void setNoarbitre(Arbitre noarbitre) {
        this.noarbitre = noarbitre;
    }

}