package BuilderComponent;

import CharacterComponent.Aang;
import CharacterComponent.Heroes;
import CharacterComponent.Villans;
import CharacterComponent.iCharacterProperties;
import LevelComponent.Board;
import LevelComponent.Fight;
import LevelComponent.iBoardProperties;
import LevelComponent.iFightProperties;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Builder implements iBuilderProperties{
    //instancia os componentes contidos no arquivo de leitura
    private iBoardProperties board;
    private iFightProperties fight;
    private int boardWidth = 6;
    private int boardHeight = 6;
    private boolean cellsNeeded;

    public Builder(int level, boolean cellsNeeded){
        if(cellsNeeded)
            this.board = new Board(level, boardWidth, boardHeight);
        else
            this.fight = new Fight(level);
        this.cellsNeeded = cellsNeeded;
    }

    public void build(String CSVSource){
        buildLevel(CSVSource);
    }

    public int getBoardWidth(){
        return this.boardWidth;
    }

    public int getBoardHeight(){
        return this.boardHeight;
    }

    public iBoardProperties getBoard(){
        return this.board;
    }

    private void buildLevel(String CSVsource){ //constrói o tabuleiro
        if(this.cellsNeeded == false){
            //luta
        }
        else {
            CSVUser positions = new CSVUser();
            positions.setDataSource(CSVsource);
            String commands[][] = positions.requestCommands(); //retorno = [[1:1, P], [1:2, _], ...,[4:4, _]];

            for (int i = 0; i < boardHeight*boardWidth; i++) {
                    if (commands[i][1].equals("A")) {
                        iCharacterProperties aang = new Aang("/assets/characters/heroes/Aang.png", i/6, i%6, 100, 50);
                        board.setCellBoard(aang, i/6, i%6);
                    } else if (commands[i][1].equals("K")) {
                        iCharacterProperties kataraSokka = new Heroes("/assets/characters/heroes/SokkaKatara.png", i/6, i%6, 100, 50);
                        board.setCellBoard(kataraSokka, i/6, i%6);
                    } else if (commands[i][1].equals("T")) {
                        iCharacterProperties toph = new Heroes("/assets/characters/heroes/Toph.png", i/6, i%6, 100, 50);
                        board.setCellBoard(toph, i/6, i%6);
                    } else if (commands[i][1].equals("Z")) {
                        iCharacterProperties zuko = new Heroes("/assets/characters/heroes/Zuko.png", i/6, i%6, 100, 50);
                        board.setCellBoard(zuko, i/6, i%6);
                    } else if (commands[i][1].equals("F")) {
                        iCharacterProperties sentinela = new Villans("/assets/characters/villains/sentinela.png", i/6, i%6, 100, 50);
                        board.setCellBoard(sentinela, i/6, i%6);
                    } else if (commands[i][1].equals("AP")) {
                        iCharacterProperties appa = new Heroes("/assets/characters/heroes/Appa.png", i/6, i%6, 100, 50);
                        board.setCellBoard(appa, i/6, i%6);
                    } else if (commands[i][1].equals("-")) {
                        board.setCellBoard(null, i/6, i%6);
                    } else if (commands[i][1].equals("P")) {
                        iCharacterProperties door = new Heroes("/assets/characters/heroes/Door.png", i/6, i%6, 100, 50);
                        board.setCellBoard(door, i/6, i%6);
                    }
            }
        }
    }
}
