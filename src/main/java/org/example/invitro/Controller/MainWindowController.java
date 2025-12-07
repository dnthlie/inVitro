package org.example.invitro.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import org.example.invitro.Models.RoomController;
import org.example.invitro.Models.Room;

import java.util.Arrays;
import java.util.HashSet;

public class MainWindowController {
    Room currentRoom = new Room(RoomController.title);

    @FXML
    private ImageView room_image;

    public static HashSet<String> single_word_command = new HashSet<>(Arrays.asList(
            "look",
            "inventory",
            "start"
    ));

    public static HashSet<String> two_word_command = new HashSet<>(Arrays.asList(
            "go",
            "grab",
            "open",
            "volume"
    ));

    //map of objects or "nouns" that can be interatcted with in game
    public static HashSet<String> nouns = new HashSet<>(Arrays.asList(
            "door",
            "crate",
            "chamber",
            "keycard"
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
                update_message(currentRoom.getDescription());
                break;
            case "inventory":
                // function for inventory
                break;
            case "go":
                handleGo(words[1]);
                break;
            case "grab":
                // function for grab
                break;
            case "start":
                if (currentRoom.getRoomName().equals("Title")) {
                    currentRoom = currentRoom.getNextRoom();
                    room_image.setImage(new Image(currentRoom.getImageURL()));
                    SoundController.getInstance().fadeTitleVolume();
                    update_message("Welcome");
                    text_input_id.setText("");
                }
                break;

            case "open":
                handleOpen(words[1]);
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


    //Handles the cases for when user types "open (noun)"
    private void handleOpen(String noun){
        if (noun == null){
            update_message("open what?");
        }
        switch (noun){
            case "door":
                if (currentRoom.getNextRoom().isLocked()){
                    update_message("The door is locked.");
                    text_input_id.setText("");
                } else {
                    currentRoom = currentRoom.getNextRoom();
                    room_image.setImage(new Image(currentRoom.getImageURL()));
                    update_message("You open the door");
                    text_input_id.setText("");
                }
                break;
            case "chamber":
                //TODO Handle chamber opening (pretty much same as door but need to check if we are in chamber room)
            case "crate":
                //TODO Handle opening a crate (should give the user a keycard only if they are in crate room
        }
    }

    private void handleGo(String noun) {
        if (noun == null){
            update_message("go where?");
        }
        switch (noun) {
            case "back":
                if(currentRoom.getPrevRoom().getRoomName().equals("Title")){
                    update_message("You cant go back now!");
                    text_input_id.setText("");
                } else if (currentRoom.getPrevRoom() != null){
                    currentRoom = currentRoom.getPrevRoom();
                    room_image.setImage(new Image(currentRoom.getImageURL()));
                    update_message("You go back into the previous room");
                    text_input_id.setText("");
                }
                break;

        }
    }

}

