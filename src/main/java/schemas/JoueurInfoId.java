package schemas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class JoueurInfoId implements java.io.Serializable {
    private static final long serialVersionUID = -2158453597989852060L;
    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "pays", nullable = false)
    private String pays;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JoueurInfoId entity = (JoueurInfoId) o;
        return Objects.equals(this.numero, entity.numero) &&
                Objects.equals(this.pays, entity.pays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, pays);
    }

}