package CharacterComponent;

public class Aang extends Character{
    private boolean proximaFase;
    private boolean venceVilao;
    private boolean achaAppa;

    public Aang(String character, int line, int collumn, int score, int life){
        super(character, line, collumn, score, life);
        this.proximaFase = false;
        this.venceVilao = false;
        this.achaAppa = false;
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
