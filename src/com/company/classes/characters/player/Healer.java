package com.company.classes.characters.player;

import com.company.classes.GameObj;
import com.company.classes.particles.Particle;
import com.company.game.GameMap;

import static com.company.enums.DamageType.MAGIC;

public class Healer extends BasePlayer {
    public Healer(int x, int y, java.lang.String name, int attackDmg, int maxHp, int hp, int maxMana, int mana, int hpRegen, int manaRegen, int points, int lives, GameMap gameMap){
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
        this.setDamageType(MAGIC);
        this.uploadImage("images/healer/healer.png", "images/healer/healerLeftAttack.png", "images/healer/healerRightAttack.png");
    }
    public void abilityOne(){
        if(getMana()>=50){
            setHp(getHp()+100);
            loseMana(50);
        }
    }
    public void abilityTwo(){
        if(getMana()>=100) {
            for (int i = 0; i < 3; i++) {
                if (getY() - 1 + i >= 0 && getY() - 1 + i < 20) {
                    for (int j = 0; j < 3; j++) {
                        if (getX() - 1 + j >= 0 && getX() - 1 + j < 36) {
                            if (gameMap.occupiedCells[getX() - 1 + j][getY() - 1 + i] != 0) {
                                attackPlayer(getX() - 1 + j, getY() - 1 + i);
                                setHp(getHp() + (getAttackDmg() / 2));
                            }
                        }
                    }
                }
            }
            loseMana(100);
        }
    }
}
