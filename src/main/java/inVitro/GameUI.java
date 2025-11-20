package inVitro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class GameUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("JavaFX is working!");
        StackPane root = new StackPane(label);

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("JavaFX Test Window");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
