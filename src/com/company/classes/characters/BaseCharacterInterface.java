package com.company.classes.characters;

public interface BaseCharacterInterface {
    void attack(int directionX, int directionY);
void regenerateHp(int amount);
void regenerateMana(int amount);
void loseMana(int amount);
void levelUp();
void info();
}
