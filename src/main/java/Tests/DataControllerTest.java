package Tests;

import Controllers.DataController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataControllerTest {

    private DataController dataController;

    @Test
    public void getInstance() {
        dataController = DataController.getInstance();
    }

    @Test
    public void getSessionFactory() {
        try {
            dataController.getSessionFactory();
        } catch (NullPointerException e) { }
    }

    @Test
    public void saveObject() {
        try {
            dataController.saveObject(null);
        } catch (NullPointerException e) { }
    }

    @Test
    public void deleteObject() {
        try {
            dataController.deleteObject(null);
        } catch (NullPointerException e) { }
    }

    @Test
    public void updateObject() {
        try {
            dataController.updateObject(null);
        } catch (NullPointerException e) { }
    }

    @Test
    public void getObjectById() {
        try {
            dataController.getObjectById(null, null);
        } catch (NullPointerException e) { }
    }

    @Test
    public void getAllObjectsOfType() {
        try {
            dataController.getAllObjectsOfType(null);
        } catch (NullPointerException e) { }
    }
}