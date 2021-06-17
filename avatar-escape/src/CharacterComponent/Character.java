package CharacterComponent;

public class Character implements iCharacterProperties{
    private String character;
    private int line;
    private int collumn;
    private int score;
    private int life;

    public Character(String character, int line, int collumn, int score, int life){
        this.line = line;
        this.collumn = collumn;
        this.character = character;
        this.score = score;
        this.life = life;
    }

    public String getCharacter(){
        return character;
    }

    public int getLine(){
        return line;
    }

    public int getCollumn(){
        return collumn;
    }

    public void setCharacter(String character){
        this.character = character;
    }

    public void setLine(int line){
        this.line = line;
    }

    public void setCollumn(int collumn){
        this.collumn = collumn;
    }

    public void setScore(int score){ this.score = score; }

    public int getScore(){ return this.score; }

    public void setLife(int life){ this.life = life; }

    public int getLife(){ return this.life; }

    public void addScore(int score) { this.score += score; }

    public void addLife(int life) { this.life += life; }
}
