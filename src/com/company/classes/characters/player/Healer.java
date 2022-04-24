package com.company.classes.characters.player;

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
        this.setDamageRange(2);
        this.setPoints(points);
        this.setLives(lives);
        this.setDamageType(MAGIC);
        this.uploadImage("images/healer/healer.png", "images/healer/healerLeftAttack.png", "images/healer/healerRightAttack.png");
        this.setDescription("The protector of the weak and a menace to the oppressors. He knows everything about nature, alchemy and healing. He's also a quite good fighter");
        this.setAbilityOneDescription("Heal: Healer heals himself for 100 hp.");
        this.setAbilityTwoDescription("Life steal: Healer steals life from all nearby enemies");
        this.setAbilityOneImage("images/healer/abilityOne.png");
        this.setAbilityTwoImage("images/healer/abilityTwo.png");
    }
    public Healer(int x,int y, String name, GameMap gameMap){
        super(x,y,name, gameMap);
        this.setAttackDmg(90);
        this.setMaxHp(1200);
        this.setHp(1200);
        this.setMaxMana(200);
        this.setMana(200);
        this.setHpRegen(15);
        this.setManaRegen(5);
        this.setDamageRange(2);
        this.setPoints(0);
        this.setLives(3);
        this.setDamageType(MAGIC);
        this.uploadImage("images/healer/healer.png", "images/healer/healerLeftAttack.png", "images/healer/healerRightAttack.png");
        this.setDescription("The protector of the weak and a menace to the oppressors. He knows everything about nature, alchemy and healing. He's also a quite good fighter");
        this.setAbilityOneDescription("Heal: Healer heals himself for 100 hp.");
        this.setAbilityTwoDescription("Life steal: Healer steals life from all nearby enemies");
        this.setAbilityOneImage("images/healer/abilityOne.png");
        this.setAbilityTwoImage("images/healer/abilityTwo.png");
    }
    @Override
    public void abilityOne(){
        if(getMana()>=50){
            setHp(getHp()+100);
            loseMana(50);
        }
    }

    @Override
    public void abilityTwo(){
        if(getMana()>=100) {
            for (int i = 0; i < 5; i++) {
                if (getY() - 1 + i >= 0 && getY() - 1 + i < 20) {
                    for (int j = 0; j < 5; j++) {
                        if ((getX() - 1 + j >= 0 && getX() - 1 + j < 36)&&(gameMap.occupiedCells[getX() - 1 + j][getY() - 1 + i] != 0)) {
                                attackPlayer(getX() - 1 + j, getY() - 1 + i);
                                setHp(getHp() + (getAttackDmg() / 2));
                        }
                    }
                }
            }
            loseMana(100);
        }
    }
}
