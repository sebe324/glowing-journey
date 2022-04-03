package com.company.classes.characters.player;

import com.company.classes.characters.BaseCharacter;
import com.company.enums.ClassType;

public class BasePlayer extends BaseCharacter {
    private int upKey,downKey,leftKey,rightKey, leftAttackKey, rightAttackKey;

    public BasePlayer(int x, int y, String name, int upKey, int downKey, int leftKey, int rightKey, int leftAttackKey, int rightAttackKey) {
        super(x, y, name, ClassType.PLAYER);
        this.upKey = upKey;
        this.downKey = downKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.leftAttackKey = leftAttackKey;
        this.rightAttackKey = rightAttackKey;
    }

    public BasePlayer() {
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

}
