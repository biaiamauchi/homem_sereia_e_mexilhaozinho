package GraphControllerComponent.BoardScreen;

import CharacterComponent.Villains;
import GraphControllerComponent.iGraphControllerProperties;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class BoardScreenDesigner {
    private iGraphControllerProperties screen;

    public Group groupScene(iGraphControllerProperties screen,
                            ImageView boardCharacters[][], ImageView avatar,
                            ProgressBar avatarLife, Label avatarLifeLabel,
                            ProgressBar avatarScore, Label avatarScoreLabel,
                            Label message){

        this.screen = screen;
        criarAvatar(boardCharacters, avatar);
        return new Group(board(boardCharacters), avatar, avatarInfo(avatarLife, avatarLifeLabel, avatarScore, avatarScoreLabel, message));

    }

    private void criarAvatar(ImageView boardCharacters[][], ImageView avatar){
        Image avatarImagem = new Image(String.valueOf(getClass().getResource("/assets/characters/heroes/Aang.png")));
        boardCharacters[0][0] = new ImageView(avatarImagem);

        avatar.setX(35); //anda 150 horizontalmente
        avatar.setY(10); //anda 100 verticalmente
        avatar.setImage(avatarImagem);
    }

    private void criarAvatarLife(ProgressBar avatarLife, Label avatarLifeLabel){
        avatarLife.setProgress((double)screen.getGame().getAvatar().getLife()/100);
        avatarLife.setStyle("-fx-accent: red");
        avatarLife.setMaxWidth(100);
        avatarLife.setTranslateX(100);
        avatarLife.setTranslateY(100);

        String text = "Vida - " + (int)(avatarLife.getProgress()*100) + "%";
        avatarLifeLabel.setText(text);
        avatarLifeLabel.setTranslateX(105);
        avatarLifeLabel.setTranslateY(75);
        avatarLifeLabel.setFont(new Font("Inter", 18));
    }

    private void criarAvatarScore(ProgressBar avatarScore, Label avatarScoreLabel){
        avatarScore.setProgress((double)screen.getGame().getAvatar().getScore()/100);
        avatarScore.setStyle("-fx-accent: blue");
        avatarScore.setMaxWidth(100);
        avatarScore.setTranslateX(100);
        avatarScore.setTranslateY(175);

        String text = "Estado Avatar - " + (int)(avatarScore.getProgress()*100) + "%";
        avatarScoreLabel.setText(text);
        avatarScoreLabel.setTranslateX(75);
        avatarScoreLabel.setTranslateY(150);
        avatarScoreLabel.setFont(new Font("Inter", 18));
    }

    private Group avatarInfo(ProgressBar avatarLife, Label avatarLifeLabel, ProgressBar avatarScore, Label avatarScoreLabel, Label message){
        criarAvatarLife(avatarLife, avatarLifeLabel);
        criarAvatarScore(avatarScore, avatarScoreLabel);

        Rectangle fundo = new Rectangle(300, 600, Color.GRAY);

        Group info = new Group(avatarLife, avatarScore, avatarLifeLabel, avatarScoreLabel);

        message.setText("");
        message.setTranslateX(50);
        message.setTranslateY(300);
        message.setFont(new Font("Inter", 16));
        message.setTextAlignment(TextAlignment.CENTER);
        message.setWrapText(true);
        message.setMaxWidth(200);

        Group screenInfo = new Group(fundo, info, message);
        screenInfo.setTranslateX(900);

        return screenInfo;
    }

    private Group board(ImageView boardCharacters[][]){
        Image background = new Image(String.valueOf(getClass().getResource("/assets/background/boardBackground.png")));
        ImageView backgroundView = new ImageView(background);

        Image grid = new Image(String.valueOf(getClass().getResource("/assets/background/boardGrid.png")));
        ImageView gridView = new ImageView(grid);

        Group board = new Group(backgroundView, gridView);

        fillBoard(board, boardCharacters);

        board.minWidth(900);
        board.minHeight(600);

        return board;
    }

    private void fillBoard(Group group, ImageView boardCharacters[][]) {
        boolean keep = false;
        for(int i = 0; i < screen.getGame().getBoard().getBoardHeight(); i++){
            for(int j = 0; j < screen.getGame().getBoard().getBoardWidth(); j++){
                if(keep){
                    if(screen.getGame().getBoard().getBoard().getBoard()[i][j].getCharacter() != null){
                        boardCharacters[i][j] = new ImageView(new Image(screen.getGame().getBoard().getBoard().getBoard()[i][j].getCharacter().getImageSource()));

                        if(screen.getGame().getBoard().getBoard().getBoard()[i][j].getCharacter() instanceof Villains){
                            boardCharacters[i][j].setX(30+150*(j));
                            boardCharacters[i][j].setY(5+100*(i));

                            Timer timer = new Timer(boardCharacters[i][j]);
                            timer.start();
                        }
                        else{
                            boardCharacters[i][j].setX(35+150*(j));
                            boardCharacters[i][j].setY(10+100*(i));
                        }
                        group.getChildren().addAll(boardCharacters[i][j]);
                    }
                }
                keep = true;
            }
        }
    }

}
