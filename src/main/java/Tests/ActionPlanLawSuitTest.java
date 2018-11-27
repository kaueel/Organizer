import Models.ActionPlan;
import Models.ActionPlanLawSuit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionPlanLawSuitTest {

    private ActionPlanLawSuit actionPlanLawSuit;
    private ActionPlan actionPlan;

    @Before
    public void init() {
        actionPlanLawSuit = new ActionPlanLawSuit();
        actionPlan = new ActionPlan();
    }

    @Test
    public void getActionPlanByActionPlanId() {
        Assert.assertNull(actionPlanLawSuit.getActionPlanByActionPlanId());
    }

    @Test
    public void setActionPlanByActionPlanId() {
        actionPlanLawSuit.setActionPlanByActionPlanId(actionPlan);
        Assert.assertEquals(actionPlan,actionPlanLawSuit.getActionPlanByActionPlanId());
    }

    @Test
    public void getThis_id() {
        Assert.assertNull(actionPlanLawSuit.getThis_id());
    }

    @Test
    public void setThis_id() {
        actionPlanLawSuit.setThis_id((Integer)1234);
        Assert.assertEquals((Integer)1234,actionPlanLawSuit.getThis_id());
    }
}