package com.company.classes.powerups;

import com.company.classes.characters.BaseCharacter;
import com.company.game.GameMap;

public class Sword extends BasePowerUp {

    public Sword(int x, int y, String name, GameMap gameMap) {
    super(x,y,name,gameMap);
    this.uploadImage("images/powerups/sword.png");
    }
    @Override
    public void addStats(BaseCharacter target){
     target.setAttackDmg(target.getAttackDmg()+5);
    }
}
