import Models.DocumentVariable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DocumentVariableTest {

    private DocumentVariable documentVariable;

    @Before
    public void init() {
        documentVariable = new DocumentVariable();
    }

    @Test
    public void getId() {
        Assert.assertNull(documentVariable.getId());
    }

    @Test
    public void setId() {
        documentVariable.setId((Integer)12345);
        Assert.assertEquals((Integer)12345,documentVariable.getId());
    }

    @Test
    public void getName() {
        Assert.assertNull(documentVariable.getName());
    }

    @Test
    public void setName() {
        documentVariable.setName("TestName");
        Assert.assertEquals("TestName",documentVariable.getName());
    }

    @Test
    public void getObjectPath() {
        Assert.assertNull(documentVariable.getObjectPath());
    }

    @Test
    public void setObjectPath() {
        documentVariable.setObjectPath("ObjectPatchTest");
        Assert.assertEquals("ObjectPatchTest",documentVariable.getObjectPath());
    }

    @Test
    public void getMaxLength() {
        Assert.assertNull(documentVariable.getMaxLength());
    }

    @Test
    public void setMaxLength() {
        documentVariable.setMaxLength((Integer)1500);
        Assert.assertEquals((Integer)1500,documentVariable.getMaxLength());
    }

    @Test
    public void getValuesOptions() {
        Assert.assertNull(documentVariable.getValuesOptions());
    }

    @Test
    public void setValuesOptions() {
        documentVariable.setValuesOptions("ValuesTest");
        Assert.assertEquals("ValuesTest",documentVariable.getValuesOptions());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(documentVariable);
    }
}