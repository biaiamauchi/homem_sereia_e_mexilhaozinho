package GraphControllerComponent.PlayAgainScreen;

import GameControllerComponent.GameController;
import GameControllerComponent.iGameControllerProperties;
import GraphControllerComponent.BoardScreen.BoardScreenController;
import GraphControllerComponent.Main.iGraphControllerProperties;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class PlayAgainScreenDesigner {
    private iGraphControllerProperties screen;

    public Group groupScene(iGraphControllerProperties screen, String messageSource){
        this.screen = screen;

        return new Group(playAgainScreen(messageSource));
    }

    public Group playAgainScreen(String messageSource){
        Image messageImage = new Image(String.valueOf(getClass().getResource(messageSource)));
        ImageView imageMessage = new ImageView(messageImage);
        Group image = new Group(imageMessage);
        imageMessage.setFitWidth(550);
        imageMessage.setFitHeight(450);
        imageMessage.setX(330);
        imageMessage.setY(70);

        Button playAgain = new Button("JOGAR NOVAMENTE");
        playAgain.setStyle("-fx-background-color: #767CB1;  -fx-border-radius: 200px; -fx-text-fill: #ffffff");
        playAgain.setMinWidth(120);
        playAgain.setMinHeight(40);
        playAgain.setTranslateX(530);
        playAgain.setTranslateY(550);
        playAgain.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent e) {
                iGameControllerProperties newGame = new GameController();
                screen.getStage().setScene(new BoardScreenController(newGame).boardScreen());
            }
        });

        return new Group(imageMessage, playAgain);
    }

}
