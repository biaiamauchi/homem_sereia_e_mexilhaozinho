package GraphController;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class SuportScreenController implements Initializable {
    @FXML private Button btnJogar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //btnJogar.setTranslateX(50);

        btnJogar.setOnMouseClicked((MouseEvent ex) -> {
                System.out.println("Entrei");
        });
    }


    public Scene instructionsScreen(){
        Image instructionsImage = new Image(String.valueOf(getClass().getResource("/assets/instructions.png")));
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
                SuportScreen.getStage().close();
                Main fase = new Main();
                try {
                    fase.start(new Stage());
                } catch (Exception ex){
                    //pass
                }
            }
        });

        image.getChildren().addAll(play);

        return new Scene(image, 1200, 600);
    }
}
