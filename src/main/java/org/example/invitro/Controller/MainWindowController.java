package org.example.invitro.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class MainWindowController {

    @FXML
    private TextField text_input_id;

    @FXML
    protected void handle_key_press(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            System.out.println(text_input_id.getText());
        }
    }


}