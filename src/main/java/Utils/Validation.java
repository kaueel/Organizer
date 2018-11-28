package Utils;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Validation {
    public static EventHandler<KeyEvent> numericValidation(final Integer maxLength) {
        return e -> {
            TextField textField = (TextField) e.getSource();
            if (maxLength != null && textField.getText().length() >= maxLength) {
                e.consume();
            }
            if (e.getCharacter().matches("[0-9.]")) {
                if (textField.getText().contains(".") && e.getCharacter().matches("[.]")) {
                    e.consume();
                } else if (textField.getText().length() == 0 && e.getCharacter().matches("[.]")) {
                    e.consume();
                }
            } else {
                e.consume();
            }
        };
    }

    public static EventHandler<KeyEvent> characterValidation(final Integer maxLength) {
        return e -> {
            TextField textField = (TextField) e.getSource();
            if (maxLength != null && textField.getText().length() >= maxLength) {
                e.consume();
            }
            if (e.getCharacter().matches("[A-Za-z]")) {
            } else {
                e.consume();
            }
        };
    }

    public static EventHandler<KeyEvent> customRegexValidation(final String regex, final Integer maxLength) {
        return e -> {
            TextField textField = (TextField) e.getSource();
            if (maxLength != null && textField.getText().length() >= maxLength) {
                e.consume();
            }
            if (regex != null && e.getCharacter().matches(regex)) {
            } else {
                e.consume();
            }
        };
    }
}
