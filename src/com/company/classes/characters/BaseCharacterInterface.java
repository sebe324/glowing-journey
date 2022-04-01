package com.company.classes.characters;

import com.company.classes.Something;

public interface BaseCharacterInterface {
    void attack(Something thing);
void regenerateHp(int amount);
void regenerateMana(int amount);
void loseMana(int amount);
void levelUp();
void info();
}
