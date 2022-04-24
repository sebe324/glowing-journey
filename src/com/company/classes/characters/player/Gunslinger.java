package com.company.classes.characters.player;

import com.company.game.GameMap;

import javax.swing.*;

import static com.company.enums.DamageType.PHYSICAL;

public class Gunslinger extends BasePlayer {
    public Gunslinger(int x, int y, java.lang.String name, int attackDmg, int maxHp, int hp, int maxMana, int mana, int hpRegen, int manaRegen, int points, int lives, GameMap gameMap){
        super(x,y, name, gameMap);
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
        this.setDamageType(PHYSICAL);
        this.uploadImage("images/gunslinger/gunslinger.png", "images/gunslinger/gunslingerLeftAttack.png", "images/gunslinger/gunslingerRightAttack.png");
        this.setDescription("Some poeple say that guns are a weapon that doesn't require skill. They couldn't be more wrong. Gunslinger is a master of his craft and he never misses a shot.");
        this.setAbilityOneDescription("Camoflague: Gunslinger becomes invisible to his enemies.");
        this.setAbilityTwoDescription("Far Shot: Gunslinger shoots 3 far shots to the right side.");
    }
    public Gunslinger(int x, int y, String name, GameMap gameMap){
        super(x,y, name, gameMap);
        this.setAttackDmg(80);
        this.setMaxHp(1000);
        this.setHp(1000);
        this.setMaxMana(300);
        this.setMana(300);
        this.setHpRegen(10);
        this.setManaRegen(5);
        this.setPoints(0);
        this.setLives(3);
        this.setDamageRange(5);
        this.setDamageType(PHYSICAL);
        this.uploadImage("images/gunslinger/gunslinger.png", "images/gunslinger/gunslingerLeftAttack.png", "images/gunslinger/gunslingerRightAttack.png");
        this.setDescription("Some poeple say that guns are a weapon that doesn't require skill. They couldn't be more wrong. Gunslinger is a master of his craft and he never misses a shot.");
        this.setAbilityOneDescription("Camoflague: Gunslinger becomes invisible to his enemies.");
        this.setAbilityTwoDescription("Far Shot: Gunslinger shoots 3 far shots to the right side.");
        this.setAbilityOneImage("images/gunslinger/abilityOne.png");
        this.setAbilityTwoImage("images/gunslinger/abilityTwo.png");
    }
    @Override
    public void abilityOne(){
    if(getMana()>=50){
        if(!isInvisible()) {
            setInvisible(true);
            setBaseImage(new ImageIcon("").getImage());
            setBaseImageToImage();
        }
        else{
            setInvisible(false);
            setBaseImage(new ImageIcon("images/gunslinger/gunslinger.png").getImage());
            setBaseImageToImage();
        }
        loseMana(50);
    }
    }

    @Override
    public void abilityTwo(){
    if(getMana()>=100){
        attackPlayer(getX()+8,getY()+1);
        attackPlayer(getX()+8,getY());
        attackPlayer(getX()+8,getY()-1);
        loseMana(100);
    }
    }
}
