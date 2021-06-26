package CharacterComponent;

import javafx.scene.image.ImageView;

public interface iCharacterProperties {
    public String getCharacter();

    public String getImageSource();

    public int getLine();

    public int getCollumn();

    public void setCharacter(String character);

    public void setLine(int line);

    public void setCollumn(int collumn);

    public void setScore(int score);

    public int getScore();

    public void setLife(int life);

    public int getLife();

    public void addScore(int score);

    public void addLife(int life);
}