package LevelComponent;

public class Level implements iLevelProperties{
    private int level;
    private boolean cellsNeeded;

    public Level(int level, boolean cellsNeeded){
        this.level = level;
        this.cellsNeeded = cellsNeeded;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean getCellsNeeded() {
        return this.cellsNeeded;
    }

    @Override
    public void setCellsNeeded(boolean cellsNeeded) {
        this.cellsNeeded = cellsNeeded;
    }

    @Override
    public void changeLevel(int level, boolean cellsNeeded) {
        setCellsNeeded(cellsNeeded);
        setLevel(level);
    }
}
