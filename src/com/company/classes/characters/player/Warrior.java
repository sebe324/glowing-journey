package com.company.classes.characters.player;

import com.company.game.GameMap;

import static com.company.enums.DamageType.PHYSICAL;


public class Warrior extends BasePlayer {
    public Warrior(int x, int y, java.lang.String name, int attackDmg, int maxHp, int hp, int maxMana, int mana, int hpRegen, int manaRegen, GameMap gameMap) {
        super(x,y,name, gameMap);
        this.setAttackDmg(attackDmg);
        this.setMaxHp(maxHp);
        this.setHp(hp);
        this.setMaxMana(maxMana);
        this.setMana(mana);
        this.setHpRegen(hpRegen);
        this.setManaRegen(manaRegen);
        this.setDamageRange(1);
        this.setDamageType(PHYSICAL);
        this.uploadImage("images/warrior/warrior.png", "images/warrior/warriorLeftAttacj.png", "images/warrior/warriorRightAttack.png");
    }

    public void abilityOne() {
        if (getMana() >= 50) {
            attack(getX(), getY() + 2);
            attack(getX(), getY() - 2);
            attack(getX() + 2, getY());
            attack(getX() - 2, getY());
            loseMana(50);
        }
    }
    public void abilityTwo(){
        if(getMana()>=100) {
            setAttackDmg(getAttackDmg() + 10);
            loseHp(50);
            loseMana(100);
        }
    }
}
