package com.company.classes.structures;

import com.company.GameMap;

public class Wall extends BaseStructure {
public Wall(int x, int y, String name, GameMap gameMap){
 super(x,y,name, gameMap);
 this.setDestructible(true);
 this.setMaxHp(2000);
 this.setHp(2000);
 this.uploadImage("images/wall/wall.png");
}
}
