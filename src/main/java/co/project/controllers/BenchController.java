package co.project.controllers;

import co.project.bench.Benchmark;
import co.project.logger.Table;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

public class BenchController {
    private static int id=0;

    public static int getId() {
        return id;
    }

    @FXML
    private CheckBox multi;
    @FXML
    private CheckBox single;
    Benchmark x;
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
        Table.start((Stage)((Node)actionEvent.getSource()).getScene().getWindow());
    }
    @FXML
    public void stop(ActionEvent actionEvent) {
        if(!Objects.isNull(x))
            x.cancel();
    }
    @FXML
    public void start(ActionEvent actionEvent) {
        text.setText("running...");
        x = new Benchmark();
        if(single.isSelected())
        {
                x.initialize(1,Integer.parseInt(runs.getValue()),10);
                x.run();
                id=id+1;
        }
        if(multi.isSelected())
        {
            x.initialize(Runtime.getRuntime().availableProcessors(),Integer.parseInt(runs.getValue()),10);
            x.run();
            id=id+1;
        }

        text.setText("Done, check logs");
    }
}
