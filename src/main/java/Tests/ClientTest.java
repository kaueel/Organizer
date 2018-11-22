package Tests;

import Models.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    }

    @Test
    public void setClientTypeByClientTypeId() {
        client.setClientTypeByClientTypeId(null);
        Assert.assertNull(client.getClientTypeByClientTypeId());
    }

    @Test
    public void getPhone() {
    }

    @Test
    public void setPhone() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void getEmail() {
    }

    @Test
    public void setEmail() {
    }

    @Test
    public void getDocumentNumber() {
    }

    @Test
    public void setDocumentNumber() {
    }

    @Test
    public void equals() {
    }

    @Test
    public void getAddressByAddressId() {
    }

    @Test
    public void setAddressByAddressId() {
    }
}