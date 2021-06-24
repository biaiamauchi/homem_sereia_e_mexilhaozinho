package GameControllerComponent;

import BuilderComponent.Builder;
import BuilderComponent.iBuilderProperties;
import GraphControllerComponent.GraphController;
import GraphControllerComponent.SuportScreen.SuportScreen;
import GraphControllerComponent.iGraphControllerProperties;
import javafx.stage.Stage;

public class GameController implements iGameControllerProperties{
    private boolean isGameFinalized;
    private iGraphControllerProperties screen;
    private iBuilderProperties game;
    private String message = "";
    private int level;

    public GameController(){
        this.game = new Builder(1, true);
        this.level = 1;
    }

    public boolean getIsGameFinalized(){
        return this.isGameFinalized;
    }

    public void setIsGameFinalizado(boolean isGameFinalized){
        this.isGameFinalized = isGameFinalized;
    }

    public void play(String CSV) {
        game.build(CSV);
    }

    public iBuilderProperties getBoard(){
        return this.game;
    }
}
