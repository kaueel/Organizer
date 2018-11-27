import Models.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressTest {

    private Address address;

    @Before
    public void init() {
        address = new Address();
    }

    @Test
    public void getId() {
        Assert.assertNull(address.getAddress());
    }

    @Test
    public void setId() {
        address.setId(1);
        Assert.assertEquals((Integer) 1, address.getId());
    }

    @Test
    public void getCityByCityId() {
        Assert.assertNull(address.getAddress());
    }

    @Test
    public void getStateByStateId() {
        Assert.assertNull(address.getStateByStateId());
    }

    @Test
    public void setStateByStateId() {
    }

    @Test
    public void getAddress() {
        Assert.assertNull(address.getAddress());
    }

    @Test
    public void setAddress() {
        address.setAddress("teste");
        Assert.assertEquals("teste", address.getAddress());
    }

    @Test
    public void getAddress2() {
        Assert.assertNull(address.getAddress2());
    }

    @Test
    public void setAddress2() {
        address.setAddress2("teste2");
        Assert.assertEquals("teste2",address.getAddress2());
    }

    @Test
    public void getDistrict() {
        Assert.assertNull(address.getDistrict());
    }

    @Test
    public void setDistrict() {
        address.setDistrict("testDistrict");
        Assert.assertEquals("testDistrict",address.getDistrict());
    }

    @Test
    public void getPostalCode() {
        Assert.assertNull(address.getPostalCode());
    }

    @Test
    public void setPostalCode() {
        address.setPostalCode("TestPostalCode");
        Assert.assertEquals("TestPostalCode",address.getPostalCode());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(address);
    }
}