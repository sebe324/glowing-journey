package com.company;

import com.company.classes.Something;
import com.company.classes.characters.npcs.BaseMonster;
import com.company.classes.characters.npcs.Zombie;
import com.company.classes.characters.player.BasePlayer;
import com.company.classes.characters.player.Healer;
import com.company.classes.characters.player.Wizard;
import com.company.classes.structures.Wall;

import java.awt.event.KeyEvent;

import static com.company.Map.*;

public class Main extends Thread{

    public static void main(String[] args) {

        Map map = new Map();
        map.runMenu();

    }
    //game loop
    public void run() {
        while (true) {
            try{
                for(BasePlayer player : getPlayers()){
                    player.setHp(player.getHp()+player.getHpRegen());
                }
                if(getMonsters().size()<4){
                    int x=(int)(Math.random() * 35) + 1;
                    int y=(int)(Math.random() * 19) + 1;
                    if(occupiedCells[x][y]==0){
                        things.add(new Zombie(x,y,"zombie", 1));
                    }
                }

                for(BaseMonster monster : getMonsters()){
                    monster.pathFindToPlayer();
                }

                mainWindow.getGame().repaint();
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                //do stuff
            }
        }
    }
}
