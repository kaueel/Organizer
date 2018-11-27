import Controllers.TemplateHashVariables;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TemplateHashVariablesTest {

    private TemplateHashVariables templateHashVariables;

    @Before
    public void init() {
        templateHashVariables = new TemplateHashVariables();
    }

    @Test
    public void unabbreviatedDateWithDayOfWeek() {
        Assert.assertNotNull(
                templateHashVariables.unabbreviatedDateWithDayOfWeek(new Date()));
    }

    @Test
    public void unabbreviatedDateWithDayOfWeek1() {
        Assert.assertNotNull(
                templateHashVariables.unabbreviatedDateWithDayOfWeek());
    }

    @Test
    public void unabbreviatedDate() {
        Assert.assertNotNull(
                templateHashVariables.unabbreviatedDate(new Date()));
    }

    @Test
    public void unabbreviatedDate1() {
        Assert.assertNotNull(
                templateHashVariables.unabbreviatedDate());
    }

    @Test
    public void getKeys() {
        Assert.assertNotNull(
                templateHashVariables.getKeys());
    }
}