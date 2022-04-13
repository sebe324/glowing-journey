package com.company.classes.characters.npcs;

import com.company.game.GameMap;

import static com.company.enums.DamageType.MAGIC;

public class Necromancer extends BaseMonster{
    public Necromancer(int x, int y, java.lang.String name, int level, GameMap gameMap) {
        super(x, y, name, 8, gameMap);
        this.setAttackDmg((int)(50*level*0.2+50));
        this.setMaxHp((int)(200*level*0.2+200));
        this.setHp((int)(200*level*0.2+200));
        this.setHpRegen((int)(5*level*0.2+200));
        this.setLevel(level);
        this.setDamageRange(4);
        this.setDamageType(MAGIC);
        this.uploadImage("images/npcs/monsters/necromancer.png", "images/npcs/monsters/necromancer.png", "images/npcs/monsters/necromancer.png");
    }
}
