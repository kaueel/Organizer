package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class LawSuit {
    private int id;
    private Client clientByClientId;
    private Employee employeeByEmployee;
    private String oppositeName;
    private String oppositeDocument;
    private String number;
    private String title;
    private String description;
    private String forum;
    private String court;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LawSuit lawSuit = (LawSuit) o;
        return Objects.equals(id, lawSuit.id);
    }

    @Basic
    @Column(name = "Number", nullable = false)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "Title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Forum", nullable = false)
    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    @Basic
    @Column(name = "Court", nullable = false)
    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    @Basic
    @Column(name = "Type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "OppositeName", nullable = false)
    public String getOppositeName() {
        return oppositeName;
    }

    public void setOppositeName(String oppositeName) {
        this.oppositeName = oppositeName;
    }

    @Basic
    @Column(name = "OppositeDocument", nullable = false)
    public String getOppositeDocument() {
        return oppositeDocument;
    }

    public void setOppositeDocument(String oppositeDocument) {
        this.oppositeDocument = oppositeDocument;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "ClientID", referencedColumnName = "ID", nullable = false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }


    @ManyToOne
    @JoinColumn(name = "EmployeeID", referencedColumnName = "ID", nullable = false)
    public Employee getEmployeeByEmployee() {
        return employeeByEmployee;
    }

    public void setEmployeeByEmployee(Employee employeeByEmployee) {
        this.employeeByEmployee = employeeByEmployee;
    }


    @Override
    public String toString() {
        return getTitle();
    }
}
