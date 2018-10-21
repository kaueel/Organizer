package Models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Meeting {
    private Integer id;
    private Timestamp startTime;
    private String subject;
    private String description;
    private LawSuit lawSuitByLawSuitId;
    private Client clientByClientId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "Subject", nullable = false, length = 2000)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 10000)
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
        Meeting meeting = (Meeting) o;
        return Objects.equals(id, meeting.id) &&
                Objects.equals(startTime, meeting.startTime) &&
                Objects.equals(subject, meeting.subject) &&
                Objects.equals(description, meeting.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, subject, description);
    }

    @ManyToOne
    @JoinColumn(name = "LawSuitID", referencedColumnName = "ID", nullable = false)
    public LawSuit getLawSuitByLawSuitId() {
        return lawSuitByLawSuitId;
    }

    public void setLawSuitByLawSuitId(LawSuit lawSuitByLawSuitId) {
        this.lawSuitByLawSuitId = lawSuitByLawSuitId;
    }

    @ManyToOne
    @JoinColumn(name = "ClientID", referencedColumnName = "ID", nullable = false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }
}
