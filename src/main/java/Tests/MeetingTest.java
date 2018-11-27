import Models.Client;
import Models.LawSuit;
import Models.Meeting;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.Timestamp;

import static org.junit.Assert.*;

public class MeetingTest {

    private Meeting meeting;
    private LawSuit lawSuit;
    private Client client;
    private Timestamp timestamp;

    @Before
    public void init() {
        meeting = new Meeting();
        lawSuit = new LawSuit();
        client = new Client();
        Date date = new Date(23);
        timestamp = new Timestamp(date.getTime());
    }

    @Test
    public void getId() {
        Assert.assertNull(meeting.getId());
    }

    @Test
    public void setId() {
        meeting.setId((Integer)12345);
        Assert.assertEquals((Integer)12345,meeting.getId());
    }

    @Test
    public void getStartTime() {
        Assert.assertNull(meeting.getStartTime());
    }

    @Test
    public void setStartTime() {
        meeting.setStartTime(timestamp);
        Assert.assertEquals(timestamp,meeting.getStartTime());
    }

    @Test
    public void getSubject() {
        Assert.assertNull(meeting.getSubject());
    }

    @Test
    public void setSubject() {
        meeting.setSubject("TestSubject");
        Assert.assertEquals("TestSubject",meeting.getSubject());
    }

    @Test
    public void getDescription() {
        Assert.assertNull(meeting.getDescription());
    }

    @Test
    public void setDescription() {
        meeting.setDescription("DescriptionTest");
        Assert.assertEquals("DescriptionTest",meeting.getDescription());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(meeting);
    }

    @Test
    public void getLawSuitByLawSuitId() {
        Assert.assertNull(meeting.getLawSuitByLawSuitId());
    }

    @Test
    public void setLawSuitByLawSuitId() {
        meeting.setLawSuitByLawSuitId(lawSuit);
        Assert.assertEquals(lawSuit,meeting.getLawSuitByLawSuitId());
    }

    @Test
    public void getClientByClientId() {
        Assert.assertNull(meeting.getClientByClientId());
    }

    @Test
    public void setClientByClientId() {
        meeting.setClientByClientId(client);
        Assert.assertEquals(client,meeting.getClientByClientId());
    }
}