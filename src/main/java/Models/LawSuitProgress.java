package Models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "LawSuit_Progress", schema = "organizer_ft", catalog = "")
public class LawSuitProgress {
    private Integer id;
    private String description;
    private Timestamp date;
    private LawSuit lawSuitByLawSuitId;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Description", nullable = false, length = 2000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LawSuitProgress that = (LawSuitProgress) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, date);
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
