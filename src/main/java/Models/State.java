package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class State {
    private Integer id;
    private String stateName;
    private Integer regiao;
    private String uf;

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
    @Column(name = "Regiao", nullable = true)
    public Integer getRegiao() {
        return regiao;
    }

    public void setRegiao(Integer mregiao) {
        this.regiao = mregiao;
    }


    @Basic
    @Column(name = "Nome", nullable = true, length = 50)
    public String getState() {
        return stateName;
    }

    public void setState(String stateName) {
        this.stateName = stateName;
    }


    @Basic
    @Column(name = "Uf", nullable = false, length = 50)
    public String getUf() {
        return uf;
    }

    public void setUf(String ufValue) {
        this.uf = ufValue;
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


    @Override
    public String toString() {
        return this.getState();
    }
}
