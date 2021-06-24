package GraphControllerComponent.SuportScreen;

import GraphControllerComponent.iGraphControllerProperties;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SuportScreen extends Application {
    private static Stage stage;

    public static void Main(String[] args){
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("Fase 1");
        Scene tela = new SuportScreenController().instructionsScreen();
        stage.setScene(tela);
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