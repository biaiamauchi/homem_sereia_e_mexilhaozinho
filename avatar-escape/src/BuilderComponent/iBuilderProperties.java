package BuilderComponent;

import BoardComponent.iBoardProperties;

public interface iBuilderProperties {
    public void build(String CSVSource);

    public iBoardProperties getBoard();

    public int getBoardWidth();

    public int getBoardHeight();
}
