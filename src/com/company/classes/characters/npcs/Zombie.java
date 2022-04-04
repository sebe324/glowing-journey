package com.company.classes.characters.npcs;

import com.company.classes.characters.BaseCharacter;
import com.company.enums.ClassType;

import static com.company.enums.DamageRange.CLOSE_RANGE;
import static com.company.enums.DamageType.PHYSICAL;

public class Zombie extends BaseMonster {

    public Zombie(int x, int y, String name) {
        super(x, y, name, 4);
        this.setAttackDmg(50);
        this.setMaxHp(200);
        this.setHp(200);
        this.setMaxMana(100);
        this.setMana(100);
        this.setHpRegen(5);
        this.setDamageRange(CLOSE_RANGE);
        this.setDamageType(PHYSICAL);
        this.uploadImage("images/npcs/monsters/zombie.png", "images/npcs/monsters/zombie.png", "images/npcs/monsters/zombie.png");
    }

}
