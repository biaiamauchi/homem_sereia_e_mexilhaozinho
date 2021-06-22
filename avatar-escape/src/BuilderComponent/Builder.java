package BuilderComponent;

import CharacterComponent.Aang;
import CharacterComponent.Heroes;
import CharacterComponent.Villans;
import CharacterComponent.iCharacterProperties;
import LevelComponent.Board;
import LevelComponent.Fight;
import LevelComponent.iBoardProperties;
import LevelComponent.iFightProperties;

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

    private void buildLevel(String CSVsource){ //constrói o tabuleiro
        if(this.cellsNeeded == false){
            //luta
        }
        else {
            CSVUser positions = new CSVUser();
            positions.setDataSource(CSVsource);
            String commands[][] = positions.requestCommands(); //retorno = [[1:1, P], [1:2, _], ...,[4:4, _]];

            for (int i = 0; i < boardWidth; i++) {
                if(commands[i][1].equals("A")) {
                    iCharacterProperties aang = new Aang("A", i, i % 6, 100, 50);
                    board.setCellBoard(aang, i, i % 6);
                }
                else if (commands[i][1].equals("K")) {
                    iCharacterProperties kataraSokka = new Heroes("K", i, i % 6, 100, 50);
                    board.setCellBoard(kataraSokka, i, i % 6);
                }
                else if (commands[i][1].equals("T")) {
                    iCharacterProperties toph = new Heroes("T", i, i % 6, 100, 50);
                    board.setCellBoard(toph, i, i % 6);
                }
                else if (commands[i][1].equals("Z")) {
                    iCharacterProperties zuko = new Heroes("Z", i, i % 6, 100, 50);
                    board.setCellBoard(zuko, i, i % 6);
                }
                else if (commands[i][1].equals("S")) {
                    iCharacterProperties sentinela = new Villans("S", i, i % 6, 100, 50);
                    board.setCellBoard(sentinela, i, i % 6);
                }
                else if (commands[i][1].equals("AP")) {
                    iCharacterProperties appa = new Heroes("AP", i, i % 6, 100, 50);
                    board.setCellBoard(appa, i, i % 6);
                }
                else if (commands[i][1].equals("_")) {
                    iCharacterProperties vazio = null;
                    board.setCellBoard(vazio, i, i % 6);
                }
            }

        }
    }
}
