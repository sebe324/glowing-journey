package com.company.classes.characters.player;

import com.company.game.GameMap;
import com.company.classes.characters.BaseCharacter;
import com.company.enums.ClassType;

import java.awt.event.KeyEvent;

public abstract class BasePlayer extends BaseCharacter {
    private int upKey,downKey,leftKey,rightKey, leftAttackKey, rightAttackKey;

    protected BasePlayer(int x, int y, java.lang.String name, GameMap gameMap) {
        super(x, y, name, ClassType.PLAYER, gameMap);
        upKey = KeyEvent.VK_W;
        leftKey = KeyEvent.VK_A;
        downKey = KeyEvent.VK_S;
        rightKey=KeyEvent.VK_D;
        leftAttackKey= KeyEvent.VK_Q;
        rightAttackKey = KeyEvent.VK_E;

    }

    protected BasePlayer() {
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
}
