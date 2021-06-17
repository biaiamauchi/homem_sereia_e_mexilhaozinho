package GameControllerComponent;

import BuilderComponent.Builder;
import BuilderComponent.iBuilderProperties;

public class GameController implements iGameControllerProperties{
    private boolean isGameFinalized;
    private iBuilderProperties game;
    private String message = "";
    private int level;

    public GameController(int level, boolean cellsNeeded){
        game = new Builder(level, cellsNeeded);
    }

    public boolean getIsGameFinalized(){
        return this.isGameFinalized;
    }

    public void setIsGameFinalizado(boolean isGameFinalized){
        this.isGameFinalized = isGameFinalized;
    }
}
