package org.example.invitro.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import org.example.invitro.Models.GameEngine;
import java.util.Arrays;
import java.util.HashSet;

public class MainWindowController {
    public static HashSet<String> single_word_command = new HashSet<>(Arrays.asList(
            "look",
            "inventory"
    ));

    public static HashSet<String> two_word_command = new HashSet<>(Arrays.asList(
            "go",
            "grab"
    ));

    public String[] validate_input(String text_input) {
        String[] words = text_input.split(" ");
        String first_word = words[0];
        String[] validated_command = new String[2];

        if (words.length == 1) {
            if (!single_word_command.contains(first_word)) {
                throw new IllegalArgumentException("Not a recognized command");
            }

            validated_command[0] = first_word;
            validated_command[1] = null;
        }
        else if (words.length == 2) {
            if (!two_word_command.contains(first_word)) {
                throw new IllegalArgumentException("Not a recognized command");
            }

            validated_command[0] = first_word;
            validated_command[1] = words[1];
        }
        else {
            throw new IllegalArgumentException("A command must contain either one or two words");
        }
        // Get first command word

        return validated_command;
    }

    public void command_dispatcher(String text_input) {
        // Input Validation

        String[] words = new String[2];
        try {
            words = validate_input(text_input);
        }
        catch (IllegalArgumentException e) {
            words[0] = "ERROR";
            words[1] = e.getMessage();
        }

        // At this point the words array has either a single or double word command

        switch (words[0]) {
            case "look":
                // function for look
                update_message(GameEngine.currentRoom.getDescription());
                break;
            case "inventory":
                // function for inventory
                break;
            case "go":
                // function for go
                break;
            case "grab":
                // function for grab
                break;
            case "ERROR":
                update_message(words[1]);
                break;

        }
    }


    @FXML
    private TextField text_input_id;

    @FXML
    private TextField text_output_id;

    @FXML
    protected void handle_key_press(KeyEvent event) {
        // When user hits enter clear the previous message and
        // do action based on their input
        if (event.getCode() == KeyCode.ENTER) {
            update_message("");
            command_dispatcher(text_input_id.getText());
        }
    }

    public void update_message(String text) {
        text_output_id.setText(text);
    }
}