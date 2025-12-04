package org.example.invitro.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class UIController {
    public UIController() {
    }

    @FXML
    private TextField text_input;

    @FXML
    protected void handleTextInput(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            System.out.println(text_input.getText());
        }
    }


}
