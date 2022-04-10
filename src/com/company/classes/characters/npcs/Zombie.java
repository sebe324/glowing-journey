package com.company.classes.characters.npcs;

import com.company.classes.characters.BaseCharacter;
import com.company.enums.ClassType;

import static com.company.enums.DamageRange.CLOSE_RANGE;
import static com.company.enums.DamageType.PHYSICAL;

public class Zombie extends BaseMonster {

    public Zombie(int x, int y, String name, int level) {
        super(x, y, name, 4);
        this.setAttackDmg((int)(50*level*0.2+50));
        this.setMaxHp((int)(200*level*0.2+200));
        this.setHp((int)(200*level*0.2+200));
        this.setHpRegen((int)(5*level*0.2+200));
        this.setLevel(level);
        this.setDamageRange(CLOSE_RANGE);
        this.setDamageType(PHYSICAL);
        this.uploadImage("images/npcs/monsters/zombie.png", "images/npcs/monsters/zombie.png", "images/npcs/monsters/zombie.png");
    }

}
