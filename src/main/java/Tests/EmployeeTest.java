import Models.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;

import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee employee;

    @Before
    public void init(){
        employee = new Employee();
    }
    @Test
    public void getId() {
        Assert.assertNull(employee.getId());
    }

    @Test
    public void setId() {
        employee.setId(22);
        Assert.assertEquals((Integer) 22,employee.getId());
    }

    @Test
    public void getCpf() {
        Assert.assertNull(employee.getCpf());
    }

    @Test
    public void setCpf() {
        employee.setCpf("111.222.333.444.55");
        Assert.assertEquals("111.222.333.444.55",employee.getCpf());
    }

    @Test
    public void getName() {
        Assert.assertNull(employee.getName());
    }

    @Test
    public void setName() {
        employee.setName("NameTest");
        Assert.assertEquals("NameTest",employee.getName());
    }

    @Test
    public void getPhone() {
        Assert.assertNull(employee.getPhone());
    }

    @Test
    public void setPhone() {
        employee.setPhone("91111-1111");
        Assert.assertEquals("91111-1111", employee.getPhone());
    }

    @Test
    public void getSalary() {
        Assert.assertNull(employee.getSalary());
    }

    @Test
    public void setSalary() {
        employee.setSalary("1.500");
        Assert.assertEquals("1.500",employee.getSalary());
    }

    @Test
    public void getPosition() {
        Assert.assertNull(employee.getPosition());
    }

    @Test
    public void setPosition() {
        employee.setPosition("PositionName");
        Assert.assertEquals("PositionName",employee.getPosition());
    }

    @Test
    public void getAccessLevel() {
        Assert.assertNull(employee.getAccessLevel());
    }

    @Test
    public void setAccessLevel() {
        employee.setAccessLevel(43);
        Assert.assertEquals((Integer)43,employee.getAccessLevel());
    }

    @Test
    public void getLogin() {
        Assert.assertNull(employee.getLogin());
    }

    @Test
    public void setLogin() {
        employee.setLogin("LoginTest");
        Assert.assertEquals("LoginTest",employee.getLogin());
    }

    @Test
    public void getToken() {
        Assert.assertNull(employee.getToken());
    }

    @Test
    public void setToken() {
        employee.setToken("TestToken");
        Assert.assertEquals("TestToken",employee.getToken());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(employee);
    }
}