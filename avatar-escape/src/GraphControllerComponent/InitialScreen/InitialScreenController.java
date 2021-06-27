package GraphControllerComponent.InitialScreen;

import GameControllerComponent.iGameControllerProperties;
import GraphControllerComponent.Main.GraphController;
import GraphControllerComponent.Main.iGraphControllerProperties;
import javafx.scene.Group;
import javafx.scene.Scene;

public class InitialScreenController {
    private iGameControllerProperties game;
    private iGraphControllerProperties screen = new GraphController();

    public InitialScreenController(iGameControllerProperties game){
        this.game = game;
        this.screen.setGame(game);
    }

    public Scene initialScene(){
        InitialScreenDesigner initialScreen = new InitialScreenDesigner();
        Group root = initialScreen.groupScene(screen);

        return new Scene(root, 1200, 650);
    }
}