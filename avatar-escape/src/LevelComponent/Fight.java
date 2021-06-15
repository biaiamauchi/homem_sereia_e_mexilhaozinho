package LevelComponent;

import java.util.Locale;
import java.util.Random;

public class Fight extends Level{
    public Fight(int level){
        super(level, false);
    }

    public void update(Character avatar, Character villan, String movement){
        movement.toLowerCase();
        switch (movement){
            case 'a': //air
                villan.life -= 10;
                break;
            case 'e': //earth
                avatar.life += 10;
                break;
            case 'w': //water
                avatar.life += 10;
                break;
            case 'f': //fire
                villan.life -= 10;
        }
    }

    public boolean update(Character avatar, Character villan){
        //true attack and false, defend
        Random movementVillan = new Random();
        boolean result = movementVillan.nextBoolean();

        if(result)
            avatar.life -= 10;
        else
            villan.life += 10;

        return result;
    }

    public int fightContinues(Character avatar, Character villan){
        if(avatar.life > 0 && villan.life > 0)
            return 0;
        else if(avatar.life <= 0)
            return 1;
        else //villan.life <= 0
            return 2;
    }
}
