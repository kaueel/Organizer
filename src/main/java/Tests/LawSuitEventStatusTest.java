import Models.LawSuitEventStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LawSuitEventStatusTest {

    private LawSuitEventStatus lawSuitEventStatus;

    @Before
    public void init() {
        lawSuitEventStatus = new LawSuitEventStatus();
    }

    @Test
    public void getId() {
        Assert.assertNull(lawSuitEventStatus.getId());
    }

    @Test
    public void setId() {
        lawSuitEventStatus.setId((Integer)222);
        Assert.assertEquals((Integer) 222, lawSuitEventStatus.getId());
    }

    @Test
    public void getDescription() {
        Assert.assertNull(lawSuitEventStatus.getDescription());
    }

    @Test
    public void setDescription() {
        lawSuitEventStatus.setDescription("DescriptionTest");
        Assert.assertEquals("DescriptionTest",lawSuitEventStatus.getDescription());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(lawSuitEventStatus);
    }
}