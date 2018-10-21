package Models;

import javax.persistence.*;

@Entity
public class ClientRepresentative {
    private Client clientByClientId;
    private Client clientByRepresentativeId;

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

    private String this_id;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public String getThis_id() {
        return this_id;
    }

    public void setThis_id(String this_id) {
        this.this_id = this_id;
    }
}
