package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Client {
    private Integer id;
    private String name;
    private String email;
    private String documentNumber;
    private String addressNumber;
    private Address addressByAddressId;
    private String phone;
    private ClientType clientTypeByClientTypeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "ClientTypeID", referencedColumnName = "ID", nullable = false)
    public ClientType getClientTypeByClientTypeId() {
        return clientTypeByClientTypeId;
    }

    public void setClientTypeByClientTypeId(ClientType clientTypeByClientTypeId) {
        this.clientTypeByClientTypeId = clientTypeByClientTypeId;
    }

    @Basic
    @Column(name = "Phone", nullable = false, length = 200)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "AddressNumber", nullable = true, length = 200)
    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String mnumber) {
        this.addressNumber = mnumber;
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
    @Column(name = "DocumentNumber", nullable = false, length = 50)
    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNUmber) {
        this.documentNumber = documentNUmber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(name, client.name) &&
                Objects.equals(email, client.email) &&
                Objects.equals(addressByAddressId, client.addressByAddressId) &&
                Objects.equals(documentNumber, client.documentNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, addressByAddressId, documentNumber);
    }

    @Override
    public String toString(){
        return getName(); //Whatever you want to show
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
