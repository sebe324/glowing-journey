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
