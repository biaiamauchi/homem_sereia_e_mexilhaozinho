package GraphControllerComponent.BoardScreen;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BoardScreen extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Avatar Escape");
        stage.setScene(new BoardScreenController().boardScreen());
        stage.setResizable(false);
        stage.show();
        setStage(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage(){
        return stage;
    }

    public static void setStage(Stage stageJ){
        stage = stageJ;
    }
}
