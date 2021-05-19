package mc322.lab06.componentes;

public class Heroi extends Componente{
    private int score;
    private boolean flechaEquipada;
    private boolean flechaUsada;

    public Heroi(String preenchimento, int linha, int coluna){
        super(preenchimento, linha, coluna);
        this.flechaEquipada = false;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public boolean getFlechaEquipada(){
        return this.flechaEquipada;
    }

    public void setFlechaEquipada(boolean flechaEquipada){
        this.flechaEquipada = flechaEquipada;
    }

    public boolean getFlechaUsada(){
        return this.flechaUsada;
    }

    public void setFlechaUsada(boolean flechaUsada){
        this.flechaUsada = flechaUsada;
    }
}
