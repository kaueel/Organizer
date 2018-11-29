import Models.DocumentTemplates;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DocumentTemplatesTest {

    private DocumentTemplates documentTemplates;

    @Before
    public void init() {
        documentTemplates = new DocumentTemplates();
    }

    @Test
    public void getId() {

        Assert.assertNull(documentTemplates.getId());
    }

    @Test
    public void setId() {
        documentTemplates.setId(3);
        Assert.assertEquals(3,documentTemplates.getId());
    }

    @Test
    public void getName() {
        Assert.assertNull(documentTemplates.getName());
    }

    @Test
    public void setName() {
        documentTemplates.setName("TestName");
        Assert.assertEquals("TestName",documentTemplates.getName());
    }

    @Test
    public void getDocumentText() {
        Assert.assertNull(documentTemplates.getDocumentText());
    }

    @Test
    public void setDocumentText() {
        documentTemplates.setDocumentText("TestDocumentText");
        Assert.assertEquals("TestDocumentText",documentTemplates.getDocumentText());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(documentTemplates);
    }
}