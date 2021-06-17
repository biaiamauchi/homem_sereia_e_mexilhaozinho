package LevelComponent;

import CharacterComponent.*;

import java.util.Random;

public class Fight implements iFightProperties {
    private int level;

    public Fight(int level){
        this.level = level;
    }

    public void update(iCharacterProperties avatar, iCharacterProperties villan, String movement){
        movement.toLowerCase();
        switch (movement){
            case "a": //air
            case "f": //fire
                villan.addLife(-10);
                break;
            case "e": //earth
            case "w": //water
                avatar.addLife(10);
                break;
        }
    }

    public boolean update(iCharacterProperties avatar, iCharacterProperties villan){
        //true attack and false, defend
        Random movementVillan = new Random();
        boolean result = movementVillan.nextBoolean();

        if(result)
            avatar.addLife(-10);
        else
            villan.addLife(10);

        return result;
    }

    public int fightContinues(iCharacterProperties avatar, iCharacterProperties villan){
        if(avatar.getLife() > 0 && villan.getLife() > 0)
            return 0;
        else if(avatar.getLife() <= 0)
            return 1;
        else //villan.life <= 0
            return 2;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }
}
