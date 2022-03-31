package com.company.classes.structures;

import com.company.classes.Something;

public abstract class BaseStructure extends Something {
    private Boolean Destructible;
    private int maxHp, hp;
    public BaseStructure(int x, int y, String name){
        super(x,y,name);
    }

    public Boolean getDestructible() {
        return Destructible;
    }

    public void setDestructible(Boolean destructible) {
        Destructible = destructible;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        if(this.Destructible) {
            this.maxHp = maxHp;
        }
    }

    public int getHp() {
            return hp;
    }

    public void setHp(int hp) {
        if(this.Destructible){
            this.hp=hp;
        }
    }
    public void loseHp(int value){
        if(this.Destructible){
            setHp(this.hp-value);
        }
    }
}
