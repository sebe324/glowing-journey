package com.company.classes.characters.player;

import com.company.game.GameMap;

import static com.company.enums.DamageType.PHYSICAL;


public class Warrior extends BasePlayer {
    public Warrior(int x, int y, java.lang.String name, int attackDmg, int maxHp, int hp, int maxMana, int mana, int hpRegen, int manaRegen, int points, int lives, GameMap gameMap) {
        super(x,y,name, gameMap);
        this.setAttackDmg(attackDmg);
        this.setMaxHp(maxHp);
        this.setHp(hp);
        this.setMaxMana(maxMana);
        this.setMana(mana);
        this.setHpRegen(hpRegen);
        this.setManaRegen(manaRegen);
        this.setDamageRange(1);
        this.setPoints(points);
        this.setLives(lives);
        this.setDamageType(PHYSICAL);
        this.uploadImage("images/warrior/warrior.png", "images/warrior/warriorLeftAttack.png", "images/warrior/warriorRightAttack.png");
    }

    @Override
    public void abilityOne() {
        if (getMana() >= 50) {
            attackPlayer(getX(), getY() + 2);
            attackPlayer(getX(), getY() - 2);
            attackPlayer(getX() + 2, getY());
            attackPlayer(getX() - 2, getY());
            loseMana(50);
        }
    }

    @Override
    public void abilityTwo(){
        if(getMana()>=100) {
            setAttackDmg(getAttackDmg() + 10);
            loseHp(50);
            loseMana(100);
        }
    }
}
