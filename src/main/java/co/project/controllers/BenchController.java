package co.project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

public class BenchController {
    @FXML
    private Text text;
    @FXML
    private ChoiceBox<String> runs;
    @FXML
    public void initialize() {
        runs.getItems().addAll("1", "2","4");
        runs.setValue("1");
    }
    @FXML
    public void log(ActionEvent actionEvent) {
    }
    @FXML
    public void stop(ActionEvent actionEvent) {
    }
    @FXML
    public void start(ActionEvent actionEvent) {
    }
}
