package GameControllerComponent;

import BuilderComponent.iBuilderProperties;

public interface iGameControllerProperties {
    public boolean getIsGameFinalized();

    public void setIsGameFinalizado(boolean isGameFinalized);

    public void play(String CSV);

    public iBuilderProperties getBoard();
}
