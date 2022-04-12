package com.company.classes.structures;

import com.company.game.GameMap;
import com.company.classes.GameObj;
import com.company.enums.ClassType;

public abstract class BaseStructure extends GameObj {
    private Boolean destructible;
    public BaseStructure(int x, int y, java.lang.String name, GameMap gameMap){
        super(x,y,name, ClassType.STRUCTURE, gameMap);
    }

    public Boolean getDestructible() {
        return destructible;
    }

    public void setDestructible(Boolean destructible) {
        this.destructible = destructible;
    }

    public void loseHp(int value){
        if(this.destructible){
            setHp(getHp()-value);
        }
    }
}
