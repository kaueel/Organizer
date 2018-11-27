import Models.DocumentTemplates;
import Models.DocumentVariable;
import Models.DocumentVariableInDocumentTemplates;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DocumentVariableInDocumentTemplatesTest {

    private DocumentVariableInDocumentTemplates documentVariableInDocumentTemplates;
    private DocumentVariable documentVariable;
    private DocumentTemplates documentTemplates;

    @Before
    public void init(){
        documentVariableInDocumentTemplates = new DocumentVariableInDocumentTemplates();
        documentVariable = new DocumentVariable();
        documentTemplates = new DocumentTemplates();
    }

    @Test
    public void getDocumentVariableByDocumentVariableId() {
        Assert.assertNull(documentVariableInDocumentTemplates.getDocumentTemplatesByDocumentTemplatesId());
    }

    @Test
    public void setDocumentVariableByDocumentVariableId() {
        documentVariableInDocumentTemplates.setDocumentVariableByDocumentVariableId(documentVariable);
        Assert.assertEquals(documentVariable,documentVariableInDocumentTemplates.getDocumentVariableByDocumentVariableId());
    }

    @Test
    public void getDocumentTemplatesByDocumentTemplatesId() {
        Assert.assertNull(documentVariableInDocumentTemplates.getDocumentTemplatesByDocumentTemplatesId());
    }

    @Test
    public void setDocumentTemplatesByDocumentTemplatesId() {
        documentVariableInDocumentTemplates.setDocumentTemplatesByDocumentTemplatesId(documentTemplates);
        Assert.assertEquals(documentTemplates, documentVariableInDocumentTemplates.getDocumentTemplatesByDocumentTemplatesId());
    }

    @Test
    public void getThis_id() {
        Assert.assertNull(documentVariableInDocumentTemplates.getThis_id());
    }

    @Test
    public void setThis_id() {
        documentVariableInDocumentTemplates.setThis_id((Integer)2345);
        Assert.assertEquals((Integer)2345,documentVariableInDocumentTemplates.getThis_id());
    }
}