package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Client {
    private Integer id;
    private String name;
    private String email;
    private Integer addressNumber;
    private String documentNUmber;
    private Address addressByAddressId;

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
    @Column(name = "Name", nullable = false, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 200)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "AddressNumber", nullable = false)
    public Integer getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(Integer addressNumber) {
        this.addressNumber = addressNumber;
    }

    @Basic
    @Column(name = "DocumentNUmber", nullable = false, length = 50)
    public String getDocumentNUmber() {
        return documentNUmber;
    }

    public void setDocumentNUmber(String documentNUmber) {
        this.documentNUmber = documentNUmber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(name, client.name) &&
                Objects.equals(email, client.email) &&
                Objects.equals(addressNumber, client.addressNumber) &&
                Objects.equals(documentNUmber, client.documentNUmber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, addressNumber, documentNUmber);
    }

    @ManyToOne
    @JoinColumn(name = "AddressID", referencedColumnName = "ID", nullable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }
}
