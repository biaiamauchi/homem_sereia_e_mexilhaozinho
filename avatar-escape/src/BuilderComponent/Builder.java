package BuilderComponent;

import CharacterComponent.Aang;
import CharacterComponent.Heroes;
import CharacterComponent.Villains;
import CharacterComponent.iCharacterProperties;
import BoardComponent.Board;
import BoardComponent.iBoardProperties;

public class Builder implements iBuilderProperties{
    private iBoardProperties board;
    private int boardWidth = 6;
    private int boardHeight = 6;

    public Builder(int level){
        this.board = new Board(level, boardWidth, boardHeight);
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
        CSVUser positions = new CSVUser();
        positions.setDataSource(CSVsource);
        String commands[][] = positions.requestCommands(); //retorno = [[1:1, P], [1:2, _], ...,[4:4, _]];
        for (int i = 0; i < boardHeight*boardWidth; i++) {
            if (commands[i][1].equals("A")) {
                iCharacterProperties aang = new Aang("Aang", "/assets/characters/heroes/Aang.png", i / 6, i % 6, 100, 25);
                board.setCellBoard(aang, i / 6, i % 6);
            } else if (commands[i][1].equals("K")) {
                iCharacterProperties kataraSokka = new Heroes("Katara", "/assets/characters/heroes/SokkaKatara.png", i / 6, i % 6, 0, 20);
                board.setCellBoard(kataraSokka, i / 6, i % 6);
            } else if (commands[i][1].equals("T")) {
                iCharacterProperties toph = new Heroes("Toph", "/assets/characters/heroes/Toph.png", i / 6, i % 6, 10, 10);
                board.setCellBoard(toph, i / 6, i % 6);
            } else if (commands[i][1].equals("Z")) {
                iCharacterProperties zuko = new Heroes("Zuko", "/assets/characters/heroes/Zuko.png", i / 6, i % 6, 10, 15);
                board.setCellBoard(zuko, i / 6, i % 6);
            } else if (commands[i][1].equals("F")) {
                iCharacterProperties sentinela = new Villains("FireVillain", "/assets/characters/villains/sentinela.png", i / 6, i % 6, 0, -5);
                board.setCellBoard(sentinela, i / 6, i % 6);
            } else if (commands[i][1].equals("AP")) {
                iCharacterProperties appa = new Heroes("Appa", "/assets/characters/heroes/Appa.png", i / 6, i % 6, 0, 0);
                board.setCellBoard(appa, i / 6, i % 6);
            } else if (commands[i][1].equals("-")) {
                board.setCellBoard(null, i / 6, i % 6);
            } else if (commands[i][1].equals("P")) {
                iCharacterProperties door = new Heroes("Door", "/assets/characters/heroes/Door.png", i / 6, i % 6, 0, 0);
                board.setCellBoard(door, i / 6, i % 6);
            }
        }
    }
}
