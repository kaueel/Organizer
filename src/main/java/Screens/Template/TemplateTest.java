package Screens.Template;

import org.junit.Before;
import org.junit.Test;

public class TemplateTest {

    private Template template;

    @Before
    public void setUp() throws Exception {
        template = new Template();
    }

    @Test
    public void initialize() {
        try {
            template.initialize();
        } catch (NullPointerException e) { }
    }

    @Test
    public void copyVariableText() {
        try {
            template.copyVariableText(null);
        } catch (NullPointerException e) { }
    }

    @Test
    public void click_ButtonSaveTemplate() {
        try {
            template.click_ButtonSaveTemplate(null);
        } catch (NullPointerException e) { }
    }

    @Test
    public void saveTemplate() {
    }
}