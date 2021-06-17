package CellComponent;

import CharacterComponent.iCharacterProperties;

public interface iCellProperties {
    iCharacterProperties getCharacter();

    void setCharacter(iCharacterProperties character);

    boolean getCellVisited();

    void setCellVisited(boolean cellVisited);
}
