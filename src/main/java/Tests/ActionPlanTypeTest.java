import Models.ActionPlanType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionPlanTypeTest {

    private ActionPlanType actionPlanType;

    @Before
    public void init() {
        actionPlanType = new ActionPlanType();
    }

    @Test
    public void getId() {
        Assert.assertNull(actionPlanType.getId());
    }

    @Test
    public void setId() {
        actionPlanType.setId((Integer)234);
        Assert.assertEquals((Integer)234, actionPlanType.getId());
    }

    @Test
    public void getName() {
        Assert.assertNull(actionPlanType.getName());
    }

    @Test
    public void setName() {
        actionPlanType.setName("TestName");
        Assert.assertEquals("TestName",actionPlanType.getName());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(actionPlanType);
    }
}