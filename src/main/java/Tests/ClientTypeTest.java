import Models.ClientType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientTypeTest {

    private ClientType clientType;

    @Before
    public  void init () {
        clientType = new ClientType();
    }

    @Test
    public void getId() {
        Assert.assertNull(clientType.getId());
    }

    @Test
    public void setId() {
        clientType.setId(2);
        Assert.assertEquals((Integer) 2,clientType.getId());
    }

    @Test
    public void getName() {
        Assert.assertNull(clientType.getName());
    }

    @Test
    public void setName() {
        clientType.setName("TestName");
        Assert.assertEquals("TestName",clientType.getName());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(clientType);
    }
}