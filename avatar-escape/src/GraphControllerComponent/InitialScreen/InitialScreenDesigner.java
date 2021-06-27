package GraphControllerComponent.InitialScreen;

import GraphControllerComponent.BoardScreen.BoardScreenController;
import GraphControllerComponent.Main.iGraphControllerProperties;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class InitialScreenDesigner {
    private iGraphControllerProperties screen;

    public Group groupScene(iGraphControllerProperties screen){
        this.screen = screen;

        return initialScreen();
    }

    private Group initialScreen(){
        Image instructionsImage = new Image(String.valueOf(getClass().getResource( "/assets/instructions/gameInstructions.png")));
        ImageView imageInstructions = new ImageView(instructionsImage);
        Group root = new Group(imageInstructions);
        imageInstructions.setFitWidth(350);
        imageInstructions.setFitHeight(450);
        imageInstructions.setX(425);
        imageInstructions.setY(70);

        Button play = new Button("JOGAR");
        play.setStyle("-fx-background-color: #767CB1;  -fx-border-radius: 200px; -fx-text-fill: #ffffff");
        play.setMinWidth(100);
        play.setMinHeight(40);
        play.setTranslateX(560);
        play.setTranslateY(550);
        play.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent e) {
                screen.getStage().setScene(new BoardScreenController(screen.getGame()).boardScreen());
            }
        });

        return new Group(imageInstructions, play);
    }
}
