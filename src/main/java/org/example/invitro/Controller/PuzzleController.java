package org.example.invitro.Controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import org.example.invitro.Models.Room;

public class PuzzleController {
    @FXML
    private ImageView roomImage;
    @FXML
    private Text roomName;
    @FXML
    private Text roomDescription;


    //ACTIVE ROOM
    private Room currentRoom;

    public void displayRoom(Room room) {
        //UPDATE UI FOR ROOMS
    }
}
