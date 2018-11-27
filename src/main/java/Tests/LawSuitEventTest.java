import Models.LawSuit;
import Models.LawSuitEvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.Timestamp;

import static org.junit.Assert.*;

public class LawSuitEventTest {

    private LawSuitEvent lawSuitEvent;
    private Timestamp timestamp;
    private LawSuit lawSuit;

    @Before
    public void init() {
        lawSuitEvent = new LawSuitEvent();
        Date date = new Date(23);
        timestamp = new Timestamp(date.getTime());
        lawSuit = new LawSuit();
    }

    @Test
    public void getId() {
        Assert.assertNull(lawSuitEvent.getId());
    }

    @Test
    public void setId() {
        lawSuitEvent.setId((Integer)9900);
        Assert.assertEquals((Integer)9900, lawSuitEvent.getId());
    }

    @Test
    public void getStartTime() {
        Assert.assertNull(lawSuitEvent.getStartTime());
    }

    @Test
    public void setStartTime() {
        lawSuitEvent.setStartTime(timestamp);
        Assert.assertEquals(timestamp,lawSuitEvent.getStartTime());
    }

    @Test
    public void getEndTime() {
        Assert.assertNull(lawSuitEvent.getEndTime());
    }

    @Test
    public void setEndTime() {
        lawSuitEvent.setEndTime(timestamp);
        Assert.assertEquals(timestamp,lawSuitEvent.getEndTime());
    }

    @Test
    public void getDescription() {
        Assert.assertNull(lawSuitEvent.getDescription());
    }

    @Test
    public void setDescription() {
        lawSuitEvent.setDescription("TestDescription");
        Assert.assertEquals("TestDescription",lawSuitEvent.getDescription());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(lawSuitEvent);
    }

    @Test
    public void getLawSuitByLawSuitId() {
        Assert.assertNull(lawSuitEvent.getLawSuitByLawSuitId());
    }

    @Test
    public void setLawSuitByLawSuitId() {
        lawSuitEvent.setLawSuitByLawSuitId(lawSuit);
        Assert.assertEquals(lawSuit,lawSuitEvent.getLawSuitByLawSuitId());
    }
}