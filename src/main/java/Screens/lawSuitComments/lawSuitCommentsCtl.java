package Screens.LawSuitComments;

import Controllers.DataController;
import Controllers.Screen;
import Models.LawSuit;
import Models.LawSuitProgress;
import Utils.Validation;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.*;

import static java.sql.Timestamp.from;

public class lawSuitCommentsCtl extends Screen {
    private DataController mDataController = DataController.getInstance();
    private Boolean exists;
    private LawSuitProgress lawSuitProgress = null;

    @FXML
    DatePicker commentDatePicker;

    @FXML
    TextArea comments;

    @FXML
    Button saveComments;

    @FXML
    void initialize() {
        commentDatePicker.setValue(LocalDate.now());
        exists  = false;
        ObservableList<LawSuitProgress> lawSuits = (ObservableList<LawSuitProgress>) mDataController.getAllObjectsOfType(LawSuitProgress.class);
        if (!lawSuits.isEmpty()) {
            for (LawSuitProgress lawsuit : lawSuits
            ) {
                if (lawsuit.getLawSuitByLawSuitId().getId() == super.getCurrentLawsuit().getId()) {
                    lawSuitProgress = lawsuit;
                    exists = true;
                }
            }
        }
        if (lawSuitProgress == null){
            lawSuitProgress = new LawSuitProgress();
        } else{
            Instant date = lawSuitProgress.getDate().toInstant();
            ZonedDateTime zdt = date.atZone(ZoneId.systemDefault());
            comments.setText(lawSuitProgress.getDescription());
            commentDatePicker.setValue(zdt.toLocalDate());
        }
    }

    @FXML
    void saveComment(){
        LocalDate date = commentDatePicker.getValue();
        lawSuitProgress.setDate(from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        lawSuitProgress.setDescription(comments.getText().toString());
        lawSuitProgress.setLawSuitByLawSuitId(super.getCurrentLawsuit());
        if (exists){
            mDataController.updateObject(lawSuitProgress);
        }else
            mDataController.saveObject(lawSuitProgress);
        Validation.showErrorDialog("Comentario salvo", "Comentario Salvo!", "");

    }
}
