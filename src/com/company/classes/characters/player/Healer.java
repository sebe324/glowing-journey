package com.company.classes.characters.player;

import com.company.classes.characters.BaseCharacter;

import static com.company.enums.DamageRange.CLOSE_RANGE;
import static com.company.enums.DamageType.MAGIC;

public class Healer extends BasePlayer {
    public Healer(int x, int y, String name, int upKey, int downKey, int leftKey, int rightKey, int leftAttackKey, int rightAttackKey){
        super(x,y,name, upKey, downKey, leftKey, rightKey, leftAttackKey, rightAttackKey);
        this.setAttackDmg(100);
        this.setMaxHp(1000);
        this.setHp(1000);
        this.setMaxMana(200);
        this.setMana(200);
        this.setHpRegen(5);
        this.setDamageRange(CLOSE_RANGE);
        this.setDamageType(MAGIC);
        this.uploadImage("images/healer/healer.png", "images/healer/healerLeftAttack.png", "images/healer/healerRightAttack.png");
    }
}
