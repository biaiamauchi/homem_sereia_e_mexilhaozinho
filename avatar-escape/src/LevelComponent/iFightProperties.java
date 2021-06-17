package LevelComponent;

import CharacterComponent.iCharacterProperties;

public interface iFightProperties {
    public int getLevel();
    public void setLevel(int level);

    public void update(iCharacterProperties avatar, iCharacterProperties villan, String movement);
    public boolean update(iCharacterProperties avatar, iCharacterProperties villan);
    public int fightContinues(iCharacterProperties avatar, iCharacterProperties villan);
}
