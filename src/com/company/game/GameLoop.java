package com.company.game;

import com.company.classes.characters.npcs.BaseMonster;
import com.company.classes.characters.npcs.Necromancer;
import com.company.classes.characters.npcs.Zombie;
import com.company.classes.characters.player.BasePlayer;

public class GameLoop implements Runnable{
    GameMap gameMap;
public GameLoop(GameMap gameMap){
this.gameMap=gameMap;
}
public void run(){
       while (true) {
            try{
                for(BasePlayer player : gameMap.getPlayers()){
                    player.setHp(player.getHp()+player.getHpRegen());
                }
                if(gameMap.getMonsters().size()<4){
                    int x=(int)(Math.random() * 35) + 1;
                    int y=(int)(Math.random() * 19) + 1;
                    if(gameMap.occupiedCells[x][y]==0){
                        gameMap.gameObjs.add(new Necromancer(x,y,"necromancer", 1,  gameMap));
                    }
                }

                for(BaseMonster monster : gameMap.getMonsters()){
                    monster.pathFindToPlayer();
                }

                gameMap.mainWindow.getGame().repaint();
                Thread.sleep(500);
            }catch(InterruptedException ex){
                //do stuff
            }
        }
}
}
