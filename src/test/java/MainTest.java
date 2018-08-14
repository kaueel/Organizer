import org.junit.Assert;
import org.junit.Test;
import sample.Main;

public class MainTest {

    @Test
    public void testMainStart() {
        try {
            Main main = new Main();
        } catch (Exception e) {
            Assert.fail("Main have thrown an exception");
        }
    }
}
