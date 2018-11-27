import Models.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CityTest {

    private City city;

    @Before
    public void init() {
        city = new City();
    }

    @Test
    public void getId() {
        Assert.assertNull(city.getId());
    }

    @Test
    public void setId() {
        city.setId(2);
        Assert.assertEquals((Integer)2,city.getId());
    }

    @Test
    public void getCity() {
        Assert.assertNull(city.getCity());
    }

    @Test
    public void setCity() {
        city.setCity("testCity");
        Assert.assertEquals("testCity",city.getCity());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(city);
    }
}