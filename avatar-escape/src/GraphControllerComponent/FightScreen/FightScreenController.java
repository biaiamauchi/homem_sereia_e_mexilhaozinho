package GraphControllerComponent.FightScreen;

import GameControllerComponent.iGameControllerProperties;
import GraphControllerComponent.BoardScreen.BoardScreenController;
import GraphControllerComponent.FadeAnimation;
import GraphControllerComponent.Main.GraphController;
import GraphControllerComponent.PlayAgainScreen.PlayAgainScreenController;
import GraphControllerComponent.Main.iGraphControllerProperties;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.util.Random;

public class FightScreenController {
    private ProgressBar avatarLife = new ProgressBar();
    private ProgressBar avatarScore = new ProgressBar();
    private Label avatarLifeLabel = new Label();
    private Label avatarScoreLabel = new Label();

    private ProgressBar villainLife = new ProgressBar();
    private ProgressBar villainScore = new ProgressBar();
    private Label villainLifeLabel = new Label();
    private Label villainScoreLabel = new Label();

    private Label avatarLabelMovement = new Label();
    private Label villainLabelMovement = new Label();

    private iGameControllerProperties game;
    private iGraphControllerProperties screen = new GraphController();

    public FightScreenController(iGameControllerProperties game){
        this.game = game;
        this.screen.setGame(game);
    }

    public Scene fightScreen(){
        FightScreenDesigner fightScreen = new FightScreenDesigner();
        Group root = fightScreen.groupScene(screen,
                                            avatarLife, avatarScore, avatarLifeLabel, avatarScoreLabel,
                                            villainLife, villainScore, villainLifeLabel, villainScoreLabel,
                                            avatarLabelMovement, villainLabelMovement);

        Scene cena = new Scene(root, 1200, 600);
        cena.addEventHandler(KeyEvent.KEY_PRESSED, movementsEvent);

        return cena;
    }

    EventHandler<KeyEvent> movementsEvent = new EventHandler<>() {
        @Override
        public void handle(KeyEvent event) {
            String text = "";
            avatarLabelMovement.setText(text);
            villainLabelMovement.setText(text);
            boolean validMovement = false;

            if (event.getCode() == KeyCode.NUMPAD1 || event.getCode() == KeyCode.DIGIT1) {
                verifyLimit(avatarLife, 0.10);
                avatarLifeLabel.setText("Vida - " + (int) (avatarLife.getProgress() * 100) + "%");
                screen.getGame().getAvatar().setLife((int) (avatarLife.getProgress() * 100));

                text = "Você se curou: +10% de vida";

                validMovement = true;
            } else if (event.getCode() == KeyCode.NUMPAD2 || event.getCode() == KeyCode.DIGIT2) {
                verifyLimit(avatarScore, 0.10);
                avatarScoreLabel.setText("Estado Avatar - " + (int) (avatarScore.getProgress() * 100) + "%");
                screen.getGame().getAvatar().setScore((int) (avatarScore.getProgress() * 100));

                text = "Você se curou: +10% de Estado Avatar";

                validMovement = true;
            } else if (event.getCode() == KeyCode.NUMPAD3 || event.getCode() == KeyCode.DIGIT3) {
                double damage = (screen.getGame().getAvatar().getScore() * 0.1) / 100;
                verifyLimit(villainLife, -damage);
                villainLifeLabel.setText("Vida - " + (int) (villainLife.getProgress() * 100) + "%");

                text = "Você atacou com: 10% do Estado Avatar";

                validMovement = true;
            } else if (event.getCode() == KeyCode.NUMPAD4 || event.getCode() == KeyCode.DIGIT4) {
                verifyLimit(villainScore, -0.10);
                villainScoreLabel.setText("Força - " + (int) (villainScore.getProgress() * 100) + "%");

                text = "Você atacou: -10% da Força do Inimigo";

                validMovement = true;
            } else
                validMovement = false;

            if (validMovement) {
                avatarLabelMovement.setText(text);
                FadeAnimation teste = new FadeAnimation();

                Random villainMovement = new Random();
                if (villainMovement.nextBoolean()) { //attack
                    verifyLimit(avatarLife, -villainScore.getProgress() / 10);
                    avatarLifeLabel.setText("Vida - " + (int) (avatarLife.getProgress() * 100) + "%");
                    screen.getGame().getAvatar().setLife((int) (avatarLife.getProgress() * 100));

                    text = "Inimigo te atacou: -" + String.valueOf(villainScore.getProgress() * 10) + "% de vida";
                } else {
                    verifyLimit(villainLife, 0.05);
                    villainLifeLabel.setText("Vida - " + (int) (villainLife.getProgress() * 100) + "%");

                    text = "Inimigo se curou: 10% de vida";
                }

                villainLabelMovement.setText(text);

                verifyGameProgress();
            }
            else
                avatarLabelMovement.setText("Tecla inválida");
        }
    };

    public void verifyGameProgress(){
        if(villainLife.getProgress() <= 0){
            game.getBoard().getBoard().setLevel(game.getBoard().getBoard().getLevel() + 1);

            if(game.getBoard().getBoard().getLevel() == 4) {
                screen.getStage().setTitle("Avatar Escape - Fase " + game.getBoard().getBoard().getLevel());
                screen.getStage().setScene(new FightScreenController(game).fightScreen());
            }
            else if(game.getBoard().getBoard().getLevel() <= 3){
                screen.getStage().setScene(new BoardScreenController(game).boardScreen());
            }
            else{
                screen.getStage().setScene(new PlayAgainScreenController().playAgainScreen("/assets/messages/win.png"));
            }
        }
        else if(avatarLife.getProgress() <= 0){
            screen.getStage().setScene(new PlayAgainScreenController().playAgainScreen("/assets/messages/lose.png"));
        }
    }

    private void verifyLimit(ProgressBar bar, double amount){
        if(bar.getProgress()+amount >= 1.0)
            bar.setProgress(1.0);
        else if(bar.getProgress()+amount <= 0.0)
            bar.setProgress(0.0);
        else
            bar.setProgress(bar.getProgress()+amount);
    }
}
