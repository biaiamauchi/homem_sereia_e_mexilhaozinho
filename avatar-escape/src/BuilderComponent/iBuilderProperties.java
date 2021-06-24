package BuilderComponent;

import LevelComponent.iBoardProperties;
import LevelComponent.iFightProperties;

public interface iBuilderProperties {
    public void build(String CSVSource);

    public iBoardProperties getBoard();

    public int getBoardWidth();

    public int getBoardHeight();
}
