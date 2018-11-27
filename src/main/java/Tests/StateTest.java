import Models.State;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StateTest {

    private State state;

    @Before
    public void init() {
        state = new State();
    }

    @Test
    public void getId() {
        Assert.assertNull(state.getId());
    }

    @Test
    public void setId() {
        state.setId((Integer)12345);
        Assert.assertEquals((Integer)12345,state.getId());
    }

    @Test
    public void getState() {
        Assert.assertNull(state.getState());
    }

    @Test
    public void setState() {
        state.setState("TestState");
        Assert.assertEquals("TestState",state.getState());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(state);
    }
}