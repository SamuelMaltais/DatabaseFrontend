package schemas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class ParticipationId implements java.io.Serializable {
    private static final long serialVersionUID = -7730248439351157454L;
    @Column(name = "pays", nullable = false)
    private String pays;

    @Column(name = "edition", nullable = false)
    private Integer edition;

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ParticipationId entity = (ParticipationId) o;
        return Objects.equals(this.edition, entity.edition) &&
                Objects.equals(this.pays, entity.pays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(edition, pays);
    }

}