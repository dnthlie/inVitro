package org.example.invitro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class GameUI extends Application {

    public static void main(String[] args) { launch(args); }

    //Nat - TESTING MainWindow.fxml >> Will change to a different screen at later time for start window
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));

        Scene scene = new Scene(loader.load(), 690, 690);

        primaryStage.setTitle("Main Window");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
