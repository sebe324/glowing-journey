package com.company.game;

import com.company.menu.MainWindow;
import com.company.menu.MenuWindow;
import com.company.classes.Something;
import com.company.classes.characters.npcs.BaseMonster;
import com.company.classes.characters.player.BasePlayer;
import com.company.classes.particles.Particle;
import com.company.classes.structures.BaseStructure;
import com.company.enums.ClassType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMap {
    public int characterCount = 0;
    public int[][] occupiedCells = new int[36][20];
    public List<Something> things = new ArrayList<>();
    public List<Particle> particles = new ArrayList<>();
    public MainWindow mainWindow;
    public MenuWindow menuWindow;
    public String filePath;
    public GameMap(Something... input){
       for(int i = 0; i <input.length; i++){
            things.add(input[i]);
        }
    }

    public GameMap() {
        //empty constructor
    }

    public ArrayList<BasePlayer> getPlayers(){
        ArrayList<BasePlayer> result = new ArrayList<>();
        for(int i=0; i<things.size(); i++){
         if(things.get(i).getType()== ClassType.PLAYER){
            result.add((BasePlayer)things.get(i));
         }
        }
        return result;
    }
    public ArrayList<BaseMonster> getMonsters(){
        ArrayList<BaseMonster> result = new ArrayList<>();
        for(int i=0; i<things.size(); i++){
            if(things.get(i).getType()==ClassType.MONSTER){
                result.add((BaseMonster)things.get(i));
            }
        }
        return result;
    }
    public ArrayList<BaseStructure> getStructures(){
        ArrayList<BaseStructure> result = new ArrayList<>();
        for(int i=0; i<things.size(); i++){
            if(things.get(i).getType()==ClassType.STRUCTURE){
                result.add((BaseStructure) things.get(i));
            }
        }
        return result;
    }
    public void runMenu(){menuWindow = new MenuWindow(this);}
    public void runWindow(){
        mainWindow = new MainWindow(1800,1000, this);
    }
    public void save(String path){
        try(
                FileWriter writer = new FileWriter(path);
                ){
        for(BasePlayer player : getPlayers()){
            String line=(player.getX()+" "+player.getY()+" "+player.getName()+" "+player.getAttackDmg()+" "+player.getMaxHp()+" "+player.getHp()+" "+player.getMaxMana()+" "+player.getMana()+"\n");
            writer.write(line);
        }
            for(BaseMonster monster: getMonsters()){
            //will add later
            }
            for(BaseStructure structure : getStructures()){
            //will add later
            }
            writer.close();
        }catch(IOException e){
            //something idk
        }
    }
    public GameMap load(File file){
        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
            }
            reader.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}