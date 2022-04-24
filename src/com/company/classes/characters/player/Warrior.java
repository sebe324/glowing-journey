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
        this.setDescription("Olympic champion, and a fearsome warrior. He prefers strength over magic and new technologies.");
        this.setAbilityOneDescription("Dance of blades: Attacks all enemies around with more strength.");
        this.setAbilityTwoDescription("Rage: Increases attack damage by attacking himself.");
        this.setAbilityOneImage("images/warrior/abilityOne.png");
        this.setAbilityTwoImage("images/warrior/abilityTwo.png");
    }
    public Warrior(int x,int y, String name, GameMap gameMap){
        super(x,y,name,gameMap);
        this.setAttackDmg(150);
        this.setMaxHp(1500);
        this.setHp(1500);
        this.setMaxMana(150);
        this.setMana(150);
        this.setHpRegen(10);
        this.setManaRegen(5);
        this.setPoints(0);
        this.setLives(3);
        this.setDamageRange(1);
        this.setDamageType(PHYSICAL);
        this.uploadImage("images/warrior/warrior.png", "images/warrior/warriorLeftAttack.png", "images/warrior/warriorRightAttack.png");
        this.setDescription("Olympic champion, and a fearsome warrior. He prefers strength over magic and new technologies.");
        this.setAbilityOneDescription("Dance of blades: Attacks all enemies around with more strength.");
        this.setAbilityTwoDescription("Rage: Increases attack damage by attacking himself.");
        this.setAbilityOneImage("images/warrior/abilityOne.png");
        this.setAbilityTwoImage("images/warrior/abilityTwo.png");
    }
    @Override
    public void abilityOne() {
        if (getMana() >= 75) {
            int tmp=this.getAttackDmg();
            setAttackDmg(tmp*3);
            attackPlayer(getX(), getY() + 2);
            attackPlayer(getX(), getY() - 2);
            attackPlayer(getX() + 2, getY());
            attackPlayer(getX() - 2, getY());
            setAttackDmg(tmp);
            loseMana(75);
        }
    }

    @Override
    public void abilityTwo(){
        if(getMana()>=100) {
            setAttackDmg(getAttackDmg() + 15);
            loseHp(getAttackDmg());
            loseMana(100);
        }
    }
}
