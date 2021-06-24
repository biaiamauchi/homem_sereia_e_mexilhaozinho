package GraphControllerComponent;

import BuilderComponent.iBuilderProperties;

public class GraphController implements iGraphControllerProperties{
    private iBuilderProperties board;

    public void setBoard(iBuilderProperties board){
        this.board = board;
    }
}
