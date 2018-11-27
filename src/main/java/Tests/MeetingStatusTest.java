import Models.MeetingStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MeetingStatusTest {

    private MeetingStatus meetingStatus;

    @Before
    public void init() {
        meetingStatus = new MeetingStatus();
    }

    @Test
    public void getId() {
        Assert.assertNull(meetingStatus.getId());
    }

    @Test
    public void setId() {
        meetingStatus.setId((Integer)12345);
        Assert.assertEquals((Integer)12345,meetingStatus.getId());
    }

    @Test
    public void getDescription() {
        Assert.assertNull(meetingStatus.getDescription());
    }

    @Test
    public void setDescription() {
        meetingStatus.setDescription("TestDescription");
        Assert.assertEquals("TestDescription",meetingStatus.getDescription());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(meetingStatus);
    }
}