package com.company.classes.characters.npcs;

import com.company.classes.characters.BaseCharacter;
import com.company.enums.ClassType;

public abstract class BaseMonster extends BaseCharacter implements BaseMonsterInterface{
    public BaseMonster(int x, int y, String name) {
        super(x, y, name, ClassType.MONSTER);
    }
}
