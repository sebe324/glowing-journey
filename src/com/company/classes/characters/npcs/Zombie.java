package com.company.classes.characters.npcs;

import com.company.game.GameMap;

import static com.company.enums.DamageType.PHYSICAL;

public class Zombie extends BaseMonster {

    public Zombie(int x, int y, java.lang.String name, int level, GameMap gameMap) {
        super(x, y, name, 4, gameMap);
        this.setAttackDmg((int)(50*level*0.2+50));
        this.setMaxHp((int)(200*level*0.2+200));
        this.setHp((int)(200*level*0.2+200));
        this.setHpRegen((int)(5*level*0.2+200));
        this.setLevel(level);
        this.setDamageRange(1);
        this.setDamageType(PHYSICAL);
        this.uploadImage("images/npcs/monsters/zombie.png", "images/npcs/monsters/zombie.png", "images/npcs/monsters/zombie.png");
    }

}
