package com.company.classes.characters.player;

import com.company.game.GameMap;

import java.util.Random;

import static com.company.enums.DamageType.MAGIC;

public class Wizard extends BasePlayer{
    Random rand=new Random();
    public Wizard(int x, int y, java.lang.String name, int attackDmg, int maxHp, int hp, int maxMana, int mana, int hpRegen, int manaRegen, int points, int lives, GameMap gameMap){
        super(x,y,name, gameMap);
        this.setAttackDmg(attackDmg);
        this.setMaxHp(maxHp);
        this.setHp(hp);
        this.setMaxMana(maxMana);
        this.setMana(mana);
        this.setHpRegen(hpRegen);
        this.setManaRegen(manaRegen);
        this.setDamageRange(4);
        this.setPoints(points);
        this.setLives(lives);
        this.setDamageType(MAGIC);
        this.uploadImage("images/wizard/wizard.png", "images/wizard/wizardLeftAttack.png", "images/wizard/wizardRightAttack.png");
    }

    @Override
    public void abilityOne(){
        if(getMana()>=50) {
            tryChangePosition(rand.nextInt(35 + 1) + 1, rand.nextInt(19 + 1) + 1);
            loseMana(50);
        }
    }

    @Override
    public void abilityTwo() {
        if (getMana() >= 100) {
            gameMap.getMonsters().get(rand.nextInt(gameMap.getMonsters().size())).loseHp(getAttackDmg() * 10);
            loseMana(100);
        }
    }
}
