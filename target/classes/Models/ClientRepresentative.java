package Models;

import javax.persistence.*;

@Entity
public class ClientRepresentative {
    private Client clientByClientId;
    private Client clientByRepresentativeId;
    private Integer this_id;

    @ManyToOne
    @JoinColumn(name = "ClientID", referencedColumnName = "ID", nullable = false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "RepresentativeID", referencedColumnName = "ID", nullable = false)
    public Client getClientByRepresentativeId() {
        return clientByRepresentativeId;
    }

    public void setClientByRepresentativeId(Client clientByRepresentativeId) {
        this.clientByRepresentativeId = clientByRepresentativeId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getThis_id() {
        return this_id;
    }

    public void setThis_id(Integer this_id) {
        this.this_id = this_id;
    }
}
