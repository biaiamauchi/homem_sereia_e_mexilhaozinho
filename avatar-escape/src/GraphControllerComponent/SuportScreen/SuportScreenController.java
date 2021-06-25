package GraphControllerComponent.SuportScreen;

import GraphControllerComponent.BoardScreen.BoardScreen;
import GraphControllerComponent.BoardScreen.BoardScreenController;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SuportScreenController {
    public Scene instructionsScreen(){
        Image instructionsImage = new Image(String.valueOf(getClass().getResource("/assets/instructions/gameInstructions.png")));
        ImageView imageInstructions = new ImageView(instructionsImage);
        Group image = new Group(imageInstructions);
        imageInstructions.setFitWidth(350);
        imageInstructions.setFitHeight(450);
        imageInstructions.setX(425);
        imageInstructions.setY(20);

        javafx.scene.control.Button play = new javafx.scene.control.Button("JOGAR");
        play.setStyle("-fx-background-color: #767CB1;  -fx-border-radius: 200px; -fx-text-fill: #ffffff");
        play.setMinWidth(100);
        play.setMinHeight(40);
        play.setTranslateX(560);
        play.setTranslateY(500);
        play.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent e) {
                SuportScreen.getStage().setScene(new BoardScreenController().boardScreen());
                /*SuportScreen.getStage().close();
                BoardScreen board = new BoardScreen();
                try {
                    board.start(new Stage());
                } catch (Exception ex){
                    //pass
                }*/
            }
        });

        image.getChildren().addAll(play);

        return new Scene(image, 1200, 600);
    }
}
