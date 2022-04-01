package com.company.classes.characters;

import com.company.classes.Something;

public interface BaseCharacterInterface {
    void attack(String direction);
void regenerateHp(int amount);
void regenerateMana(int amount);
void loseMana(int amount);
void levelUp();
void info();
}
