package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {
    private Integer id;
    private String address;
    private String address2;
    private String district;
    private String postalCode;
    private City cityByCityId;
    private State stateByStateId;

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
    @JoinColumn(name = "CityID", referencedColumnName = "ID", nullable = false)
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }


    @ManyToOne
    @JoinColumn(name = "StateID", referencedColumnName = "ID", nullable = false)
    public State getStateByStateId() {
        return stateByStateId;
    }

    public void setStateByStateId(State stateByStateId) {
        this.stateByStateId = stateByStateId;
    }



    @Basic
    @Column(name = "Address", nullable = false, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Address2", nullable = true, length = 50)
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "District", nullable = false, length = 20)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "Postal_code", nullable = true, length = 10)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(id, address1.id) &&
                Objects.equals(address, address1.address) &&
                Objects.equals(address2, address1.address2) &&
                Objects.equals(district, address1.district) &&
                Objects.equals(postalCode, address1.postalCode) &&
                Objects.equals(cityByCityId, address1.cityByCityId) &&
                Objects.equals(stateByStateId, address1.stateByStateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, address2, district, postalCode, cityByCityId, stateByStateId);
    }
}
