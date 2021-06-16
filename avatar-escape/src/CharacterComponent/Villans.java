package CharacterComponent;

public class Villans extends Character{
    private int scoreVida;
    private int dano;

    public Villans(String character, int linha, int coluna){
        super(character, linha, coluna);
        this.scoreVida = 100;
        this.dano = 0;
    }

    // dano = nº aleatório / level
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

    public int getScoreVida(){
        return this.scoreVida;
    }

    public void addScoreVida(int scoreVida){
        this.scoreVida += scoreVida;
    }
}
