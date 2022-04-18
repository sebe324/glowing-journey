package com.company.game;

import com.company.classes.powerups.BasePowerUp;
import com.company.classes.structures.Bush;
import com.company.classes.structures.Wall;
import com.company.menu.MainWindow;
import com.company.menu.MenuWindow;
import com.company.classes.GameObj;
import com.company.classes.characters.npcs.BaseMonster;
import com.company.classes.characters.player.BasePlayer;
import com.company.classes.particles.Particle;
import com.company.classes.structures.BaseStructure;
import com.company.enums.ClassType;

import java.awt.event.KeyEvent;
import java.lang.reflect.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameMap {
    public int characterCount = 0;
    public int[][] occupiedCells = new int[36][20];
    public List<GameObj> gameObjs = new ArrayList<>();
    public List<Particle> particles = new ArrayList<>();
    public MainWindow mainWindow;
    public MenuWindow menuWindow;
    public java.lang.String filePath="saves/save.txt";
    public boolean running = true;
    public GameMap(GameObj... input){
       for(int i = 0; i <input.length; i++){
            gameObjs.add(input[i]);
        }
    }

    public GameMap() {
        //empty constructor
    }

    public ArrayList<BasePlayer> getPlayers(){
        ArrayList<BasePlayer> result = new ArrayList<>();
        for(int i = 0; i< gameObjs.size(); i++){
         if(gameObjs.get(i).getType()== ClassType.PLAYER){
            result.add((BasePlayer) gameObjs.get(i));
         }
        }
        return result;
    }
    public ArrayList<BaseMonster> getMonsters(){
        ArrayList<BaseMonster> result = new ArrayList<>();
        for(int i = 0; i< gameObjs.size(); i++){
            if(gameObjs.get(i).getType()==ClassType.MONSTER){
                result.add((BaseMonster) gameObjs.get(i));
            }
        }
        return result;
    }
    public ArrayList<BaseStructure> getStructures(){
        ArrayList<BaseStructure> result = new ArrayList<>();
        for(int i = 0; i< gameObjs.size(); i++){
            if(gameObjs.get(i).getType()==ClassType.STRUCTURE){
                result.add((BaseStructure) gameObjs.get(i));
            }
        }
        return result;
    }
    public ArrayList<BasePowerUp> getPowerUps(){
        ArrayList<BasePowerUp> result = new ArrayList<>();
        for(int i = 0; i< gameObjs.size(); i++){
            if(gameObjs.get(i).getType()==ClassType.POWERUP){
                result.add((BasePowerUp) gameObjs.get(i));
            }
        }
        return result;
    }
    public void runMenu(){menuWindow = new MenuWindow(this);}
    public void runWindow(){
        mainWindow = new MainWindow(1800,1000, this);
    }
    public void save(java.lang.String path){
        try(
                FileWriter writer = new FileWriter(path);
                ){
        for(BasePlayer player : getPlayers()){
            java.lang.String line=(player.getType()+";"+player.getClass().getCanonicalName()+";"+ player.getX()+";"+player.getY()+";"+player.getName()+";"+player.getAttackDmg()+";"+player.getMaxHp()+";"+player.getHp()+";"+player.getMaxMana()+";"+player.getMana()+";"+player.getHpRegen()+";"+player.getManaRegen()+";"+player.getPoints()+";"+player.getLives()+"\n");
            writer.write(line);
        }
            for(BaseMonster monster: getMonsters()){
            java.lang.String line=(monster.getType()+";"+monster.getClass().getCanonicalName()+";"+monster.getX()+";"+monster.getY()+";"+monster.getName()+";"+monster.getLevel()+"\n");
            writer.write(line);
            }
            for(BaseStructure structure : getStructures()){
            java.lang.String line=(structure.getType()+";"+structure.getClass().getCanonicalName()+";"+structure.getX()+";"+structure.getY()+";"+structure.getName()+"\n");
            writer.write(line);
            }
            writer.close();
        }catch(IOException e){
            //something idk
        }
    }
    public void load(File file){
        try(Scanner reader = new Scanner(file);){
            filePath=file.getPath();
            gameObjs.clear();
            while(reader.hasNextLine()){
                java.lang.String data = reader.nextLine();
                java.lang.String[] line = data.split(";");
                if(line[0].equals("PLAYER")) {
                    int x = Integer.parseInt(line[2]);
                    int y = Integer.parseInt(line[3]);
                    String name = line[4];
                    int attackDmg = Integer.parseInt(line[5]);
                    int maxHp = Integer.parseInt(line[6]);
                    int hp = Integer.parseInt(line[7]);
                    int maxMana = Integer.parseInt(line[8]);
                    int mana = Integer.parseInt(line[9]);
                    int hpRegen = Integer.parseInt(line[10]);
                    int manaRegen = Integer.parseInt(line[11]);
                    int points = Integer.parseInt(line[12]);
                    int lives=Integer.parseInt(line[13]);
                    Class player = Class.forName(line[1]);
                    Constructor con = player.getConstructor(int.class, int.class, String.class, int.class, int.class, int.class, int.class, int.class, int.class, int.class, int.class, int.class, GameMap.class);
                    this.gameObjs.add((GameObj) con.newInstance(x, y, name, attackDmg, maxHp, hp, maxMana, mana, hpRegen, manaRegen, points, lives, this));
                    if(this.getPlayers().size()==2){
                        BasePlayer player2=this.getPlayers().get(1);
                        player2.setUpKey(KeyEvent.VK_I);
                        player2.setLeftKey(KeyEvent.VK_J);
                        player2.setRightKey(KeyEvent.VK_L);
                        player2.setDownKey(KeyEvent.VK_K);
                        player2.setLeftAttackKey(KeyEvent.VK_U);
                        player2.setRightAttackKey(KeyEvent.VK_O);
                        player2.setAbilityOneKey(KeyEvent.VK_7);
                        player2.setAbilityTwoKey(KeyEvent.VK_8);
                    }
                }
                    else if(line[0].equals("MONSTER")) {

                    int x = Integer.parseInt(line[2]);
                    int y=Integer.parseInt(line[3]);
                    String name=line[4];
                    int level =Integer.parseInt(line[5]);
                    Class monster = Class.forName(line[1]);
                    Constructor con = monster.getConstructor(int.class,int.class,String.class,int.class,GameMap.class);
                    this.gameObjs.add((GameObj)con.newInstance(x,y,name,level,this));
                }
                    else if(line[0].equals("STRUCTURE")){
                    int x=Integer.parseInt(line[2]);
                    int y=Integer.parseInt(line[3]);
                    String name=line[4];
                    Class structure = Class.forName(line[1]);
                    Constructor con = structure.getConstructor(int.class,int.class,String.class,GameMap.class);
                    this.gameObjs.add((GameObj)con.newInstance(x,y,name,this));
                }
                }

            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void generate(int amount){
        Random randomX = new Random();
        Random randomY = new Random();
        Random randomStructure = new Random();
        for(int i=0; i<amount; i++) {
            int strX=randomX.nextInt(36);
            int strY=randomY.nextInt(20);

            if (occupiedCells[strX][strY] == 0) {
                switch (randomStructure.nextInt(2)) {
                    case 0:
                        gameObjs.add(new Bush(strX,strY,"bush",this));
                        break;
                    case 1:
                        gameObjs.add(new Wall(strX,strY,"wall",this));
                        break;
                }
                System.out.println("game objects "+gameObjs);
            }
        }
    }
}
