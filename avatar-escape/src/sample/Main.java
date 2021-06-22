package sample;

import GameControllerComponent.GameController;
import GameControllerComponent.iGameControllerProperties;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.*;
import javafx.scene.shape.Rectangle;
import java.lang.Object;
import javafx.scene.control.Label;

import javafx.scene.paint.Color;
import javafx.scene.control.ProgressBar;
import javafx.geometry.Insets;


public class Main extends Application {
    private ImageView avatar;
    private ProgressBar avatarLife;
    private ProgressBar avatarScore;
    private Label message;

    public void criarAvatar(){
        Image avatarImagem = new Image(String.valueOf(getClass().getResource("/assets/Aang.png")));
        this.avatar = new ImageView(avatarImagem);
        avatar.setX(20);
        avatar.setY(20);
    }

    public void criarAvatarLife(){
        this.avatarLife = new ProgressBar(100);
        this.avatarLife.setStyle("-fx-accent: red");
        this.avatarLife.setMaxWidth(100);
        this.avatarLife.setTranslateX(100);
        this.avatarLife.setTranslateY(100);
    }

    public void criarAvatarScore(){
        this.avatarScore = new ProgressBar(60);
        this.avatarScore.setStyle("-fx-accent: blue");
        this.avatarScore.setMaxWidth(100);
        this.avatarScore.setTranslateX(100);
        this.avatarScore.setTranslateY(175);
    }

    public Group avatarInfo(){
        criarAvatarLife();
        criarAvatarScore();
        Rectangle fundo = new Rectangle(300, 600, Color.GRAY);

        String text = "Vida - " + (int)this.avatarLife.getProgress() + "%";
        Label labelLife = label(text, 105, 75);
        labelLife.setFont(new Font("Inter", 18));

        text = "Estado Avatar - " + (int)this.avatarScore.getProgress() + "%";
        Label labelScore = label(text, 75, 150);
        labelScore.setFont(new Font("Inter", 18));

        Group info = new Group(this.avatarLife, this.avatarScore, labelLife, labelScore);

        this.message = label("", 50, 300);
        this.message.setFont(new Font("Inter", 16));
        this.message.setTextAlignment(TextAlignment.CENTER);
        this.message.setWrapText(true);
        this.message.setMaxWidth(200);

        Group screenInfo = new Group(fundo, info, this.message);
        screenInfo.setTranslateX(900);

        return screenInfo;
    }

    public Label label(String msg, double x, double y){
        Label life = new Label(msg);
        life.setTranslateX(x);
        life.setTranslateY(y);
        return life;
    }

    public Group board(){
        Group board = new Group();

        return board;
    }

    public Scene instructionsScreen(){

        Scene instructions = new Scene();
    }

    @Override
    public void start(Stage stage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Avatar Escape");
        criarAvatar();

        Group root = new Group(avatarInfo());
        Scene cena = new Scene(root, 1200, 600);
        cena.setOnKeyPressed((new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.DOWN) {
                    System.out.println("Hello World");
                    avatar.setX(avatar.getX()+40);
                }
            }
        }));
        stage.setScene(cena);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        //iGameControllerProperties game = new GameController();
        //game.play("src/assets/mapa.txt");
        launch(args);
    }
}

/*
*     public Group createContent(){
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
        painelInfo.getChildren().addAll(teste1());

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

        return new Group(tabuleiro, painelInfo);
    }
*/
