package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public Parent createContent(){
        return new StackPane(new Text("Hello Word"));
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Hello World");
        stage.setScene(new Scene(createContent(), 300, 275));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
