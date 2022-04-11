package com.company.classes.characters.player;

import com.company.game.GameMap;

import static com.company.enums.DamageRange.CLOSE_RANGE;
import static com.company.enums.DamageType.PHYSICAL;


public class Warrior extends BasePlayer {
    public Warrior(int x, int y, String name, int attackDmg, int maxHp, int hp, int maxMana, int mana, int hpRegen, GameMap gameMap) {
        super(x,y,name, gameMap);
        this.setAttackDmg(attackDmg);
        this.setMaxHp(maxHp);
        this.setHp(hp);
        this.setMaxMana(maxMana);
        this.setMana(mana);
        this.setHpRegen(hpRegen);
        this.setDamageRange(CLOSE_RANGE);
        this.setDamageType(PHYSICAL);
        this.uploadImage("images/warrior/warrior.png", "images/warrior/warriorLeftAttacj.png", "images/warrior/warriorRightAttack.png");
    }

    public Warrior() {
    }

    public void abilityOne(int manaCost){

    }
    public void abilityTwo(int manaCost){

    }
    public void abilityThree(int manaCost){

    }
}
