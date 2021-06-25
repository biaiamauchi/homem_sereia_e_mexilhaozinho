package GraphControllerComponent;

import BuilderComponent.iBuilderProperties;
import GraphControllerComponent.SuportScreen.SuportScreenController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GraphController extends Application implements iGraphControllerProperties{
    private iBuilderProperties board;

    public void setBoard(iBuilderProperties board){
        this.board = board;
    }

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
