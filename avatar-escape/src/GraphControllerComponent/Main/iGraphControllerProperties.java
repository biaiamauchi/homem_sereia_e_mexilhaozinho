package GraphControllerComponent.Main;

import GameControllerComponent.iGameControllerProperties;
import javafx.stage.Stage;

public interface iGraphControllerProperties {
    public iGameControllerProperties getGame();

    public void setGame(iGameControllerProperties game);

    public Stage getStage();

    public void setStage(Stage fixStage);
}
