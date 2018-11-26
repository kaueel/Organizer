package Tests;

import Models.Address;
import Models.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.Null;

public class ClientTest {

    private Client client;

    @Before
    public void init() {
        client = new Client();
    }

    @Test
    public void getId() {

        Assert.assertNull(client.getId());
    }

    @Test
    public void setId() {
        client.setId(2);
        Assert.assertEquals((Integer) 2, client.getId());
    }

    @Test
    public void getClientTypeByClientTypeId() {
        Assert.assertNull(client.getClientTypeByClientTypeId());
    }

    @Test
    public void setClientTypeByClientTypeId() {
        client.setClientTypeByClientTypeId(null);
        Assert.assertNull(client.getClientTypeByClientTypeId());
    }

    @Test
    public void getPhone() {
        Assert.assertNull(client.getPhone());
    }

    @Test
    public void setPhone() {
        client.setPhone("9999-9999");
        Assert.assertEquals("9999-9999", client.getPhone());
    }

    @Test
    public void getName() {
        Assert.assertNull(client.getName());
    }

    @Test
    public void setName() {
        client.setName("Test Name Class");
        Assert.assertEquals("Test Name Class",client.getName());
    }

    @Test
    public void getEmail() {
        Assert.assertNull(client.getPhone());
    }

    @Test
    public void setEmail() {
        client.setEmail("teste@email.com");
        Assert.assertEquals("teste@email.com", client.getEmail());
    }

    @Test
    public void getDocumentNumber() {
        Assert.assertNull(client.getDocumentNumber());
    }

    @Test
    public void setDocumentNumber() {
        client.setDocumentNumber("DocumentoTest");
        Assert.assertEquals("DocumentoTest", client.getDocumentNumber());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(client);
    }

    @Test
    public void getAddressByAddressId() {
        Assert.assertNull(client.getAddressByAddressId());
    }

    @Test
    public void setAddressByAddressId() {
        Address ad = new Address();
        ad.setAddress("test");
        client.setAddressByAddressId(ad);
        Assert.assertNotNull(client.getAddressByAddressId());
    }
}