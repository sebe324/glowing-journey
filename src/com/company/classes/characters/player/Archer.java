package com.company.classes.characters.player;

import com.company.classes.characters.BaseCharacter;

import static com.company.enums.DamageRange.CLOSE_RANGE;
import static com.company.enums.DamageRange.LONG_RANGE;
import static com.company.enums.DamageType.PHYSICAL;

public class Archer extends BasePlayer {
    public Archer(int x, int y, String name, int attackDmg, int maxHp, int hp, int maxMana, int mana, int hpRegen, int upKey, int downKey, int leftKey, int rightKey, int leftAttackKey, int rightAttackKey){
        super(x,y,name, upKey, downKey, leftKey, rightKey, leftAttackKey, rightAttackKey);
        this.setAttackDmg(attackDmg);
        this.setMaxHp(maxHp);
        this.setHp(hp);
        this.setMaxMana(maxMana);
        this.setMana(mana);
        this.setHpRegen(hpRegen);
        this.setDamageRange(LONG_RANGE);
        this.setDamageType(PHYSICAL);
        this.uploadImage("images/archer/archer.png", "images/archer/archerLeftAttack.png", "images/archer/archerRightAttack.png");
    }
}
