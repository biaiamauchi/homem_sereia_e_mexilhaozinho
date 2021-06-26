package GraphControllerComponent.FightScreen;

import GameControllerComponent.iGameControllerProperties;
import GraphControllerComponent.BoardScreen.BoardScreenController;
import GraphControllerComponent.GraphController;
import GraphControllerComponent.iGraphControllerProperties;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;

import java.util.Random;

public class FightScreenController {
    private ProgressBar avatarLife;
    private ProgressBar avatarScore;
    private Label avatarLifeLabel;
    private Label avatarScoreLabel;

    private ProgressBar villainLife;
    private ProgressBar villainScore;
    private Label villainLifeLabel;
    private Label villainScoreLabel;

    iGameControllerProperties game;
    iGraphControllerProperties screen = new GraphController();

    public FightScreenController(iGameControllerProperties game){
        this.game = game;
        this.screen.setGame(game);
    }

    public Group createAvatar(){
        avatarLife = new ProgressBar((double)screen.getGame().getAvatar().getLife()/100);
        avatarLife.setStyle("-fx-accent: #49AF59");
        avatarLife.setMaxWidth(300);
        avatarLife.setTranslateX(25);
        avatarLife.setTranslateY(110);
        avatarLife.setPrefWidth(300);

        avatarScore = new ProgressBar((double)screen.getGame().getAvatar().getScore()/100);
        avatarScore.setStyle("-fx-accent: #517AC9");
        avatarScore.setMaxWidth(300);
        avatarScore.setTranslateX(25);
        avatarScore.setTranslateY(220);
        avatarScore.setPrefWidth(300);

        String text = "Vida - " + (int)(avatarLife.getProgress()*100) + "%";
        avatarLifeLabel = new Label(text);
        avatarLifeLabel.setTranslateX(140);
        avatarLifeLabel.setTranslateY(70);
        avatarLifeLabel.setFont(new Font("Inter", 18));

        text = "Estado Avatar - " + (int)(avatarScore.getProgress()*100) + "%";
        avatarScoreLabel = new Label(text);
        avatarScoreLabel.setTranslateX(100);
        avatarScoreLabel.setTranslateY(180);
        avatarScoreLabel.setFont(new Font("Inter", 18));

        ImageView avatar = new ImageView(new Image(String.valueOf(getClass().getResource("/assets/characters/heroes/AangFight.png"))));
        avatar.setFitWidth(200);
        avatar.setFitHeight(200);
        avatar.setX(350);
        avatar.setY(70);
        //avatar.minWidth(450);
        //avatar.minHeight(100);

        Group root = new Group(avatarLife, avatarLifeLabel, avatarScore, avatarScoreLabel, avatar);
        return root;
    }

    public Group createVillan(){
        villainLife = new ProgressBar(1.0F);
        villainLife.setStyle("-fx-accent: #49AF59");
        villainLife.setMaxWidth(300);
        villainLife.setTranslateX(875);
        villainLife.setTranslateY(110);
        villainLife.setPrefWidth(300);

        villainScore = new ProgressBar(0.5F);
        villainScore.setStyle("-fx-accent: #517AC9");
        villainScore.setMaxWidth(300);
        villainScore.setTranslateX(875);
        villainScore.setTranslateY(220);
        villainScore.setPrefWidth(300);

        String text = "Vida - " + (int)(villainLife.getProgress()*100) + "%";
        villainLifeLabel = new Label(text);
        villainLifeLabel.setTranslateX(980);
        villainLifeLabel.setTranslateY(70);
        villainLifeLabel.setFont(new Font("Inter", 18));

        text = "Força - " + (int)(villainScore.getProgress()*100) + "%";
        villainScoreLabel = new Label(text);
        villainScoreLabel.setTranslateX(975);
        villainScoreLabel.setTranslateY(180);
        villainScoreLabel.setFont(new Font("Inter", 18));

        String villainSource = "/assets/characters/villains/villain" + game.getBoard().getBoard().getLevel() + ".png";
        ImageView villain = new ImageView(new Image(String.valueOf(getClass().getResource(villainSource))));
        villain.setFitWidth(200);
        villain.setFitHeight(200);
        villain.setX(650);
        villain.setY(70);
        //avatar.minWidth(450);
        //avatar.minHeight(100);

        Group root = new Group(villainLife, villainLifeLabel, villainScore, villainScoreLabel, villain);
        return root;
    }

