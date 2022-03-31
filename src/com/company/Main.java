package com.company;

import com.company.classes.characters.player.Warrior;
import com.company.classes.characters.player.Wizard;
import com.company.classes.structures.Wall;

public class Main {

    public static void main(String[] args) {
	Map map = new Map(
      new Wizard(120,0,"vilgefortz"),
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
