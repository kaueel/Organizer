import Models.LawSuit;
import Models.SubLawSuit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubLawSuitTest {

    private SubLawSuit subLawSuit;
    private LawSuit lawSuit;

    @Before
    public void init() {
        subLawSuit = new SubLawSuit();
        lawSuit = new LawSuit();
    }

    @Test
    public void getNumber() {
        Assert.assertNull(subLawSuit.getNumber());
    }

    @Test
    public void setNumber() {
        subLawSuit.setNumber((Integer)12345);
        Assert.assertEquals((Integer)12345,subLawSuit.getNumber());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(subLawSuit);
    }

    @Test
    public void getLawSuitByLawSuitId() {
        Assert.assertNull(subLawSuit.getLawSuitByLawSuitId());
    }

    @Test
    public void setLawSuitByLawSuitId() {
        subLawSuit.setLawSuitByLawSuitId(lawSuit);
        Assert.assertEquals(lawSuit,subLawSuit.getLawSuitByLawSuitId());
    }
}