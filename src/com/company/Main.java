package com.company;

import com.company.classes.characters.BaseCharacter;
import com.company.classes.characters.player.Healer;
import com.company.classes.characters.player.Wizard;
import com.company.classes.structures.Wall;

import java.util.ArrayList;
import java.util.List;

import static com.company.Map.*;

public class Main extends Thread{

    public static void main(String[] args) {
	Map map = new Map(
      new ArrayList<BaseCharacter>(List.of(new Healer(0,10,"radagast"), new Wizard(0,1,"vilgefortz"))),
            new Wall(11,10,"wall"),
            new Wall(11,3,"wall"),
            new Wall(11,9,"wall")
            );
    System.out.println("length"+things.size());
    System.out.println(things.get(0));
    if(map.notEmpty()){
        map.runWindow();
        Main thread = new Main();
        players.get(0).setHp(100);
        thread.start();
    }

    else{
        System.out.println("game over");
    }

    }
    public void run() {
        while (true) {
            try{
                for(BaseCharacter player : players){
                    player.setHp(player.getHp()+player.getHpRegen());
                }
                mw.getGame().repaint();
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                //do stuff
            }
        }
    }
}
