import Models.Employee;
import Models.EmployeeLawSuit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeLawSuitTest {

    private EmployeeLawSuit employeeLawSuit;
    private Employee employee;

    @Before
    public void init() {
        employeeLawSuit = new EmployeeLawSuit();
        employee = new Employee();
    }

    @Test
    public void getId() {
        Assert.assertNull(employeeLawSuit.getId());
    }

    @Test
    public void setId() {
        employeeLawSuit.setId((Integer)12345);
        Assert.assertEquals((Integer)12345,employeeLawSuit.getId());
    }

    @Test
    public void getCpf() {
        Assert.assertNull(employeeLawSuit.getCpf());
    }

    @Test
    public void setCpf() {
        employeeLawSuit.setCpf("111.222.333.444-55");
        Assert.assertEquals("111.222.333.444-55", employeeLawSuit.getCpf());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(employeeLawSuit);
    }

    @Test
    public void getEmployeeByCpf() {
        Assert.assertNull(employeeLawSuit.getEmployeeByCpf());
    }

    @Test
    public void setEmployeeByCpf() {
        employeeLawSuit.setEmployeeByCpf(employee);
        Assert.assertEquals(employee,employeeLawSuit.getEmployeeByCpf());
    }
}