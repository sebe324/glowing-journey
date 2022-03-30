package com.company.classes.characters.player;

import com.company.classes.characters.BaseCharacter;
import static com.company.enums.DamageRange.CLOSE_RANGE;
import static com.company.enums.DamageType.PHYSICAL;


public class Warrior extends BaseCharacter {
    public Warrior(int x, int y, String name) {
        super(x,y,name);
        this.setAttackDmg(100);
        this.setMaxHp(1000);
        this.setHp(1000);
        this.setMaxMana(200);
        this.setMana(200);
        this.setDamageRange(CLOSE_RANGE);
        this.setDamageType(PHYSICAL);
        this.uploadImage("1.png", "2.png", "3.png");
    }

    public Warrior() {
    }

    public void abilityOne(int manaCost){

    }
    public void abilityTwo(int manaCost){

    }
    public void abilityThree(int manaCost){

    }
    public void left(){
    int newPositionX = this.getX() > 40 ? this.getX() - 40: 0;
    tryChangePosition(newPositionX, this.getY());
        System.out.println(this.getX());
    }
    public void right(){
    int newPositionX = this.getX()<320 ? this.getX()+40 : 320;
    tryChangePosition(newPositionX, this.getY());
    }
    public void up(){
    int newPositionY=this.getY() > 40 ? this.getY() - 40 : 0;
    tryChangePosition(this.getX(), newPositionY);
    }
    public void down(){
    int newPositionY=this.getY() < 320 ? this.getY() + 40 :320;
    tryChangePosition(this.getX(), newPositionY);
    }
}
