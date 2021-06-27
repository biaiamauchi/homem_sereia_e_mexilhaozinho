package GameControllerComponent;

import BuilderComponent.iBuilderProperties;
import CharacterComponent.iCharacterProperties;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public interface iGameControllerProperties {
    public void play(String CSV);

    public iBuilderProperties getBoard();

    public iCharacterProperties getAvatar();
}
