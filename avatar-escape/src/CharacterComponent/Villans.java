package CharacterComponent;

public class Villans extends Character{
    public Villans(String character, int line, int collumn, int score, int life){
        super(character, line, collumn, score, life);
    }

    // life = nº aleatório / level
    public int ataque(int life){
        if (life == 0){
            this.addLife(-5);
        } else if (life == 1){
            this.addLife(-10);
        } else if (life == 2){
            this.addLife(-15);
        } else if (life == 3){
            this.addLife(-20);
        } else if (life == 4){
            this.addLife(-25);
        } else if (life == 5){
            this.addLife(-30);
        }
        return this.getLife();
    }
}
