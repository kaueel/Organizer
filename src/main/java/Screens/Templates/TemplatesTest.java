package Screens.Templates;

import org.junit.Before;
import org.junit.Test;

public class TemplatesTest {

    private Templates templates;

    @Before
    public void init() {
        templates = new Templates();
    }

    @Test
    public void initialize() {
        try {
            templates.initialize();
        } catch (NullPointerException e) { }
    }

    @Test
    public void setCurrentDocumentTemplates() {
        try {
            templates.setCurrentDocumentTemplates(null);
        } catch (NullPointerException e) { }
    }
}