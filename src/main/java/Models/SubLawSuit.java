package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class SubLawSuit {
    private Integer number;
    private LawSuit lawSuitByLawSuitId;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Number", nullable = false)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubLawSuit that = (SubLawSuit) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @ManyToOne
    @JoinColumn(name = "LawSuitID", referencedColumnName = "ID", nullable = false)
    public LawSuit getLawSuitByLawSuitId() {
        return lawSuitByLawSuitId;
    }

    public void setLawSuitByLawSuitId(LawSuit lawSuitByLawSuitId) {
        this.lawSuitByLawSuitId = lawSuitByLawSuitId;
    }
}
