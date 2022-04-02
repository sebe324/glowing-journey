package com.company.classes.characters.player;

import com.company.classes.characters.BaseCharacter;
import static com.company.enums.DamageRange.LONG_RANGE;
import static com.company.enums.DamageType.MAGIC;

public class Wizard extends BasePlayer{
    public Wizard(int x, int y, String name, int upKey, int downKey, int leftKey, int rightKey, int leftAttackKey, int rightAttackKey){
        super(x,y,name, upKey, downKey, leftKey, rightKey, leftAttackKey, rightAttackKey);
        this.setAttackDmg(120);
        this.setMaxHp(750);
        this.setHp(750);
        this.setMaxMana(400);
        this.setMana(400);
        this.setHpRegen(5);
        this.setDamageRange(LONG_RANGE);
        this.setDamageType(MAGIC);
        this.uploadImage("images/wizard/wizard.png", "images/wizard/wizardLeftAttack.png", "images/wizard/wizardRightAttack.png");
    }
    public Wizard(){}
    public void abilityOne(int manaCost){

    }
    public void abilityTwo(int manaCost){

    }
    public void abilityThree(int manaCost){

    }
}
