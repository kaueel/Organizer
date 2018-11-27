import Models.LawSuitEventType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LawSuitEventTypeTest {

    private LawSuitEventType lawSuitEventType;

    @Before
    public void init() {
        lawSuitEventType = new LawSuitEventType();
    }

    @Test
    public void getId() {
        Assert.assertNull(lawSuitEventType.getId());
    }

    @Test
    public void setId() {
        lawSuitEventType.setId((Integer)12345);
        Assert.assertEquals((Integer)12345,lawSuitEventType.getId());
    }

    @Test
    public void getDescription() {
        Assert.assertNull(lawSuitEventType.getDescription());
    }

    @Test
    public void setDescription() {
        lawSuitEventType.setDescription("DescriptionTest");
        Assert.assertEquals("DescriptionTest",lawSuitEventType.getDescription());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(lawSuitEventType);
    }
}