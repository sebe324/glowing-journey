package com.company;

import com.company.classes.characters.player.Healer;
import com.company.classes.characters.player.Wizard;
import com.company.classes.structures.Wall;

import static com.company.Map.things;

public class Main {

    public static void main(String[] args) {
	Map map = new Map(
      new Wizard(10,0,"radagast"),
            new Wall(10, 10, "wall"),
            new Wall(11,10,"wall")
            );
    System.out.println("length"+things.size());
    System.out.println(things.get(0));
    if(map.notEmpty()){
        map.runWindow();
    }
    else{
        System.out.println("game over");
    }

    }
}
