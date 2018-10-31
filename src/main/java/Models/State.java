package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "State", schema = "organizer_ft")
public class State {
    private int id;
    private int codigoUf;
    private int regiao;
    private String nome;
    private String uf;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CodigoUf")
    public int getCodigoUf() {
        return codigoUf;
    }

    public void setCodigoUf(int codigoUf) {
        this.codigoUf = codigoUf;
    }

    @Basic
    @Column(name = "Regiao")
    public int getRegiao() {
        return regiao;
    }

    public void setRegiao(int regiao) {
        this.regiao = regiao;
    }

    @Basic
    @Column(name = "Nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "Uf")
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State that = (State) o;
        return id == that.id &&
                codigoUf == that.codigoUf &&
                regiao == that.regiao &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(uf, that.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoUf, regiao, nome, uf);
    }
}

