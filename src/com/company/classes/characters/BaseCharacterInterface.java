package com.company.classes.characters;

public interface BaseCharacterInterface {
    void attack(BaseCharacter attackedCharacter);
void regenerateHp(int amount);
void loseHealth(int amount);
void regenerateMana(int amount);
void loseMana(int amount);
void levelUp();
void info();
}
