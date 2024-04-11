package schemas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class SanctionneParId implements java.io.Serializable {
    private static final long serialVersionUID = -2258771300772940267L;
    @Column(name = "nomatch", nullable = false)
    private Integer nomatch;

    @Column(name = "noarbitre", nullable = false)
    private Integer noarbitre;

    public Integer getNomatch() {
        return nomatch;
    }

    public void setNomatch(Integer nomatch) {
        this.nomatch = nomatch;
    }

    public Integer getNoarbitre() {
        return noarbitre;
    }

    public void setNoarbitre(Integer noarbitre) {
        this.noarbitre = noarbitre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SanctionneParId entity = (SanctionneParId) o;
        return Objects.equals(this.nomatch, entity.nomatch) &&
                Objects.equals(this.noarbitre, entity.noarbitre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomatch, noarbitre);
    }

}