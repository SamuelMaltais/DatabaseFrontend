package schemas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class JouerId implements java.io.Serializable {
    private static final long serialVersionUID = 5588129717407608728L;
    @Column(name = "pays", nullable = false)
    private String pays;

    @Column(name = "nomatch", nullable = false)
    private Integer nomatch;

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Integer getNomatch() {
        return nomatch;
    }

    public void setNomatch(Integer nomatch) {
        this.nomatch = nomatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JouerId entity = (JouerId) o;
        return Objects.equals(this.nomatch, entity.nomatch) &&
                Objects.equals(this.pays, entity.pays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomatch, pays);
    }

}