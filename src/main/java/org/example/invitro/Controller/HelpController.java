package org.example.invitro.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class HelpController {
    @FXML
    private TextArea help_text_id;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        // TEST: debug
        System.out.println("HelpController initialized");
        handleHelp();
    }

    // help command for list
    private void handleHelp() {
        StringBuilder sbHelp = new StringBuilder();

        sbHelp.append("   --- Available commands: ---\n\n");

        // UPDATE as code progresses
        sbHelp.append("volume    --  Change volume\n");
        sbHelp.append("look      --  Observe surrounding area\n");
        sbHelp.append("inventory --  Look at inventory\n");
        sbHelp.append("open door --  Open door to next area\n");
        sbHelp.append("exit/quit --  Close the game\n");

        String text = sbHelp.toString();

        help_text_id.setText(text);
        help_text_id.setEditable(false);
    }
}
