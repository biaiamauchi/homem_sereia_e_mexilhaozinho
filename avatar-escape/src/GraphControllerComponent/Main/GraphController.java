package GraphControllerComponent.Main;

import GameControllerComponent.GameController;
import GameControllerComponent.iGameControllerProperties;
import GraphControllerComponent.InitialScreen.InitialScreenController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GraphController extends Application implements iGraphControllerProperties {
    private iGameControllerProperties game = new GameController();
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene initialScreen = new InitialScreenController(game).initialScene();
        stage.setScene(initialScreen);
        stage.setTitle("Avatar Escape");
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/assets/icon/icon.png"))));
        stage.show();
        setStage(stage);
    }

    public void setStage(Stage fixStage){
        stage = fixStage;
    }

    public iGameControllerProperties getGame(){
        return this.game;
    }

    public void setGame(iGameControllerProperties game){
        this.game = game;
    }

    public Stage getStage(){
        return stage;
    }
}