    public Group instructions(){

        ImageView water = new ImageView(new Image(String.valueOf(getClass().getResource("/assets/instructions/instruction1.png"))));
        water.setFitWidth(250);
        water.setFitHeight(205);
        water.setX(15);
        water.setY(350);

        ImageView earth = new ImageView(new Image(String.valueOf(getClass().getResource("/assets/instructions/instruction2.png"))));
        earth.setFitWidth(250);
        earth.setFitHeight(205);
        earth.setX(310);
        earth.setY(350);

        ImageView fire = new ImageView(new Image(String.valueOf(getClass().getResource("/assets/instructions/instruction3.png"))));
        fire.setFitWidth(250);
        fire.setFitHeight(205);
        fire.setX(625);
        fire.setY(350);

        ImageView air = new ImageView(new Image(String.valueOf(getClass().getResource("/assets/instructions/instruction4.png"))));
        air.setFitWidth(250);
        air.setFitHeight(205);
        air.setX(915);
        air.setY(350);

        ImageView x = new ImageView(new Image(String.valueOf(getClass().getResource("/assets/background/X.png"))));
        x.setFitWidth(16);
        x.setFitHeight(28);
        x.setX(592);
        x.setY(152);

        Group root = new Group(water, earth, fire, air, x);
        return root;
    }

    public Scene fightScreen(){
        Image image = new Image(String.valueOf(getClass().getResource("/assets/background/boardBackground.png")));
        ImageView background = new ImageView(image);

        Group root = new Group(background);

        root.minWidth(1200);
        root.minHeight(600);

        root.getChildren().addAll(createAvatar());
        root.getChildren().addAll(createVillan());
        root.getChildren().addAll(instructions());

        Scene cena = new Scene(root, 1200, 600);
        cena.setOnKeyPressed((new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.NUMPAD1 || event.getCode() == KeyCode.DIGIT1) {
                    avatarLife.setProgress(avatarLife.getProgress()+0.10F);
                    avatarLifeLabel.setText("Vida - " + (int)(avatarLife.getProgress()*100) + "%");
                    screen.getGame().getAvatar().setLife((int)(avatarLife.getProgress()*100));
                } else if (event.getCode() == KeyCode.NUMPAD2 || event.getCode() == KeyCode.DIGIT2) {
                    avatarScore.setProgress(avatarScore.getProgress()+0.10F);
                    avatarScoreLabel.setText("Estado Avatar - " + (int)(avatarScore.getProgress()*100) + "%");
                    screen.getGame().getAvatar().setLife((int)(avatarLife.getProgress()*100));
                } else if (event.getCode() == KeyCode.NUMPAD3 || event.getCode() == KeyCode.DIGIT3) {
                    villainLife.setProgress(villainLife.getProgress()-0.10F);
                    villainLifeLabel.setText("Vida - " + (int)(villainLife.getProgress()*100) + "%");
                } else if (event.getCode() == KeyCode.NUMPAD4 || event.getCode() == KeyCode.DIGIT4) {
                    villainScore.setProgress(villainScore.getProgress()-0.10F);
                    villainScoreLabel.setText("Força - " + (int)(villainScore.getProgress()*100) + "%");
                }

                Random villainMovement = new Random();
                if(villainMovement.nextBoolean()) { //true = attack
                    int attack = 2 + villainMovement.nextInt(2 * screen.getGame().getBoard().getBoard().getLevel());
                    avatarLife.setProgress(avatarLife.getProgress()-(double)attack/100);
                    avatarLifeLabel.setText("Vida - " + (int)(avatarLife.getProgress()*100) + "%");
                    screen.getGame().getAvatar().setLife(screen.getGame().getAvatar().getLife()-attack);
                }
                else{
                    int defense = 2+ villainMovement.nextInt(2 * screen.getGame().getBoard().getBoard().getLevel());
                    villainLife.setProgress(villainLife.getProgress()+(double)defense/100);
                    villainLifeLabel.setText("Vida - " + (int)(villainLife.getProgress()*100) + "%");
                }

                if(villainLife.getProgress() <= 0){
                    game.getBoard().getBoard().setLevel(game.getBoard().getBoard().getLevel()+1);
                    screen.getStage().setScene(new BoardScreenController(game).boardScreen());
                }
            }
        }));

        return cena;
    }
}
