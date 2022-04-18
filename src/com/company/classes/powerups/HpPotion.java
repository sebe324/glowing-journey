package com.company.classes.powerups;

import com.company.classes.characters.BaseCharacter;
import com.company.game.GameMap;

public class HpPotion extends BasePowerUp{
    public HpPotion(int x, int y, String name, GameMap gameMap) {
        super(x,y,name,gameMap);
        this.uploadImage("images/powerups/healthpotion.png");
    }
    @Override
    public void addStats(BaseCharacter target){
        target.setMaxHp(target.getMaxHp()+50);
        target.regenerateHp(50);
    }
}

