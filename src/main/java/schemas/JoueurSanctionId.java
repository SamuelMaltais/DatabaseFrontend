package schemas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class JoueurSanctionId implements java.io.Serializable {
    private static final long serialVersionUID = -3930530878573133220L;
    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "pays", nullable = false)
    private String pays;

    @Column(name = "nomatch", nullable = false)
    private Integer nomatch;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

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
        JoueurSanctionId entity = (JoueurSanctionId) o;
        return Objects.equals(this.nomatch, entity.nomatch) &&
                Objects.equals(this.numero, entity.numero) &&
                Objects.equals(this.pays, entity.pays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomatch, numero, pays);
    }

}