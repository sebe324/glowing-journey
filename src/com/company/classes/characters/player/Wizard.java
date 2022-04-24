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
        this.setDescription("Almost 150 years old, but looks like he's 60 thanks to magic rituals. He knows all the secrets of magic and isn't afraid to use them in fight.");
        this.setAbilityOneDescription("Teleportation: Wizard teleports to a random location on the map.");
        this.setAbilityTwoDescription("Desintegration: Wizard deals massive damage to a random monster.");
        this.setAbilityOneImage("images/wizard/abilityOne.png");
        this.setAbilityTwoImage("images/wizard/abilityTwo.png");
    }
    public Wizard(int x, int y, String name, GameMap gameMap){
        super(x,y,name, gameMap);
        this.setAttackDmg(100);
        this.setMaxHp(750);
        this.setHp(750);
        this.setMaxMana(300);
        this.setMana(300);
        this.setDamageRange(4);
        this.setHpRegen(10);
        this.setManaRegen(5);
        this.setPoints(0);
        this.setLives(3);
        this.setDamageType(MAGIC);
        this.uploadImage("images/wizard/wizard.png", "images/wizard/wizardLeftAttack.png", "images/wizard/wizardRightAttack.png");
        this.setDescription("Almost 150 years old, but looks like he's 60 thanks to magic rituals. He knows all the secrets of magic and isn't afraid to use them in fight.");
        this.setAbilityOneDescription("Teleportation: Wizard teleports to a random location on the map.");
        this.setAbilityTwoDescription("Desintegration: Wizard deals massive damage to a random monster.");
        this.setAbilityOneImage("images/wizard/abilityOne.png");
        this.setAbilityTwoImage("images/wizard/abilityTwo.png");
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
            gameMap.getMonsters().get(rand.nextInt(gameMap.getMonsters().size())).loseHp(getAttackDmg() * 8);
            loseMana(100);
        }
    }
}
