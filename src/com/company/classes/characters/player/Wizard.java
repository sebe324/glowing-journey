package com.company.classes.characters.player;

import com.company.game.GameMap;

import static com.company.enums.DamageRange.LONG_RANGE;
import static com.company.enums.DamageType.MAGIC;

public class Wizard extends BasePlayer{
    public Wizard(int x, int y, java.lang.String name, int attackDmg, int maxHp, int hp, int maxMana, int mana, int hpRegen, GameMap gameMap){
        super(x,y,name, gameMap);
        this.setAttackDmg(attackDmg);
        this.setMaxHp(maxHp);
        this.setHp(hp);
        this.setMaxMana(maxMana);
        this.setMana(mana);
        this.setHpRegen(hpRegen);
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
