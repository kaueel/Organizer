package Screens.HelloWord;

import Controllers.DataController;
import Models.Country;
import Screens.AbstractScreen;
import javafx.fxml.FXML;

import java.util.List;

public class HelloWord extends AbstractScreen {
    int requiredAcesslevel;

    @FXML
    private void initialize() {
        requiredAcesslevel = 0;
    }


    @FXML
    public void DataHowToo() {
        Country country = new Country();
        country.setCountry("Teste2");

        //get data controller
        DataController mDataController = DataController.getInstance();
        //save a new object
        mDataController.saveObject(country);
        //get a specific object
        Country retrievedCountry = (Country) mDataController.getObjectById(Country.class, 1);
        System.out.println(retrievedCountry.getCountry());

        //get list with all entries of an object
        List<Country> countries = (List<Country>) mDataController.getAllObjectsOfType(Country.class);

        for (Country acountry : countries) {
            System.out.println(acountry.getCountry());
        }
    }


}