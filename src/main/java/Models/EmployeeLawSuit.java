package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Employee_LawSuit", schema = "organizer_ft", catalog = "")
public class EmployeeLawSuit {
    private String cpf;
    private Employee employeeByCpf;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
    @JoinColumn(name = "CPF", referencedColumnName = "CPF", nullable = false)
    public Employee getEmployeeByCpf() {
        return employeeByCpf;
    }

    public void setEmployeeByCpf(Employee employeeByCpf) {
        this.employeeByCpf = employeeByCpf;
    }
}
