import Models.Client;
import Models.ClientRepresentative;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientRepresentativeTest {

    private ClientRepresentative clientRepresentative;
    private Client client;

    @Before
    public void init() {
        clientRepresentative = new ClientRepresentative();
        client = new Client();
    }

    @Test
    public void getClientByClientId() {
        Assert.assertNull(clientRepresentative.getClientByClientId());
    }

    @Test
    public void setClientByClientId() {
        clientRepresentative.setClientByClientId(client);
        Assert.assertEquals(client,clientRepresentative.getClientByClientId());
    }

    @Test
    public void getClientByRepresentativeId() {
        Assert.assertNull(clientRepresentative.getClientByRepresentativeId());
    }

    @Test
    public void setClientByRepresentativeId() {
        clientRepresentative.setClientByRepresentativeId(client);
        Assert.assertEquals(client,clientRepresentative.getClientByRepresentativeId());
    }

    @Test
    public void getThis_id() {
        Assert.assertNull(clientRepresentative.getThis_id());
    }

    @Test
    public void setThis_id() {
        clientRepresentative.setThis_id((Integer)112);
        Assert.assertEquals((Integer) 112,clientRepresentative.getThis_id());
    }
}