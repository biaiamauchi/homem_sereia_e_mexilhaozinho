package LevelComponent;

public interface iLevelProperties {
    public int getLevel();
    public void setLevel(int level);

    public boolean getCellsNeeded();
    public void setCellsNeeded(boolean cellsNeeded);

    public void changeLevel(int level, boolean cellsNeeded);
}
