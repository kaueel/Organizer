import Models.DocumentVariableType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DocumentVariableTypeTest {

    private DocumentVariableType documentVariableType;

    @Before
    public void init() {
        documentVariableType = new DocumentVariableType();
    }

    @Test
    public void getId() {
        Assert.assertNull(documentVariableType.getId());
    }

    @Test
    public void setId() {
        documentVariableType.setId((Integer)12345);
        Assert.assertEquals((Integer)12345,documentVariableType.getId());
    }

    @Test
    public void getName() {
        Assert.assertNull(documentVariableType.getName());
    }

    @Test
    public void setName() {
        documentVariableType.setName((Integer)1111);
        Assert.assertEquals((Integer)1111, documentVariableType.getName());
    }

    @Test
    public void equals() {
        Assert.assertNotNull(documentVariableType);
    }
}