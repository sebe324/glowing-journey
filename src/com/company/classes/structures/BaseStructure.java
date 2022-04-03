package com.company.classes.structures;

import com.company.classes.Something;
import com.company.enums.ClassType;

public abstract class BaseStructure extends Something {
    private Boolean Destructible;
    public BaseStructure(int x, int y, String name){
        super(x,y,name, ClassType.STRUCTURE);
    }

    public Boolean getDestructible() {
        return Destructible;
    }

    public void setDestructible(Boolean destructible) {
        Destructible = destructible;
    }

    public void loseHp(int value){
        if(this.Destructible){
            setHp(getHp()-value);
        }
    }
}
