package GraphControllerComponent;

import CharacterComponent.iCharacterProperties;
import GameControllerComponent.iGameControllerProperties;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public interface iGraphControllerProperties {
    public Stage getStage();
    public void setStage(Stage fixStage);

    public iGameControllerProperties getGame();

    public void updateAvatar(int life);
    public void setAvatar(iCharacterProperties avatar);
    public Group screenStyle(String imagemString, String screenNameText, Color color);
}
