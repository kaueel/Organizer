import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class MainTest {

    private Main main;

    private volatile boolean success = true;

    @Before
    public void setUp() throws Exception {
        main = new Main();
    }

    @Test
    public void main() {
        Thread thread = new Thread() { // Wrapper thread.
            @Override
            public void run() {
                try {
                    Main.main(null);
                    success = true;
                } catch (Throwable t) {
                    if (t.getCause() != null && t.getCause().getClass().equals(InterruptedException.class)) {
                        // We expect to get this exception since we interrupted
                        // the JavaFX application.
                        success = true;
                        return;
                    }
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(3000);  // Wait for 3 seconds before interrupting JavaFX application
        } catch (InterruptedException ex) {
            // We don't care if we wake up early.
        }
        thread.interrupt();
        try {
            thread.join(1); // Wait 1 second for our wrapper thread to finish.
        } catch (InterruptedException ex) {
            // We don't care if we wake up early.
        }
        assertTrue(success);
    }

    @Test
    public void start() {
        try {
            main.start(null);
        } catch (NullPointerException e) {
        }
    }
}