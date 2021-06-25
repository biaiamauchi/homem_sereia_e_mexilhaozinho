package GraphControllerComponent.teste;
import GraphControllerComponent.FightScreen.FightScreenController;
import GraphControllerComponent.SuportScreen.SuportScreenController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class prototipoFight extends Application {
    private ProgressBar avatarLife;
    private ProgressBar avatarScore;
    private Label avatarLifeLabel;
    private Label avatarScoreLabel;

    private ProgressBar villainLife;
    private ProgressBar villainScore;
    private Label villainLifeLabel;
    private Label villainScoreLabel;

    private static Stage stage;

    public static void Main(String[] args){
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("Fase 1");
        Scene tela = fightScreen();
        stage.setScene(tela);
        stage.show();
        setStage(stage);
    }

    public static Stage getStage(){
        return stage;
    }

    public static void setStage(Stage stageJ){
        stage = stageJ;
    }

    public Group createAvatar(){
        avatarLife = new ProgressBar(0.6F);
        avatarLife.setTranslateY(30);

        avatarScore = new ProgressBar(1.0F);
        avatarScore.setTranslateY(70);

        String text = "Vida - " + (int)(avatarLife.getProgress()*100) + "%";
        avatarLifeLabel = new Label(text);
        avatarLife.setTranslateY(15);

        text = "Estado Avatar - " + (int)(avatarScore.getProgress()*100) + "%";
        avatarScoreLabel = new Label(text);
        avatarScoreLabel.setTranslateY(55);

        ImageView avatar = new ImageView(new Image(String.valueOf(getClass().getResource("/assets/characters/heroes/Aang.png"))));
        avatar.setFitWidth(105);
        avatar.setFitHeight(100);
        avatar.setX(250);
        //avatar.minWidth(450);
        //avatar.minHeight(100);

        Group root = new Group(avatarLife, avatarLifeLabel, avatarScore, avatarScoreLabel, avatar);
        return root;
    }

    public Scene fightScreen(){
        Group root = new Group();
        Image image = new Image(String.valueOf(getClass().getResource("/assets/background/boardBackground.png")));
        ImageView background = new ImageView(image);

        root.minWidth(1200);
        root.minHeight(600);

        root.getChildren().addAll(createAvatar());

        Scene cena = new Scene(root, 1200, 600);
        return cena;
    }
}
