package com.company.classes.characters.player;

import com.company.classes.characters.BaseCharacter;

import static com.company.enums.DamageRange.CLOSE_RANGE;
import static com.company.enums.DamageType.PHYSICAL;

public class Archer extends BaseCharacter {
    public Archer(int x, int y, String name){
        super(x,y,name);
        this.setAttackDmg(100);
        this.setMaxHp(1000);
        this.setHp(1000);
        this.setMaxMana(200);
        this.setMana(200);
        this.setDamageRange(CLOSE_RANGE);
        this.setDamageType(PHYSICAL);
        this.uploadImage("ArcherStand.png", "ArcherAttackLeft.png", "ArcherAttackRight.png");
    }
}
