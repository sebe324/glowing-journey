package com.company;

import com.company.classes.characters.player.Healer;
import com.company.classes.structures.Wall;

public class Main {

    public static void main(String[] args) {
	Map map = new Map(
      new Healer(10,0,"radagast"),
            new Wall(10, 10, "wall")
            );
    if(map.notEmpty()){
        map.runWindow();
    }
    else{
        System.out.println("game over");
    }
    }
}
