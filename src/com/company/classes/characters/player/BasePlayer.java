package com.company.classes.characters.player;

import com.company.game.GameMap;
import com.company.classes.characters.BaseCharacter;
import com.company.enums.ClassType;

import java.awt.event.KeyEvent;

public abstract class BasePlayer extends BaseCharacter {
    private int upKey,downKey,leftKey,rightKey, leftAttackKey, rightAttackKey, abilityOneKey, abilityTwoKey;
    private int points;
    private int lives;
    private boolean invisible;
    protected BasePlayer(int x, int y, java.lang.String name, GameMap gameMap) {
        super(x, y, name, ClassType.PLAYER, gameMap);
        upKey = KeyEvent.VK_W;
        leftKey = KeyEvent.VK_A;
        downKey = KeyEvent.VK_S;
        rightKey=KeyEvent.VK_D;
        leftAttackKey= KeyEvent.VK_Q;
        rightAttackKey = KeyEvent.VK_E;
        abilityOneKey = KeyEvent.VK_1;
        abilityTwoKey = KeyEvent.VK_2;
    }

    protected BasePlayer() {
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getUpKey() {
        return upKey;
    }


    public int getDownKey() {
        return downKey;
    }


    public int getLeftKey() {
        return leftKey;
    }



    public int getRightKey() {
        return rightKey;
    }


    public int getLeftAttackKey() {
        return leftAttackKey;
    }



    public int getRightAttackKey() {
        return rightAttackKey;
    }

    public void setUpKey(int upKey) {
        this.upKey = upKey;
    }

    public void setDownKey(int downKey) {
        this.downKey = downKey;
    }

    public void setLeftKey(int leftKey) {
        this.leftKey = leftKey;
    }

    public void setRightKey(int rightKey) {
        this.rightKey = rightKey;
    }

    public void setLeftAttackKey(int leftAttackKey) {
        this.leftAttackKey = leftAttackKey;
    }

    public void setRightAttackKey(int rightAttackKey) {
        this.rightAttackKey = rightAttackKey;
    }

    public int getAbilityOneKey() {
        return abilityOneKey;
    }

    public void setAbilityOneKey(int abilityOneKey) {
        this.abilityOneKey = abilityOneKey;
    }

    public int getAbilityTwoKey() {
        return abilityTwoKey;
    }

    public void setAbilityTwoKey(int abilityTwoKey) {
        this.abilityTwoKey = abilityTwoKey;
    }
    public void abilityOne(){

    }
    public void abilityTwo(){

    }
    public void attackPlayer(int directionX, int directionY){
        if(attack(directionX,directionY)) points+=10;
    }

    public boolean isInvisible() {
        return invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }
    public void respawn(){
        setLives(getLives()-1);
        tryChangePosition(0,0);
        setHp(getMaxHp());
        setMana(getMaxMana());
    }
}
