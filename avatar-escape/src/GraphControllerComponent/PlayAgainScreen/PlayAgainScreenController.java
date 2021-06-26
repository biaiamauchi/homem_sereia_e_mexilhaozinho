package GraphControllerComponent.PlayAgainScreen;

import GameControllerComponent.GameController;
import GameControllerComponent.iGameControllerProperties;
import GraphControllerComponent.BoardScreen.BoardScreenController;
import GraphControllerComponent.GraphController;
import GraphControllerComponent.iGraphControllerProperties;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class PlayAgainScreenController {
    iGameControllerProperties game;
    iGraphControllerProperties screen = new GraphController();

    public Scene playAgainScreen(String messageSource){
        Image messageImage = new Image(String.valueOf(getClass().getResource(messageSource)));
        ImageView imageMessage = new ImageView(messageImage);
        Group image = new Group(imageMessage);
        imageMessage.setFitWidth(550);
        imageMessage.setFitHeight(450);
        imageMessage.setX(330);
        imageMessage.setY(70);

        Button playAgain = new Button("JOGAR NOVAMENTE");
        playAgain.setStyle("-fx-background-color: #767CB1;  -fx-border-radius: 200px; -fx-text-fill: #ffffff");
        playAgain.setMinWidth(100);
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

        image.getChildren().addAll(playAgain, screen.screenStyle("/assets/closeWindow/black.png", "Fim de Jogo", Color.rgb(196, 196, 196)));

        return new Scene(image, 1200, 650);
    }
}
