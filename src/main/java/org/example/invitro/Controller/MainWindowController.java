package org.example.invitro.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.invitro.Models.Room;

// GAME CONTROLLER - GAME MANAGEMENT
import java.util.Arrays;
import java.util.HashSet;

public class MainWindowController {
    Room currentRoom = new Room(RoomController.title);

    @FXML
    private ImageView room_image;

    // help window
    private Stage helpWindow;

    public static HashSet<String> single_word_command = new HashSet<>(Arrays.asList(
            "look",
            "inventory",
            "start",
            "quit",
            "exit",
            "help",
            "commands",
            "volume"                            //Nat - putting this in single word command/doesn't seem to be used for two words ??
    ));

    public static HashSet<String> two_word_command = new HashSet<>(Arrays.asList(
            "go",
            "grab",
            //"take",
            "open"
    ));

    //map of objects or "nouns" that can be interacted with in game
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
                }
                break;

            case "open":
                handleOpen(words[1]);
                break;

            case "ERROR":
                update_message(words[1]);
                break;

            // help+commands
            case "help":
                helpWindow();
                break;
            case "commands":
                helpWindow();
                break;
            // exits&quit
            case "exit":
                handleQuit();
                break;
            case "quit":
                handleQuit();
                break;
        }
        // clear input
        text_input_id.setText("");
    }


    @FXML
    private TextField text_input_id;

    @FXML
    private TextArea text_output_id;

    @FXML
    protected void handle_key_press(KeyEvent event) {
        //Adding keystroke sound detail when user types any alpha key
        KeyCode key = event.getCode();
        if (key.isLetterKey() || key.isDigitKey() || event.getCode()==KeyCode.BACK_SPACE) {
            try{
                SoundController.getInstance().playKeyStroke();
            } catch (Exception kbe){
                System.out.println(kbe.getMessage());
            }
        }
        // When user hits enter clear the previous message and
        // do action based on their input
        if (event.getCode() == KeyCode.ENTER) {
            try{
                SoundController.getInstance().playKeyBeep();
            } catch (Exception kbe){
                System.out.println(kbe.getMessage());
            }

            update_message("");
            command_dispatcher(text_input_id.getText());
            text_input_id.setText(""); //Clear text input when command is entered
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
                    update_message("You open the door and proceed into the next room");
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

    // open help window
    @FXML
    private void helpWindow() {
        // if window exists, just bring back to the front
        if (helpWindow != null) {
            helpWindow.toFront();
            return;
        }

        try {
            // load fxml
            FXMLLoader loadHelp = new FXMLLoader(getClass().getResource("/org/example/invitro/HelpWindow.fxml"));
            Parent helpWindowRoot = loadHelp.load();

            // connect helpController
            HelpController helpController = loadHelp.getController();

            // TEST: debugging
            //helpController.setText("TESTING TEXT");

            // create new stage (window)
            helpWindow = new Stage();
            helpWindow.setTitle(" --- Help Menu --- ");

            // close help window when main window closes
            Stage mainStage = (Stage) room_image.getScene().getWindow();
            mainStage.setOnCloseRequest(e -> {
                if(helpWindow != null) {
                    helpWindow.close();
                }
            });

            // set scene
            Scene helpScene = new Scene(helpWindowRoot, 500, 490);
            helpWindow.setScene(helpScene);

            // code to not affect main window
            helpWindow.initModality(Modality.NONE);

            // pass stage to controller
            if (helpController != null) {
                helpController.setStage(helpWindow);
            }

            // clean close
            helpWindow.setOnCloseRequest(e -> {
                helpWindow = null;
            });

            helpWindow.show();
        } catch (Exception e) {
            System.err.println("Error opening help window" + e.getMessage());
        }
    }

    // quit command to exit program
    private void handleQuit() {
        Platform.exit();
        System.exit(0);
    }

}

