package co.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene1;
        Stage window = primaryStage;
        window.setTitle("Benchmark");
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("bench.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scene1 = new Scene(root);
        window.setScene(scene1);
        window.show();
    }
}
