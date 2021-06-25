package GraphControllerComponent.BoardScreen;

import CharacterComponent.Villans;
import GameControllerComponent.GameController;
import GameControllerComponent.iGameControllerProperties;
import GraphControllerComponent.FightScreen.FightScreenController;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class BoardScreenController extends GameController {
    private ImageView boardCharacters[][] = new ImageView[6][6];
    private ImageView avatar;
    private ProgressBar avatarLife;
    private ProgressBar avatarScore;
    private Label avatarLifeLabel;
    private Label avatarScoreLabel;
    private Label message;
    private iGameControllerProperties game = new GameController();
    iGraphControllerProperties screen = new GraphController();

    public void criarAvatar(){
        Image avatarImagem = new Image(String.valueOf(getClass().getResource("/assets/characters/heroes/Aang.png")));
        this.boardCharacters[1][1] = new ImageView(avatarImagem);
        this.boardCharacters[1][1].setX(35); //anda 150 horizontalmente
        this.boardCharacters[1][1].setY(10); //anda 100 verticalmente
        this.avatar = boardCharacters[1][1];
    }

    public void criarAvatarLife(){
        this.avatarLife = new ProgressBar(1.0F);
        this.avatarLife.setStyle("-fx-accent: red");
        this.avatarLife.setMaxWidth(100);
        this.avatarLife.setTranslateX(100);
        this.avatarLife.setTranslateY(100);

        String text = "Vida - " + (int)(this.avatarLife.getProgress()*100) + "%";
        this.avatarLifeLabel = label(text, 105, 75);
        this.avatarLifeLabel.setFont(new Font("Inter", 18));
    }

    public void criarAvatarScore(){
        this.avatarScore = new ProgressBar(0.6F);
        this.avatarScore.setStyle("-fx-accent: blue");
        this.avatarScore.setMaxWidth(100);
        this.avatarScore.setTranslateX(100);
        this.avatarScore.setTranslateY(175);

        String text = "Estado Avatar - " + (int)(this.avatarScore.getProgress()*100) + "%";
        avatarScoreLabel = label(text, 75, 150);
        avatarScoreLabel.setFont(new Font("Inter", 18));
    }

    public Group avatarInfo(){
        criarAvatarLife();
        criarAvatarScore();
        Rectangle fundo = new Rectangle(300, 600, Color.GRAY);

        Group info = new Group(this.avatarLife, this.avatarScore, this.avatarLifeLabel, this.avatarScoreLabel);

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

        fillBoard(board);

        board.minWidth(900);
        board.minHeight(600);

        return board;
    }

    public ImageView[][] fillBoard(Group group) {
        this.game.play("src/assets/maps/level1/mapa.csv");
        ImageView[][] characters = new ImageView[6][6];

        boolean keep = false;
        for(int i = 0; i < game.getBoard().getBoardHeight(); i++){
            for(int j = 0; j < game.getBoard().getBoardWidth(); j++){
                if(keep){
                    if(game.getBoard().getBoard().getBoard()[i][j].getCharacter() != null){
                        characters[i][j] = new ImageView(new Image(game.getBoard().getBoard().getBoard()[i][j].getCharacter().getCharacter()));
                        if(game.getBoard().getBoard().getBoard()[i][j].getCharacter() instanceof Villans){
                            characters[i][j].setX(30+150*(j));
                            characters[i][j].setY(5+100*(i));
                        }
                        else{
                            characters[i][j].setX(35+150*(j));
                            characters[i][j].setY(10+100*(i));
                        }
                        group.getChildren().addAll(characters[i][j]);
                    }
                }
                keep = true;
            }
        }

        return characters;
    }

    public Scene boardScreen(){
        criarAvatar();

        String screenName = "Fase - " + game.getBoard().getBoard().getLevel();
        Group root = new Group(board(), this.avatar, avatarInfo());
        Scene cena = new Scene(root, 1200, 600);
        cena.setOnKeyPressed((new EventHandler<KeyEvent>() {
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

                int newLine = (int)(avatar.getY()/100);
                int newCollumn = (int)(avatar.getX()/150);

                if(game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter() != null){
                    if(game.getBoard().getBoard().getBoard()[newLine][newCollumn].getCharacter() instanceof Villans) {
                        message.setText("-5% de Vida\n" +
                                "Você não pode ficar aí, tem um sentinela do fogo!");
                        avatarLife.setProgress(avatarLife.getProgress()-0.05F);
                        avatarLifeLabel.setText("Vida - " + (int)(avatarLife.getProgress()*100) + "%");
                    }
                    else{
                        if(game.getBoard().getBoard().getLevel() == 1 && newLine != game.getBoard().getBoardHeight() - 1 && newCollumn != game.getBoard().getBoardWidth()
                                && newLine != 0 && newCollumn != 0){
                            message.setText("+25% de Vida\n" +
                                    "Você encontrou a Katara e o Sokka!");
                            avatarLife.setProgress(avatarLife.getProgress()+0.25F);
                            avatarLifeLabel.setText("Vida - " + (int)(avatarLife.getProgress()*100) + "%");
                        }
                        else if(newLine == game.getBoard().getBoardHeight() - 1 && newCollumn == game.getBoard().getBoardWidth() - 1){
                            screen.getStage().setScene(new FightScreenController().fightScreen());
                        }
                    }
                }
            }
        }));
        return cena;
    }
}