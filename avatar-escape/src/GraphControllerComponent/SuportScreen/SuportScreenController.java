package GraphControllerComponent.SuportScreen;

import GraphControllerComponent.BoardScreen.BoardScreenController;
import GraphControllerComponent.GraphController;
import GraphControllerComponent.iGraphControllerProperties;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class SuportScreenController {
    iGraphControllerProperties screen = new GraphController();

    public Scene instructionsScreen(){
        Image instructionsImage = new Image(String.valueOf(getClass().getResource("/assets/instructions/gameInstructions.png")));
        ImageView imageInstructions = new ImageView(instructionsImage);
        Group image = new Group(imageInstructions);
        imageInstructions.setFitWidth(350);
        imageInstructions.setFitHeight(450);
        imageInstructions.setX(425);
        imageInstructions.setY(70);

        javafx.scene.control.Button play = new javafx.scene.control.Button("JOGAR");
        play.setStyle("-fx-background-color: #767CB1;  -fx-border-radius: 200px; -fx-text-fill: #ffffff");
        play.setMinWidth(100);
        play.setMinHeight(40);
        play.setTranslateX(560);
        play.setTranslateY(550);
        play.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent e) {
                screen.getStage().setScene(new BoardScreenController().boardScreen());
            }
        });

        image.getChildren().addAll(play, screen.screenStyle("/assets/closeWindow/black.png", "Instruções", Color.rgb(196, 196, 196)));

        return new Scene(image, 1200, 650);
    }
}
