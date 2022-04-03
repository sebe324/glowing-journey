package com.company.classes.characters;

import com.company.classes.Something;
import com.company.enums.DamageRange;
import com.company.enums.DamageType;

import javax.swing.*;
import java.awt.*;

import static com.company.Map.occupiedCells;
import static com.company.Map.things;
import static com.company.enums.DamageRange.CLOSE_RANGE;
import static com.company.enums.DamageRange.LONG_RANGE;

public abstract class BaseCharacter extends Something implements BaseCharacterInterface{

    private int mana, maxMana, level, attackDmg;
    private int hpRegen, manaRegen;
    protected String className;
    private DamageType damageType;
    private DamageRange damageRange;
    private Image image, baseImage, attackLeftImage, attackRightImage;
    public BaseCharacter(int x, int y, String name){
        super(x,y,name);
    }
    public BaseCharacter() {
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if(this.mana>this.getMaxMana()){
            this.mana=maxMana;
        }
        else
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public void setAttackDmg(int attackDmg) {
        this.attackDmg = attackDmg;
    }

    public int getHpRegen() {
        return hpRegen;
    }

    public void setHpRegen(int hpRegen) {
        this.hpRegen = hpRegen;
    }

    public int getManaRegen() {
        return manaRegen;
    }

    public void setManaRegen(int manaRegen) {
        this.manaRegen = manaRegen;
    }

    public Image getBaseImage() {
        return baseImage;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setBaseImage() {
        this.image = this.baseImage;
    }

    public Image getAttackLeftImage() {
        return attackLeftImage;
    }

    public void setAttackLeftImage() {
        this.image = this.attackLeftImage;
    }

    public Image getAttackRightImage() {
        return attackRightImage;
    }

    public void setAttackRightImage() {
        this.image = this.attackRightImage;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public DamageRange getDamageRange() {
        return damageRange;
    }

    public void setDamageRange(DamageRange damageRange) {
        this.damageRange = damageRange;
    }

    @Override
    public void regenerateHp(int amount){
        setHp(getHp()+amount);
    }
    @Override
    public void loseMana(int amount){
        setMana(getMana()-amount);
    }
    @Override
    public void regenerateMana(int amount){
        setMana(getMana()+amount);
    }
    @Override
    public void attack(String direction){
        if(damageRange==CLOSE_RANGE) {
            if(direction=="right") {
                for (int i = 0; i < 3; i++) {
                    if (occupiedCells[getX()+1][getY() + i] != 0) {
                        things.get(occupiedCells[getX()+1][getY() + i]-1).loseHp(attackDmg);
                    }
                }
            }
            else if(direction=="left") {
                    for(int i=0; i<3; i++) {
                        if (occupiedCells[getX()-1][getY()+i] != 0) {
                            things.get(occupiedCells[getX()-1][getY()+i]-1).loseHp(attackDmg);
                        }
            }
            }
        } else if(damageRange==LONG_RANGE){
            if(direction=="right"){
            for(int i=1; i<5; i++) {
                if (occupiedCells[getX() + i][getY()] != 0) {
                    things.get(occupiedCells[getX() + i][getY()]-1).loseHp(attackDmg);
                }
                else if(occupiedCells[getX() + i][getY()+1]!=0){
                    things.get(occupiedCells[getX() + i][getY()+1]-1).loseHp(attackDmg);
                }
            }
            }
            else if(direction=="left"){
                for(int i=1; i<5; i++) {
                    if (occupiedCells[getX() - i][getY()] != 0) {
                        things.get(occupiedCells[getX() - i][getY()]-1).loseHp(attackDmg);
                    }
                    else if(occupiedCells[getX() - i][getY()+1]!=0){
                        things.get(occupiedCells[getX() - i][getY()+1]-1).loseHp(attackDmg);
                    }
                }
            }
        }
    }
    @Override
    public void levelUp(){
        setLevel(getLevel()+1);
    }
    @Override
    public void info(){

    }
    public void uploadImage(String baseImage, String attackLeftImage, String attackRightImage){
        this.baseImage = new ImageIcon(baseImage).getImage();
        this.attackLeftImage = new ImageIcon(attackLeftImage).getImage();
        this.attackRightImage = new ImageIcon(attackRightImage).getImage();
        setBaseImage();
    }
    public void tryChangePosition(int newPosX, int newPosY) {
        if (newPosX < occupiedCells.length && newPosX >= 0 && newPosY < occupiedCells[0].length && newPosY >= 0) {
            if (occupiedCells[newPosX][newPosY] == 0) {
                occupiedCells[getX()][getY()] = 0;
                occupiedCells[newPosX][newPosY] = getId();
                System.out.println(getX());
                System.out.println(getY());
                setY(newPosY);
                setX(newPosX);
                System.out.println(occupiedCells[newPosX][newPosY]);

            } else {
                loseHp(30);
            }
        }
    }
    public void left(){
        int newPositionX = getX() - 1;
        tryChangePosition(newPositionX, getY());
        System.out.println(getX());
    }
    public void right(){
        int newPositionX = getX() + 1;
        tryChangePosition(newPositionX, getY());
    }
    public void up(){
        int newPositionY=getY() - 1;
        tryChangePosition(getX(), newPositionY);
    }
    public void down(){
        int newPositionY=getY() + 1;
        tryChangePosition(getX(), newPositionY);
    }
}
