package Models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class LawSuitEvent {
    private Integer id;
    private Timestamp startTime;
    private Timestamp endTime;
    private String description;
    private LawSuit lawSuitByLawSuitId;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "StartTime", nullable = false)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "EndTime", nullable = false)
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "Description", nullable = false, length = 10000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LawSuitEvent that = (LawSuitEvent) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, endTime, description);
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
