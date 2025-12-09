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

        sbHelp.append("-- Use one or two word commands to solve --\n" +
                "               the puzzle \n\n");

        sbHelp.append("+ Word Hint Commands ------\n\n");

        // UPDATE as code progresses
        sbHelp.append("look        --     Observe surrounding area\n");
        sbHelp.append("open door   --     Open door to next area\n");
        sbHelp.append("go back     --     Go back to previous area\n");
        sbHelp.append("inventory   --     Look at inventory\n");


        sbHelp.append("\n\n+ System Commands ------------\n\n");
        sbHelp.append("volume      --     Change volume\n");
        //sbHelp.append("save        --     Save Game\n");
        sbHelp.append("exit/quit   --     Close the game\n");


        String text = sbHelp.toString();

        help_text_id.setText(text);
        help_text_id.setEditable(false);
    }
}
