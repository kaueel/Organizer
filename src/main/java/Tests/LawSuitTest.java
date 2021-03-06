package Tests;

import Models.Client;
import Models.LawSuit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LawSuitTest {

    private LawSuit lawSuit;
    private Client client;

    @Before
    public void init() {
        lawSuit = new LawSuit();
        client = new Client();
    }

    @Test
    public void getId() {
        Assert.assertNull(lawSuit.getId());
    }

    @Test
    public void setId() {
        lawSuit.setId(12345);
        Assert.assertEquals(12345,lawSuit.getId());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(lawSuit);
    }

    @Test
    public void getClientByClientId() {
        Assert.assertNull(lawSuit.getClientByClientId());
    }

    @Test
    public void setClientByClientId() {
        lawSuit.setClientByClientId(client);
        Assert.assertEquals(client,lawSuit.getClientByClientId());
    }
}