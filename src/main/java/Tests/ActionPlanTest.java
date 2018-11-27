import Models.ActionPlan;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionPlanTest {

    private ActionPlan actionPlan;

    @Before
    public void init() {
        actionPlan = new ActionPlan();
    }

    @Test
    public void getId() {
        Assert.assertNull(actionPlan.getId());
    }

    @Test
    public void setId() {
        actionPlan.setId((Integer)2345);
        Assert.assertEquals((Integer)2345,actionPlan.getId());
    }

    @Test
    public void getStrategy() {
        Assert.assertNull(actionPlan.getStrategy());
    }

    @Test
    public void setStrategy() {
        actionPlan.setStrategy("TestStrategy");
        Assert.assertEquals("TestStrategy",actionPlan.getStrategy());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(actionPlan);
    }
}