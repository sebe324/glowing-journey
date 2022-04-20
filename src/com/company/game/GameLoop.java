package com.company.game;

import com.company.classes.characters.npcs.BaseMonster;
import com.company.classes.characters.npcs.Necromancer;
import com.company.classes.characters.npcs.Zombie;
import com.company.classes.characters.player.BasePlayer;
import com.company.classes.powerups.HpPotion;
import com.company.classes.powerups.Sword;

import javax.swing.*;
import java.util.Random;

public class GameLoop implements Runnable{
    GameMap gameMap;
public GameLoop(GameMap gameMap){
this.gameMap=gameMap;
}
public void run(){
       while (gameMap.running) {
            try{
                gameMap.particles.clear();
                for(BasePlayer player : gameMap.getPlayers()){
                    player.setHp(player.getHp()+player.getHpRegen());
                    player.setMana(player.getMana()+player.getManaRegen());
                    if(player.getPoints()>999){
                        JOptionPane.showMessageDialog(gameMap.menuWindow,player.getName()+" wins!");
                        gameMap.mainWindow.dispose();
                        gameMap.running=false;
                        gameMap=null;
                        gameMap=new GameMap();
                        gameMap.runMenu();
                    }
                    if(player.getLives()<=0){
                        JOptionPane.showMessageDialog(gameMap.menuWindow,player.getName()+" lost!");
                        gameMap.mainWindow.dispose();
                        gameMap.running=false;
                        gameMap=null;
                        gameMap=new GameMap();
                        gameMap.runMenu();
                    }
                    if(player.isInvisible()){
                        player.loseMana(15);
                        if(player.getMana()<=0){ //do zrobienia na pozniej
                            player.setInvisible(false);
                            player.setBaseImage(new ImageIcon("images/"+player.getClass().getSimpleName()+"/"+player.getClass().getSimpleName()+".png").getImage());
                            player.setBaseImageToImage();
                        }
                    }
                }
                if(gameMap.getMonsters().size()<4){
                    int x=(int)(Math.random() * 35) + 1;
                    int y=(int)(Math.random() * 19) + 1;
                    if(gameMap.occupiedCells[x][y]==0){
                        switch ((int)(Math.random()*3)+1){
                            case 1:
                                gameMap.gameObjs.add(new Zombie(x,y,"zombie", 1,  gameMap));
                                break;
                            case 2:
                                break;
                            default:
                                gameMap.gameObjs.add(new Necromancer(x,y,"necromancer", 1,  gameMap));
                                break;
                        }
                    }
                }
                if(gameMap.getPowerUps().size()<3){
                    Random randomX=new Random();
                    Random randomY=new Random();
                    Random randomPowerUp = new Random();
                    int powerUpX=randomX.nextInt(36);
                    int powerUpY=randomY.nextInt(20);
                    if(gameMap.occupiedCells[powerUpX][powerUpY]==0) {
                        switch (randomPowerUp.nextInt(2)) {
                            case 0: gameMap.gameObjs.add(new Sword(powerUpX, powerUpY, "excalibur", gameMap));
                            break;
                            case 1:
                                gameMap.gameObjs.add(new HpPotion(powerUpX, powerUpY, "amol",gameMap));
                                break;
                        }
                    }
                }
                for(BaseMonster monster : gameMap.getMonsters()){
                    monster.pathFindToPlayer();
                }

                gameMap.mainWindow.getGame().repaint();
                Thread.sleep(500);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
}
}
