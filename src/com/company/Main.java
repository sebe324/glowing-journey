package com.company;

import com.company.classes.characters.player.Warrior;

public class Main {

    public static void main(String[] args) {
	Map map = new Map(
      new Warrior(120,0,"warrior"),
      new Warrior(100, 60, "h")
            );
    if(map.notEmpty()){
        map.runWindow();
    }
    else{
        System.out.println("game over");
    }
    }
}
