package CharacterComponent;

public class Heroes extends Character{
    private int scoreEstadoAvatar;
    private int cura;

    public Heroes(String character, int linha, int coluna, int scoreEstadoAvatar, int cura){
        super(character, linha, coluna);
        this.scoreEstadoAvatar = scoreEstadoAvatar;
        this.cura = cura;
    }

    public int getCura(){
        return this.cura;
    }

    public int getScoreEstadoAvatar(){
        return this.scoreEstadoAvatar;
    }
}
