package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import javafx.scene.shape.Rectangle;
import java.lang.Object;
import javafx.scene.control.Label;

import javafx.scene.paint.Color;


public class Main extends Application {
    public Parent createContent(){
        StackPane painelInfo = new StackPane();
        painelInfo.getChildren().addAll(new Rectangle(300,600,Color.BLUE));
        painelInfo.setAlignment(Pos.CENTER_RIGHT);

        BackgroundImage fundo = new BackgroundImage(new Image("../../assets/backgrounds/junina.jpeg"), null, null, null, null);

        StackPane tabuleiro = new StackPane();
        tabuleiro.getChildren().addAll(new Rectangle(900,600,Color.GRAY));
        tabuleiro.setAlignment(Pos.CENTER_LEFT);

        return new StackPane(painelInfo, tabuleiro);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Avatar Escape");
        stage.setScene(new Scene(createContent(), 1200, 600));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
