package GraphControllerComponent.Main;

import CharacterComponent.iCharacterProperties;
import GameControllerComponent.iGameControllerProperties;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public interface iGraphControllerProperties {
    public iGameControllerProperties getGame();

    public void setGame(iGameControllerProperties game);

    public Stage getStage();

    public void setStage(Stage fixStage);
}
