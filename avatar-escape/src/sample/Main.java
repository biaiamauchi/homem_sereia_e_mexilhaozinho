package sample;

import GameControllerComponent.GameController;
import GameControllerComponent.iGameControllerProperties;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import javafx.scene.shape.Rectangle;
import java.lang.Object;
import javafx.scene.control.Label;

import javafx.scene.paint.Color;
import javafx.scene.control.ProgressBar;
import javafx.geometry.Insets;


public class Main {//extends Application {
    /*public Parent createContent(){
        ProgressBar p2 = new ProgressBar();
        p2.setProgress(0.5F);

        Label life = new Label("Vida");
        life.setLabelFor(p2);
        life.setTranslateY(-50);

        StackPane painelInfo = new StackPane();
        painelInfo.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
        painelInfo.setTranslateX(450);
        painelInfo.setMaxHeight(600);
        painelInfo.setMaxWidth(300);
        painelInfo.getChildren().addAll(p2, life);


        //FileInputStream input = new FileInputStream("resources/images/iconmonstr-home-6-48.png");
        //Image image = new Image(input);
        //ImageView imageView = new ImageView(image);
        //Label label = new Label("My Label", imageView);

        //Image imagem = new Image(String.valueOf(getClass().getResource("/assets/junina.jpg")));
        //BackgroundImage fundo = new BackgroundImage(imagem, null, null, null, null);
        //tabuleiro.setBackground(new Background(fundo));

        StackPane tabuleiro = new StackPane();
        tabuleiro.setBackground(new Background(new BackgroundFill(Color.BROWN, null, null)));
        tabuleiro.setAlignment(Pos.CENTER_LEFT);

        return new StackPane(tabuleiro, painelInfo);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Avatar Escape");
        stage.setScene(new Scene(createContent(), 1200, 600));
        stage.setResizable(false);
        stage.get
        stage.show();
    }*/


    public static void main(String[] args) {
        iGameControllerProperties game = new GameController();
        game.play("src/assets/mapa.txt");
        //launch(args);
    }
}
