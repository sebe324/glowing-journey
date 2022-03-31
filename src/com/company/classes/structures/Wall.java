package com.company.classes.structures;

public class Wall extends BaseStructure {
public Wall(int x, int y, String name){
 super(x,y,name);
 this.setDestructible(true);
 this.setMaxHp(2000);
 this.setHp(2000);
 this.uploadImage("images/wall/wall.png");
}
}
