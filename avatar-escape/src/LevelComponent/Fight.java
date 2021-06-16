package LevelComponent;

import CharacterComponent.*;

import java.util.Locale;
import java.util.Random;

public class Fight extends Level{
    public Fight(int level){
        super(level, false);
    }

    public void update(Aang avatar, Villans villan, String movement){
        movement.toLowerCase();
        switch (movement){
            case "a": //air
            case "f": //fire
                villan.addScoreVida(-10);
                break;
            case "e": //earth
            case "w": //water
                avatar.addScoreVida(10);
                break;
        }
    }

    public boolean update(Aang avatar, Villans villan){
        //true attack and false, defend
        Random movementVillan = new Random();
        boolean result = movementVillan.nextBoolean();

        if(result)
            avatar.addScoreVida(-10);
        else
            villan.addScoreVida(10);

        return result;
    }

    public int fightContinues(Aang avatar, Villans villan){
        if(avatar.getScoreVida() > 0 && villan.getScoreVida() > 0)
            return 0;
        else if(avatar.getScoreVida() <= 0)
            return 1;
        else //villan.life <= 0
            return 2;
    }
}
