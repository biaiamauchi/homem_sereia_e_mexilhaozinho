package CharacterComponent;

public class Villans extends Character{
    public Villans(String character, int linha, int coluna, int dano){
        super(character, linha, coluna);
        this.scoreVida = 100;
        this.dano = dano;
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
        } else {
            this.dano = -30;
        }
        return this.dano;
    }

    public int getScoreVida(){
        return this.scoreVida;
    }

    public void addScoreVida(int scoreVida){
        this.scoreVida += scoreVida; 
    }
}
