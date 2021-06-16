package CharacterComponent;

public class Aang extends Character{
    private int scoreVida;
    private int scoreEstadoAvatar;
    private int dano;
    private int cura;
    private boolean proximaFase;
    private boolean venceVilao;
    private boolean achaAppa;

    public Aang(String character, int linha, int coluna){
        super(character, linha, coluna);
        this.scoreVida = 100;
        this.scoreEstadoAvatar = 0;
        this.dano = 0;
        this.cura = 0;
        this.proximaFase = false;
        this.venceVilao = false;
        this.achaAppa = false;
    }

    public int ataque(int dano){
        if (dano == 0){
            this.dano = -5;
        } else if (dano == 1){
            this.dano = -10;
        } else if (dano == 2){
            this.dano = -15;
        } else if (dano == 3){
            this.dano = -20;
        } else if (dano == 4){
            this.dano = -25;
        } else if (dano == 5){
            this.dano = -30;
        }
        return this.dano;
    }

    public int defesa(int cura){
        if (cura == 0){
            this.cura = 10;
        } else if (cura == 1){
            this.cura = 15;
        }
        return this.cura;
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
