package GraphControllerComponent;

import GameControllerComponent.GameController;
import GameControllerComponent.iGameControllerProperties;
import GraphControllerComponent.SuportScreen.SuportScreenController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import CharacterComponent.iCharacterProperties;
import javafx.stage.StageStyle;

public class GraphController extends Application implements iGraphControllerProperties{
    private iGameControllerProperties game = new GameController();
    private static Stage stage;
    private iCharacterProperties avatar;

    public static void Main(String[] args){
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNDECORATED);
        Scene tela = new SuportScreenController().instructionsScreen();
        stage.setScene(tela);
        stage.show();
        setStage(stage);
    }

    public Stage getStage(){
        return stage;
    }

    public void setStage(Stage fixStage){
        stage = fixStage;
    }

    public iGameControllerProperties getGame(){
        return this.game;
    }

    public void updateAvatar(int life){
        this.avatar.setLife(this.avatar.getLife()+life);
    }

    public void setAvatar(iCharacterProperties avatar){
        this.avatar = avatar;
    }

    public Group screenStyle(String imagemString, String screenNameText, Color color){
        Group bar = new Group();

        Rectangle barObject = new Rectangle();
        barObject.setFill(color);
        barObject.setWidth(1200);
        barObject.setHeight(50);

        Label gameName = new Label("Avatar Escape");
        gameName.setFont(new Font("Inter", 22));
        gameName.setStyle("-fx-font-weight: bold");
        gameName.setTranslateY(8);
        gameName.setTranslateX(20);

        Label screenName = new Label(screenNameText);
        screenName.setFont(new Font("Inter", 20));
        screenName.setStyle("-fx-font-weight: bold");
        screenName.setTranslateY(8);
        screenName.setTranslateX(550);

        Button close = new Button();
        Image img = new Image(String.valueOf(getClass().getResource(imagemString)));
        ImageView view = new ImageView(img);
        view.setFitHeight(40);
        view.setFitWidth(40);
        view.maxWidth(40);
        view.maxHeight(40);
        view.setTranslateX(1140);

        close.setGraphic(view);
        close.setStyle("-fx-background-color: transparent; -fx-cursor: hand");
        close.setPrefSize(40, 40);
        close.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent e) {
                stage.close();
            }
        });


        bar.getChildren().addAll(barObject, close, gameName, screenName);

        return bar;
    }
}
