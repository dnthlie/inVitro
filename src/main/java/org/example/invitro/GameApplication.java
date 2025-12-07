package org.example.invitro;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.example.invitro.Controller.SoundController;
import org.example.invitro.Controller.RoomController;

import java.io.IOException;

//THIS IS WHERE GAME RUNS
public class GameApplication extends Application {
    @FXML
    private TextField text_output_id;
    public static void main(String[] args) { launch(args); }

    //START VIEW
    @Override
    public void start(Stage primaryStage) throws IOException {
        //Custom DOS Font
        Font dosFont = Font.loadFont(getClass().getResourceAsStream("/org/example/invitro/Assets/Perfect DOS VGA 437 Win.ttf"), 30);
        System.out.println("Loaded font: " + dosFont);
        RoomController.initializeRooms();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));

        Scene scene = new Scene(loader.load(), 960, 960);

        primaryStage.setTitle("Main Window");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Start title song on start up
        try {
            SoundController.getInstance().startTitleSong();
        } catch (Exception tse) {
            tse.printStackTrace();
            System.out.println("Sound Error");
        }


    }

}
