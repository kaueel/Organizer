package Models;

import Controllers.DataController;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Country {
    private Short id;
    private String countryName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Country", nullable = false, length = 50)
    public String getCountry() {
        return countryName;
    }

    public void setCountry(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country1 = (Country) o;
        return Objects.equals(id, country1.id) &&
                Objects.equals(countryName, country1.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryName);
    }

}
