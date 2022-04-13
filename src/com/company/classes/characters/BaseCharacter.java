package com.company.classes.characters;

import com.company.classes.particles.Particle;
import com.company.game.GameMap;
import com.company.classes.GameObj;
import com.company.enums.ClassType;
import com.company.enums.DamageType;

import javax.swing.*;
import java.awt.*;

public abstract class BaseCharacter extends GameObj implements BaseCharacterInterface{

    private int mana, maxMana, level, attackDmg;
    private int hpRegen, manaRegen;
    private DamageType damageType;
    private int damageRange;
    private Image attackLeftImage, attackRightImage;
    protected BaseCharacter(int x, int y, java.lang.String name, ClassType type, GameMap gameMap){
        super(x,y,name, type, gameMap);
        this.gameMap=gameMap;
    }
    protected BaseCharacter() {
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if(mana>this.getMaxMana()){
            this.mana=maxMana;
        }
        else this.mana = mana;
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

    public Image getAttackLeftImage() {
        return attackLeftImage;
    }

    public void setAttackLeftImage() {
        setImage(this.attackLeftImage);
    }

    public Image getAttackRightImage() {
        return attackRightImage;
    }

    public void setAttackRightImage() {
        setImage(this.attackRightImage);
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public int getDamageRange() {
        return damageRange;
    }

    public void setDamageRange(int damageRange) {
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
    public boolean attack(int directionX, int directionY){
    int i=getX();
    int j=getY();
        while((i!=directionX || j!=directionY) &&(i>0&&i<35&&j>0&&j<20)){ //check if attack is in map
            if(i>directionX) i--;
            else if(i<directionX) i++;
            if(j>directionY)j--;
            else if(j<directionY)j++;
            if (gameMap.occupiedCells[i][j] != 0) {
                if(gameMap.gameObjs.get(gameMap.occupiedCells[i][j] - 1).getHp()-attackDmg<=0){
               gameMap.gameObjs.get(gameMap.occupiedCells[i][j] - 1).loseHp(attackDmg);
                    return true;
                }
                else{
                    gameMap.gameObjs.get(gameMap.occupiedCells[i][j] - 1).loseHp(attackDmg);
                }
            }
        }
        return false;
    }
    @Override
    public void levelUp(){
        setLevel(getLevel()+1);
    }
    @Override
    public void info(){

    }
    public void uploadImage(java.lang.String baseImage, java.lang.String attackLeftImage, java.lang.String attackRightImage){
        setBaseImage(new ImageIcon(baseImage).getImage());
        this.attackLeftImage = new ImageIcon(attackLeftImage).getImage();
        this.attackRightImage = new ImageIcon(attackRightImage).getImage();
        setBaseImageToImage();
    }
    public void tryChangePosition(int newPosX, int newPosY) {
        if (newPosX < gameMap.occupiedCells.length && newPosX >= 0 && newPosY < gameMap.occupiedCells[0].length && newPosY >= 0) {
            if (gameMap.occupiedCells[newPosX][newPosY] == 0) {
                gameMap.occupiedCells[getX()][getY()] = 0;
                gameMap.occupiedCells[newPosX][newPosY] = getId();
                setY(newPosY);
                setX(newPosX);

            } else {
                loseHp(30);
            }
        }
    }
    public void left(){
        int newPositionX = getX() - 1;
        tryChangePosition(newPositionX, getY());
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
