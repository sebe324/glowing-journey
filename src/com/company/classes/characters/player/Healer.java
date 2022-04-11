package com.company.classes.characters.player;

import com.company.game.GameMap;

import static com.company.enums.DamageRange.CLOSE_RANGE;
import static com.company.enums.DamageType.MAGIC;

public class Healer extends BasePlayer {
    public Healer(int x, int y, java.lang.String name, int attackDmg, int maxHp, int hp, int maxMana, int mana, int hpRegen, GameMap gameMap){
        super(x,y,name, gameMap);
        this.setAttackDmg(attackDmg);
        this.setMaxHp(maxHp);
        this.setHp(hp);
        this.setMaxMana(maxMana);
        this.setMana(mana);
        this.setHpRegen(hpRegen);
        this.setDamageRange(CLOSE_RANGE);
        this.setDamageType(MAGIC);
        this.uploadImage("images/healer/healer.png", "images/healer/healerLeftAttack.png", "images/healer/healerRightAttack.png");
    }
}
