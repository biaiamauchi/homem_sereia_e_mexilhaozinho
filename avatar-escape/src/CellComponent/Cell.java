package CellComponent;
import CharacterComponent.iCharacterProperties;

public class Cell implements iCellProperties{
    private Character character;
    private boolean cellVisited;

    public Cell(Character character){
        this.character = character;
    }

    public Character getCharacter(){
        return character;
    }

    public void setCharacter(Character character){
        this.character = character;
    }

    public boolean getCellVisited(){
        return this.cellVisited;
    }

    public void setCellVisited(boolean cellVisited){
        this.cellVisited = cellVisited;
    }
}
