package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Employee_LawSuit", schema = "organizer_ft")
public class EmployeeLawSuit {
    private String cpf;
    private Employee employeeByCpf;
    private Integer this_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public Integer getId() {
        return this_id;
    }

    public void setId(Integer id) {
        this.this_id = id;
    }

    @Column(name = "CPF", nullable = false, length = 11)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeLawSuit that = (EmployeeLawSuit) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @OneToOne
    @JoinColumn(name = "CPF", referencedColumnName = "CPF", nullable = false, insertable = false, updatable = false)
    public Employee getEmployeeByCpf() {
        return employeeByCpf;
    }

    public void setEmployeeByCpf(Employee employeeByCpf) {
        this.employeeByCpf = employeeByCpf;
    }
}
