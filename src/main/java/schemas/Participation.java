package schemas;

import jakarta.persistence.*;

@Entity
@Table(name = "participation")
public class Participation {
    @EmbeddedId
    private ParticipationId id;

    @MapsId("pays")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pays", nullable = false)
    private Equipe pays;

    @MapsId("edition")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "edition", nullable = false)
    private Coupe edition;

    public ParticipationId getId() {
        return id;
    }

    public void setId(ParticipationId id) {
        this.id = id;
    }

    public Equipe getPays() {
        return pays;
    }

    public void setPays(Equipe pays) {
        this.pays = pays;
    }

    public Coupe getEdition() {
        return edition;
    }

    public void setEdition(Coupe edition) {
        this.edition = edition;
    }

}