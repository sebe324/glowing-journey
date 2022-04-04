package com.company;

import com.company.classes.characters.BaseCharacter;
import com.company.classes.characters.npcs.BaseMonster;
import com.company.classes.characters.npcs.Zombie;
import com.company.classes.characters.player.BasePlayer;
import com.company.classes.characters.player.Healer;
import com.company.classes.characters.player.Wizard;
import com.company.classes.structures.Wall;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static com.company.Map.*;

public class Main extends Thread{

    public static void main(String[] args) {
        Map map = new Map(
                new Wizard(0,10,"vilgefortz",  KeyEvent.VK_I, KeyEvent.VK_K, KeyEvent.VK_J, KeyEvent.VK_L, KeyEvent.VK_U, KeyEvent.VK_O),
                new Healer(0,1,"radagast", KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_Q,KeyEvent.VK_E),
                new Wall(11,10,"wall"),
                new Wall(11,3,"wall"),
                new Wall(11,9,"wall"),
                new Zombie(8,3, "zombie")
        );
    System.out.println("length"+things.size());
    System.out.println(things.get(0));
    if(map.notEmpty()){
        map.runWindow();
        getPlayers().get(1).setHp(100);
        Main thread = new Main();
        thread.start();
        System.out.println("Cells:  " + (occupiedCells[0][10]));
    }

    else{
        System.out.println("game over");
    }

    }
    public void run() {
        while (true) {
            try{
                for(BasePlayer player : getPlayers()){
                    player.setHp(player.getHp()+player.getHpRegen());
                }
                for(BaseMonster monster : getMonsters()){
                    monster.pathFindToPlayer();
                }

                mw.getGame().repaint();
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                //do stuff
            }
        }
    }
}
