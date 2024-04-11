package schemas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class StaffId implements java.io.Serializable {
    private static final long serialVersionUID = 3935363268664751739L;
    @Column(name = "nostaff", nullable = false)
    private Integer nostaff;

    @Column(name = "pays", nullable = false)
    private String pays;

    public Integer getNostaff() {
        return nostaff;
    }

    public void setNostaff(Integer nostaff) {
        this.nostaff = nostaff;
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
        StaffId entity = (StaffId) o;
        return Objects.equals(this.nostaff, entity.nostaff) &&
                Objects.equals(this.pays, entity.pays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nostaff, pays);
    }

}