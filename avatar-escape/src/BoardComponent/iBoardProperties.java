package BoardComponent;

import CellComponent.iCellProperties;
import CharacterComponent.iCharacterProperties;

public interface iBoardProperties {
    public int getLevel();
    public void setLevel(int level);

    public void setCellBoard(iCharacterProperties character, int line, int collumn);

    public iCharacterProperties getCellBoard(int line, int collumn);

    public iCellProperties getCell(int line, int collumn);

    public iCellProperties[][] getCells();
}
