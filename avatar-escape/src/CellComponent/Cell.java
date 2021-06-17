package CellComponent;
import CharacterComponent.iCharacterProperties;

public class Cell implements iCellProperties{
    private iCharacterProperties character;
    private boolean cellVisited;

    public Cell(iCharacterProperties character){
        this.character = character;
    }

    public iCharacterProperties getCharacter(){
        return character;
    }

    public void setCharacter(iCharacterProperties character){
        this.character = character;
    }

    public boolean getCellVisited(){
        return this.cellVisited;
    }

    public void setCellVisited(boolean cellVisited){
        this.cellVisited = cellVisited;
    }
}
