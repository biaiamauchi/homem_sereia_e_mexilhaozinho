package GameControllerComponent;

import BuilderComponent.Builder;
import BuilderComponent.iBuilderProperties;
import CharacterComponent.Heroes;
import CharacterComponent.iCharacterProperties;
import GraphControllerComponent.iGraphControllerProperties;

public class GameController implements iGameControllerProperties{
    private boolean isGameFinalized;
    private iBuilderProperties game;
    private String message = "";
    private int level;
    private iCharacterProperties avatar = new Heroes("", 0, 0, 25, 100);

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

    public void setGame(iGameControllerProperties game){
        this.game = game.getBoard();
    }

    public void setAvatar(iCharacterProperties avatar){
        this.avatar = avatar;
    }

    public iCharacterProperties getAvatar(){
        return this.avatar;
    }
}
