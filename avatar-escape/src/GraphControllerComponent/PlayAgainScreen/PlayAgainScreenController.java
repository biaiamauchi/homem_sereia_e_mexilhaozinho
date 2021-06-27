package GraphControllerComponent.PlayAgainScreen;

import GameControllerComponent.iGameControllerProperties;
import GraphControllerComponent.Main.GraphController;
import GraphControllerComponent.Main.iGraphControllerProperties;
import javafx.scene.Group;
import javafx.scene.Scene;

public class PlayAgainScreenController {
    iGameControllerProperties game;
    iGraphControllerProperties screen = new GraphController();

    public Scene playAgainScreen(String messageSource){
        PlayAgainScreenDesigner playAgainScreen = new PlayAgainScreenDesigner();
        Group root = playAgainScreen.groupScene(screen, messageSource);

        return new Scene(root, 1200, 650);
    }
}
