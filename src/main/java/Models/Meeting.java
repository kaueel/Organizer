package Models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Meeting {
    private Integer id;
    private Date dateTime;
    private String subject;
    private String description;
    private LawSuit lawSuitByLawSuitId;
    private Client clientByClientId;
    private String local;

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
    @Column(name = "DateTime", nullable = false)
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
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
                Objects.equals(dateTime, meeting.dateTime) &&
                Objects.equals(subject, meeting.subject) &&
                Objects.equals(description, meeting.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, subject, description);
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

    @Basic
    @Column(name = "Local", nullable = false)
    public String getLocal() { return local; }

    public void setLocal(String local) { this.local = local; }
}
