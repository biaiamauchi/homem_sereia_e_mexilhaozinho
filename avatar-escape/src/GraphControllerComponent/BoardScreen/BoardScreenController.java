package GraphControllerComponent.BoardScreen;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class BoardScreenController {
    private ImageView avatar;
    private ProgressBar avatarLife;
    private ProgressBar avatarScore;
    private Label message;

    public void criarAvatar(){
        Image avatarImagem = new Image(String.valueOf(getClass().getResource("/assets/characters/heroes/Aang.png")));
        this.avatar = new ImageView(avatarImagem);
        avatar.setX(35); //anda 150 horizontalmente
        avatar.setY(10); //anda 100 verticalmente
    }

    public void criarAvatarLife(){
        this.avatarLife = new ProgressBar(1.0F);
        this.avatarLife.setStyle("-fx-accent: red");
        this.avatarLife.setMaxWidth(100);
        this.avatarLife.setTranslateX(100);
        this.avatarLife.setTranslateY(100);
    }

    public void criarAvatarScore(){
        this.avatarScore = new ProgressBar(0.6F);
        this.avatarScore.setStyle("-fx-accent: blue");
        this.avatarScore.setMaxWidth(100);
        this.avatarScore.setTranslateX(100);
        this.avatarScore.setTranslateY(175);
    }

    public Group avatarInfo(){
        criarAvatarLife();
        criarAvatarScore();
        Rectangle fundo = new Rectangle(300, 600, Color.GRAY);

        String text = "Vida - " + (int)(this.avatarLife.getProgress()*100) + "%";
        Label labelLife = label(text, 105, 75);
        labelLife.setFont(new Font("Inter", 18));

        text = "Estado Avatar - " + (int)(this.avatarScore.getProgress()*100) + "%";
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
        Image background = new Image(String.valueOf(getClass().getResource("/assets/background/boardBackground.png")));
        ImageView backgroundView = new ImageView(background);

        Image grid = new Image(String.valueOf(getClass().getResource("/assets/background/boardGrid.png")));
        ImageView gridView = new ImageView(grid);

        Group board = new Group(backgroundView, gridView);
        board.minWidth(900);
        board.minHeight(600);

        //board.setTranslateY(100);

        return board;
    }

    public Scene boardScreen(){
        criarAvatar();

        Group root = new Group(board(), this.avatar,avatarInfo());
        Scene cena = new Scene(root, 1200, 600);
        cena.setOnKeyPressed((new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.DOWN) {
                    avatar.setY(avatar.getY()+100);
                }
                else if (event.getCode() == KeyCode.UP) {
                    avatar.setY(avatar.getY()-100);
                }
                else if (event.getCode() == KeyCode.LEFT) {
                    avatar.setX(avatar.getX()-150);
                }
                else if (event.getCode() == KeyCode.RIGHT) {
                    avatar.setX(avatar.getX()+150);
                }
            }
        }));
        return cena;
    }
}
