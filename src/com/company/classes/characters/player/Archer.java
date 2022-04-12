package com.company.classes.characters.player;

import com.company.game.GameMap;
import static com.company.enums.DamageType.PHYSICAL;

public class Archer extends BasePlayer {
    private boolean invisible;
    public Archer(int x, int y, java.lang.String name, int attackDmg, int maxHp, int hp, int maxMana, int mana, int hpRegen, int manaRegen, GameMap gameMap){
        super(x,y, name, gameMap);
        this.setAttackDmg(attackDmg);
        this.setMaxHp(maxHp);
        this.setHp(hp);
        this.setMaxMana(maxMana);
        this.setMana(mana);
        this.setHpRegen(hpRegen);
        this.setManaRegen(manaRegen);
        this.setDamageRange(4);
        this.setDamageType(PHYSICAL);
        this.uploadImage("images/archer/archer.png", "images/archer/archerLeftAttack.png", "images/archer/archerRightAttack.png");
    }
    public void abilityOne(){
    if(getMana()>=50){
        if(!invisible) {
            invisible = true;
            this.uploadImage("", "", "");
        }
        else{
            invisible=false;
            this.uploadImage("images/archer/archer.png", "images/archer/archerLeftAttack.png", "images/archer/archerRightAttack.png");

        }
        loseMana(50);
    }
    }
    public void abilityTwo(){
    if(getMana()>=100){
        attack(getX()+8,getY()+1);
        attack(getX()+8,getY());
        attack(getX()+8,getY()-1);
        loseMana(100);
    }
    }
}
