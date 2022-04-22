package com.company.classes.powerups;

import com.company.classes.GameObj;
import com.company.classes.characters.BaseCharacter;
import com.company.enums.ClassType;
import com.company.game.GameMap;

public abstract class BasePowerUp extends GameObj {
    protected BasePowerUp(int x, int y, String name, GameMap gameMap){
        super(x,y,name, ClassType.POWERUP, gameMap);

    }
    public void addStats(BaseCharacter target){}
}
