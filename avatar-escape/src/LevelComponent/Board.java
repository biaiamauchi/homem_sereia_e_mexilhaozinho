package LevelComponent;

public class Board extends Level{
    private Cell cells[][];
    private int boardWidth;
    private int boardHeight

    public Board(int level, int boardWidth, int boardHeight){
        super(level, true);
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;

        this.cells = new Cell[this.boardWidth][this.boardHeight];
        for(int i = 0; i < this.boardWidth; i++){
            for(int j = 0; j < this.boardHeight; j++){
                cells[i][j] = new Cell(null);
            }
        }
    }

    public void setCellBoard(Character character, int line, int collumn){
        cells[line][collumn].setCharacter(character);
    }

    public Character getCellBoard(int line, int collumn){
        return cells[line][collumn].getCharacter();
    }

    public Cell getCell(int line, int collumn){
        return cells[line][collumn];
    }

    public Cell[][] getBoard() {
        return cells;
    }
}
