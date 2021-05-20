package mc322.lab06.componentes;

public class Heroi extends Componente{
    private int score;
    private boolean flechaEquipada;
    private boolean flechaUsada;
    private boolean ouroColetado;
    private boolean wumpusMorto;

    public Heroi(String preenchimento, int linha, int coluna){
        super(preenchimento, linha, coluna);
        this.flechaEquipada = false;
        this.flechaUsada = false;
        this.ouroColetado = false;
        this.score = 0;
        this.wumpusMorto = false;
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

    public void setOuroColetado(boolean ouroColetado){
        this.ouroColetado = ouroColetado;
    }

    public boolean getOuroColetado(){
        return this.ouroColetado;
    }

    public void setWumpusMorto(boolean wumpusMorto){
        this.wumpusMorto = wumpusMorto;
    }

    public boolean getWumpusMorto(){
        return this.wumpusMorto;
    }
}
