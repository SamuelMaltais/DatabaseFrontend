package schemas;

import jakarta.persistence.*;

@Entity
@Table(name = "jouer")
public class Jouer {
    @EmbeddedId
    private JouerId id;

    @MapsId("pays")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pays", nullable = false)
    private Equipe pays;

    @MapsId("nomatch")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nomatch", nullable = false)
    private Match nomatch;

    public JouerId getId() {
        return id;
    }

    public void setId(JouerId id) {
        this.id = id;
    }

    public Equipe getPays() {
        return pays;
    }

    public void setPays(Equipe pays) {
        this.pays = pays;
    }

    public Match getNomatch() {
        return nomatch;
    }

    public void setNomatch(Match nomatch) {
        this.nomatch = nomatch;
    }

}