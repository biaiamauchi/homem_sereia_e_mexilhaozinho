package CharacterComponent;

public class Aang extends Character{
    private int scoreVida;
    private int scoreEstadoAvatar;
    private boolean proximaFase;
    private boolean venceVilao;
    private boolean achaAppa;

    public Aang(String character, int linha, int coluna){
        super(character, linha, coluna);
        this.scoreVida = 100;
        this.scoreEstadoAvatar = 0;
        this.proximaFase = false;
        this.venceVilao = false;
        this.achaAppa = false;
    }

    public int getScoreVida() {
        return scoreVida;
    }

    public void addScoreVida(int scoreVida) {
        this.scoreVida += scoreVida;
    }

    public int getScoreEstadoAvatar(){
        return scoreEstadoAvatar;
    }

    public void addScoreEstadoAvatar(int scoreEstadoAvatar){
        this.scoreEstadoAvatar += scoreEstadoAvatar;
    }

    public boolean getProximaFase(){
        return this.proximaFase;
    }

    public void setProximaFase(boolean proximaFase){
        this.proximaFase = proximaFase;
    }

    public boolean getVenceVilao(){
        return this.venceVilao;
    }

    public void setVenceVilao(boolean venceVilao){
        this.venceVilao = venceVilao;
    }
    
    public boolean getAchaAppa(){
        return this.achaAppa;
    }

    public void setAchaAppa(boolean achaAppa){
        this.achaAppa = achaAppa;
    }
}
