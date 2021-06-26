package GraphControllerComponent.FightScreen;

import GraphControllerComponent.iGraphControllerProperties;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class FightScreenDesigner {
    private iGraphControllerProperties screen;

    public Group groupScene(iGraphControllerProperties screen,
                            ProgressBar avatarLife, ProgressBar avatarScore, Label avatarLifeLabel, Label avatarScoreLabel,
                            ProgressBar villainLife, ProgressBar villainScore, Label villainLifeLabel, Label villainScoreLabel,
                            Label avatarLabelMovement, Label villainLabelMovement){

        this.screen = screen;
        return new Group(   background(),
                            createAvatar(avatarLife, avatarScore, avatarLifeLabel, avatarScoreLabel),
                            createVillan(villainLife, villainScore, villainLifeLabel, villainScoreLabel),
                            instructions(avatarLabelMovement, villainLabelMovement));
    }

    private ImageView background(){
        Image image = new Image(String.valueOf(getClass().getResource("/assets/background/boardBackground.png")));
        ImageView background = new ImageView(image);

        return background;
    }

    private Group createAvatar(ProgressBar avatarLife, ProgressBar avatarScore, Label avatarLifeLabel, Label avatarScoreLabel){
        avatarLife.setProgress((double)screen.getGame().getAvatar().getLife()/100);
        avatarLife.setStyle("-fx-accent: #49AF59");
        avatarLife.setMaxWidth(300);
        avatarLife.setTranslateX(25);
        avatarLife.setTranslateY(110);
        avatarLife.setPrefWidth(300);

        avatarScore.setProgress((double)screen.getGame().getAvatar().getScore()/100);
        avatarScore.setStyle("-fx-accent: #517AC9");
        avatarScore.setMaxWidth(300);
        avatarScore.setTranslateX(25);
        avatarScore.setTranslateY(220);
        avatarScore.setPrefWidth(300);

        String text = "Vida - " + (int)(avatarLife.getProgress()*100) + "%";
        avatarLifeLabel.setText(text);
        avatarLifeLabel.setTranslateX(140);
        avatarLifeLabel.setTranslateY(70);
        avatarLifeLabel.setFont(new Font("Inter", 18));

        text = "Estado Avatar - " + (int)(avatarScore.getProgress()*100) + "%";
        avatarScoreLabel.setText(text);
        avatarScoreLabel.setTranslateX(100);
        avatarScoreLabel.setTranslateY(180);
        avatarScoreLabel.setFont(new Font("Inter", 18));

        ImageView avatar = new ImageView(new Image(String.valueOf(getClass().getResource("/assets/characters/heroes/AangFight.png"))));
        avatar.setFitWidth(200);
        avatar.setFitHeight(200);
        avatar.setX(350);
        avatar.setY(70);

        return new Group(avatarLife, avatarLifeLabel, avatarScore, avatarScoreLabel, avatar);
    }

    private Group createVillan(ProgressBar villainLife, ProgressBar villainScore, Label villainLifeLabel, Label villainScoreLabel){
        villainLife.setProgress(1.0F);
        villainLife.setStyle("-fx-accent: #49AF59");
        villainLife.setMaxWidth(300);
        villainLife.setTranslateX(875);
        villainLife.setTranslateY(110);
        villainLife.setPrefWidth(300);

        villainScore.setProgress(0.25 * screen.getGame().getBoard().getBoard().getLevel());
        villainScore.setStyle("-fx-accent: #517AC9");
        villainScore.setMaxWidth(300);
        villainScore.setTranslateX(875);
        villainScore.setTranslateY(220);
        villainScore.setPrefWidth(300);

        String text = "Vida - " + (int)(villainLife.getProgress()*100) + "%";
        villainLifeLabel.setText(text);
        villainLifeLabel.setTranslateX(980);
        villainLifeLabel.setTranslateY(70);
        villainLifeLabel.setFont(new Font("Inter", 18));

        text = "Força - " + (int)(villainScore.getProgress()*100) + "%";
        villainScoreLabel.setText(text);
        villainScoreLabel.setTranslateX(975);
        villainScoreLabel.setTranslateY(180);
        villainScoreLabel.setFont(new Font("Inter", 18));

        String villainSource = "/assets/characters/villains/villain" + screen.getGame().getBoard().getBoard().getLevel() + ".png";
        ImageView villain = new ImageView(new Image(String.valueOf(getClass().getResource(villainSource))));
        villain.setFitWidth(200);
        villain.setFitHeight(200);
        villain.setX(650);
        villain.setY(70);

        return new Group(villainLife, villainLifeLabel, villainScore, villainScoreLabel, villain);
    }

    private Group instructions(Label avatarLabelMovement, Label villainLabelMovement){
        avatarLabelMovement.setText("");
        avatarLabelMovement.setTranslateX(100);
        avatarLabelMovement.setTranslateY(300);
        avatarLabelMovement.setFont(new Font("Inter", 18));
        avatarLabelMovement.setStyle("-fx-font-weight: bold");

        villainLabelMovement.setText("");
        villainLabelMovement.setTranslateX(790);
        villainLabelMovement.setTranslateY(300);
        villainLabelMovement.setFont(new Font("Inter", 18));
        villainLabelMovement.setStyle("-fx-font-weight: bold");

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

        return new Group(water, earth, fire, air, x, avatarLabelMovement, villainLabelMovement);
    }
}
