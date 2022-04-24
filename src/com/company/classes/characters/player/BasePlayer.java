package com.company.classes.characters.player;

import com.company.game.GameMap;
import com.company.classes.characters.BaseCharacter;
import com.company.enums.ClassType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class BasePlayer extends BaseCharacter {
    private int upKey;
    private int downKey;
    private int leftKey;
    private int rightKey;
    private int leftAttackKey;
    private int rightAttackKey;
    private int abilityOneKey;
    private int abilityTwoKey;
    private int points;
    private int lives;
    private boolean invisible;
    private String description;
    private String abilityOneDescription;
    private String abilityTwoDescription;
    private Image abilityOneImage;
    private Image abilityTwoImage;
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

    public Image getAbilityOneImage() {
        return abilityOneImage;
    }

    public void setAbilityOneImage(String abilityOneImage) {
        this.abilityOneImage = new ImageIcon(abilityOneImage).getImage();
    }

    public Image getAbilityTwoImage() {
        return abilityTwoImage;
    }

    public void setAbilityTwoImage(String abilityTwoImage) {
        this.abilityTwoImage = new ImageIcon(abilityTwoImage).getImage();
    }

    protected BasePlayer() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbilityOneDescription() {
        return abilityOneDescription;
    }

    public void setAbilityOneDescription(String abilityOneDescription) {
        this.abilityOneDescription = abilityOneDescription;
    }

    public String getAbilityTwoDescription() {
        return abilityTwoDescription;
    }

    public void setAbilityTwoDescription(String abilityTwoDescription) {
        this.abilityTwoDescription = abilityTwoDescription;
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
