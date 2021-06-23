package GraphController;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SuportScreen extends Application {
    private static Stage stage;

    public static void Main(String[] args){
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Fase 1");
        stage.setScene(new Scene(root, 1200, 600));
        stage.show();
        setStage(stage);
    }

    public static Stage getStage(){
        return stage;
    }

    public static void setStage(Stage stageJ){
        stage = stageJ;
    }
}
