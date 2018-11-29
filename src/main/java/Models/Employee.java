package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee {
    private String cpf;
    private String name;
    private Integer accessLevel;
    private String login;
    private String token;
    private Integer id;
    private String salary;
    private String phone;
    private String position;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "CPF", nullable = false, length = 11)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
    @Column(name = "Phone", nullable = false, length = 200)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Salary", nullable = false, length = 200)
    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "Position", nullable = false, length = 200)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Basic
    @Column(name = "AccessLevel", nullable = false)
    public Integer getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Basic
    @Column(name = "Login", nullable = false, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "Token", nullable = true, length = 256)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(cpf, employee.cpf) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(accessLevel, employee.accessLevel) &&
                Objects.equals(login, employee.login) &&
                Objects.equals(token, employee.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, name, accessLevel, login, token);
    }

    @Override
    public String toString(){
        return getName(); //Whatever you want to show
    }
}
