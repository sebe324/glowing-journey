package com.company.classes.characters.player;

import com.company.game.GameMap;

import java.util.Random;

import static com.company.enums.DamageType.MAGIC;

public class Wizard extends BasePlayer{
    public Wizard(int x, int y, java.lang.String name, int attackDmg, int maxHp, int hp, int maxMana, int mana, int hpRegen, int manaRegen, GameMap gameMap){
        super(x,y,name, gameMap);
        this.setAttackDmg(attackDmg);
        this.setMaxHp(maxHp);
        this.setHp(hp);
        this.setMaxMana(maxMana);
        this.setMana(mana);
        this.setHpRegen(hpRegen);
        this.setManaRegen(manaRegen);
        this.setDamageRange(4);
        this.setDamageType(MAGIC);
        this.uploadImage("images/wizard/wizard.png", "images/wizard/wizardLeftAttack.png", "images/wizard/wizardRightAttack.png");
    }
    public Wizard(){}
    public void abilityOne(){
        if(getMana()>=50) {
            Random randomX = new Random();
            Random randomY = new Random();
            tryChangePosition(randomX.nextInt(35 + 1) + 1, randomY.nextInt(19 + 1) + 1);
            loseMana(50);
        }
    }
    public void abilityTwo() {
        if (getMana() >= 100) {
            Random randomX = new Random();
            gameMap.gameObjs.get(randomX.nextInt(gameMap.gameObjs.size())).loseHp(getAttackDmg() * 3);
            loseMana(100);
        }
    }
}
