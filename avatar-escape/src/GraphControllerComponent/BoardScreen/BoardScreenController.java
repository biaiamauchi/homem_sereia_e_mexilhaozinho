package GraphControllerComponent.BoardScreen;

import CharacterComponent.Villains;
import GameControllerComponent.GameController;
import GameControllerComponent.iGameControllerProperties;
import GraphControllerComponent.FightScreen.FightScreenController;
import GraphControllerComponent.GraphController;
import GraphControllerComponent.PlayAgainScreen.PlayAgainScreenController;
import GraphControllerComponent.iGraphControllerProperties;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.util.Random;

public class BoardScreenController extends GameController {
    private ImageView boardCharacters[][] = new ImageView[6][6];
    private ImageView avatar = new ImageView();
    private ProgressBar avatarLife = new ProgressBar();
    private ProgressBar avatarScore = new ProgressBar();
    private Label avatarLifeLabel = new Label();
    private Label avatarScoreLabel = new Label();
    private Label message = new Label();

    private iGameControllerProperties game;
    private iGraphControllerProperties screen = new GraphController();

    public BoardScreenController(iGameControllerProperties game){
        this.game = game;
        this.screen.setGame(game);
    }

    public Scene boardScreen(){
        String map = "src/assets/maps/level" + game.getBoard().getBoard().getLevel() + "/fase" + game.getBoard().getBoard().getLevel() + "." + String.valueOf(new Random().nextInt(15) + 1) + ".csv";
        this.game.play(map);

        String screenName = "Fase - " + game.getBoard().getBoard().getLevel();
        BoardScreenDesigner boardScreen = new BoardScreenDesigner();
        Group root = boardScreen.groupScene(screen,
                                            boardCharacters, avatar,
                                            avatarLife, avatarLifeLabel,
                                            avatarScore, avatarScoreLabel,
                                            message);

        Scene cena = new Scene(root, 1200, 600);
        cena.addEventHandler(KeyEvent.KEY_PRESSED, movementsEvent);
        return cena;
    }

    EventHandler<KeyEvent> movementsEvent = new EventHandler<>() {
        @Override
        public void handle(KeyEvent event) {
            message.setText("");
            if (event.getCode() == KeyCode.DOWN) {
                if(avatar.getY() >= 10 && avatar.getY() < 510)
                    avatar.setY(avatar.getY()+100);
                else
                    message.setText("Ande no tabuleiro!");
            }
            else if (event.getCode() == KeyCode.UP) {
                if(avatar.getY() > 10 && avatar.getY() <= 510)
                    avatar.setY(avatar.getY()-100);
                else
                    message.setText("Ande no tabuleiro!");
            }
            else if (event.getCode() == KeyCode.LEFT) {
                if(avatar.getX() > 35 && avatar.getX() <= 785)
                    avatar.setX(avatar.getX()-150);
                else
                    message.setText("Ande no tabuleiro!");
            }
            else if (event.getCode() == KeyCode.RIGHT) {
                if(avatar.getX() >= 35 && avatar.getX() < 785)
                    avatar.setX(avatar.getX()+150);
                else
                    message.setText("Ande no tabuleiro!");
            }
            else
                message.setText("Tecla inválida");

            verifyCell();
        }
    };

    public void verifyCell(){
        int newLine = (int)(avatar.getY()/100);
        int newCollumn = (int)(avatar.getX()/150);
        String text = "";
        double lifeIncrement = 0, scoreIncrement = 0;

        if(game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter() != null){
            if(game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter() instanceof Villains) {
                lifeIncrement = game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter().getLife();
                text = String.valueOf(lifeIncrement) +
                        "% de Vida\n" +
                        "Você não pode ficar aí, tem um sentinela do fogo!";

                message.setText(text);
                avatarLife.setProgress(avatarLife.getProgress()+lifeIncrement/100);
                game.getAvatar().setLife((int)(avatarLife.getProgress()*100)); //usar addLife

                avatarLifeLabel.setText("Vida - " + (int)(avatarLife.getProgress()*100) + "%");
                boardCharacters[newLine][newCollumn].opacityProperty().set(1);

                if((int)(avatarLife.getProgress()*100) <= 0){
                    screen.getStage().setScene(new PlayAgainScreenController().playAgainScreen("/assets/messages/lose.png"));
                }
            }
            else {
                if (game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter().getCharacter() != "Door" && game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter().getCharacter() != "Appa") {
                    if (game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter().getCharacter() == "Katara" && boardCharacters[newLine][newCollumn] != null) {
                        lifeIncrement = game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter().getLife();
                        text = "+" + String.valueOf(lifeIncrement) +
                                "% de Vida\n" +
                                "Você encontrou a Katara e o Sokka!";
                    } else if (game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter().getCharacter() == "Toph" && boardCharacters[newLine][newCollumn] != null) {
                        lifeIncrement = game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter().getLife();
                        scoreIncrement = game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter().getScore();
                        text = "+" + String.valueOf(lifeIncrement) +
                                "% de Vida e +" + String.valueOf(scoreIncrement) + "% de Estado Avatar\n" +
                                "Você encontrou a Toph!";
                    } else if (game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter().getCharacter() == "Zuko" && boardCharacters[newLine][newCollumn] != null) {
                        lifeIncrement = game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter().getLife();
                        scoreIncrement = game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter().getScore();
                        text = "+" + String.valueOf(lifeIncrement) +
                                "% de Vida e +" + String.valueOf(scoreIncrement) + "% de Estado Avatar\n" +
                                "Você encontrou o Zuko!";
                    }

                    message.setText(text);

                    avatarLife.setProgress(avatarLife.getProgress() + lifeIncrement/100);
                    avatarScore.setProgress(avatarScore.getProgress() + scoreIncrement/100);

                    avatarLifeLabel.setText("Vida - " + (int) (avatarLife.getProgress() * 100) + "%");
                    avatarScoreLabel.setText("Estado Avatar - " + (int) (avatarScore.getProgress() * 100) + "%");

                    game.getAvatar().addLife((int)lifeIncrement);
                    game.getAvatar().addScore((int)scoreIncrement);

                    if(boardCharacters[newLine][newCollumn] != null) {
                        boardCharacters[newLine][newCollumn].opacityProperty().set(0);
                        boardCharacters[newLine][newCollumn] = null;
                    }
                }
                else{
                    if(game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter().getCharacter() == "Door")
                        screen.getStage().setScene(new FightScreenController(game).fightScreen());
                    else{
                        game.getBoard().getBoard().setLevel(game.getBoard().getBoard().getLevel() + 1);
                        screen.getStage().setScene(new BoardScreenController(game).boardScreen());
                    }
                }
            }
        }
    }
}