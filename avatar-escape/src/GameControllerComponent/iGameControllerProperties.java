package GameControllerComponent;

import BuilderComponent.iBuilderProperties;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public interface iGameControllerProperties {
    public boolean getIsGameFinalized();

    public void setIsGameFinalizado(boolean isGameFinalized);

    public void play(String CSV);

    public iBuilderProperties getBoard();
}
