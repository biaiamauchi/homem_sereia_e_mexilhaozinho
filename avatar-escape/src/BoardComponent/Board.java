package BoardComponent;
import CellComponent.*;
import CharacterComponent.iCharacterProperties;

public class Board implements iBoardProperties {
    private int level;
    private iCellProperties cells[][];
    private int boardWidth;
    private int boardHeight;

    public Board(int level, int boardWidth, int boardHeight){
        this.level = level;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;

        this.cells = new Cell[this.boardWidth][this.boardHeight];
        for(int i = 0; i < this.boardHeight; i++){
            for(int j = 0; j < this.boardWidth; j++){
                cells[i][j] = new Cell(null);
            }
        }
    }

    public void setCellBoard(iCharacterProperties character, int line, int collumn){
        cells[line][collumn].setCharacter(character);
    }

    public iCharacterProperties getCellBoard(int line, int collumn){
        return cells[line][collumn].getCharacter();
    }

    public iCellProperties getCell(int line, int collumn){
        return cells[line][collumn];
    }

    public iCellProperties[][] getCells() {
        return cells;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }
}
