package co.project.logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Table {
    public static void start(Stage stage) {

            TableView<Object> table=new TableView<>();

            TableColumn<Object, Object> ID=new TableColumn<>("ID");
            ID.setCellValueFactory(new PropertyValueFactory<>("ID"));

            TableColumn<Object, Object> threads=new TableColumn<>("Threads");
            threads.setCellValueFactory(new PropertyValueFactory<>("threads"));

            TableColumn<Object, Object> Score=new TableColumn<>("Time(ms)");
            Score.setCellValueFactory(new PropertyValueFactory<>("score"));

        TableColumn<Object, Object> info=new TableColumn<>("info");
        info.setCellValueFactory(new PropertyValueFactory<>("info"));


            table.getColumns().addAll(ID,threads,Score,info);
            //AddValue first=new AddValue("100000",12,30);
           // table.getItems().add(first);
            VBox stats=new VBox(20);
            Button back1= new Button("Back");
            back1.setTextFill(Color.BLUE);
            back1.setOnAction(e ->
            {
                Parent root = null;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(Table.class.getClassLoader().getResource("bench.fxml")));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                assert root != null;
                Scene scene1 = new Scene(root);
                stage.setScene(scene1);
                stage.show();
            });
            ArrayList log=Loggs.getValues();
        for (Object o : log) table.getItems().addAll(o);

        ArrayList avg=Loggs.getAVG();
        for (Object o : avg) table.getItems().addAll(o);

            stats.getChildren().addAll(table,back1);
            Scene scene_score=new Scene(stats,600,800);
            stats.setAlignment(Pos.CENTER);
            stage.setScene(scene_score);
    }
}
