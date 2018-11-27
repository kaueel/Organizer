import Models.LawSuit;
import Models.LawSuitProgress;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.Timestamp;

public class LawSuitProgressTest {

    private LawSuitProgress lawSuitProgress;
    private Timestamp timestamp;
    private LawSuit lawSuit;

    @Before
    public void init() {
        lawSuitProgress = new LawSuitProgress();
        Date date = new Date(23);
        timestamp = new Timestamp(date.getTime());
        lawSuit = new LawSuit();
    }

    @Test
    public void getId() {
        Assert.assertNull(lawSuitProgress.getId());
    }

    @Test
    public void setId() {
        lawSuitProgress.setId((Integer)12345);
        Assert.assertEquals((Integer)12345,lawSuitProgress.getId());
    }

    @Test
    public void getDescription() {
        Assert.assertNull(lawSuitProgress.getDescription());
    }

    @Test
    public void setDescription() {
        lawSuitProgress.setDescription("DescriptionTest");
        Assert.assertEquals("DescriptionTest",lawSuitProgress.getDescription());
    }

    @Test
    public void getDate() {
        Assert.assertNull(lawSuitProgress.getDate());
    }

    @Test
    public void setDate() {
        lawSuitProgress.setDate(timestamp);
        Assert.assertEquals(timestamp,lawSuitProgress.getDate());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(lawSuitProgress);
    }

    @Test
    public void getLawSuitByLawSuitId() {
        Assert.assertNull(lawSuitProgress.getLawSuitByLawSuitId());
    }

    @Test
    public void setLawSuitByLawSuitId() {
        lawSuitProgress.setLawSuitByLawSuitId(lawSuit);
        Assert.assertEquals(lawSuit,lawSuitProgress.getLawSuitByLawSuitId());
    }
}