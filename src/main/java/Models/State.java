package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class State {
    private Integer id;
    private String stateName;

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
    @Column(name = "State", nullable = false, length = 50)
    public String getState() {
        return stateName;
    }

    public void setState(String countryName) {
        this.stateName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state1 = (State) o;
        return Objects.equals(id, state1.id) &&
                Objects.equals(stateName, state1.stateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stateName);
    }

}
