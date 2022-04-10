package com.company;

import com.company.classes.Something;
import com.company.classes.characters.BaseCharacter;
import com.company.classes.characters.npcs.BaseMonster;
import com.company.classes.characters.player.BasePlayer;
import com.company.classes.particles.Particle;
import com.company.classes.structures.BaseStructure;
import com.company.enums.ClassType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map {
    public static int characterCount = 0;
    public static int[][] occupiedCells = new int[36][20];
    public static List<Something> things = new ArrayList<>();
    public static List<Particle> particles = new ArrayList<>();
    public static MainWindow mainWindow;
    public static MenuWindow menuWindow;
    public Map(Something... input){
        //System.out.println(player.getHp());

       for(int i = 0; i <input.length; i++){
            things.add(input[i]);
        }
    }

    public Map() {
    }

    public boolean notEmpty(){
        if(things.size()>0) return true;
        else return false;
    }
    public static ArrayList<BasePlayer> getPlayers(){
        ArrayList<BasePlayer> result = new ArrayList<>();
        for(int i=0; i<things.size(); i++){
         if(things.get(i).getType()== ClassType.PLAYER){
            result.add((BasePlayer)things.get(i));
         }
        }
        return result;
    }
    public static ArrayList<BaseMonster> getMonsters(){
        ArrayList<BaseMonster> result = new ArrayList<>();
        for(int i=0; i<things.size(); i++){
            if(things.get(i).getType()==ClassType.MONSTER){
                result.add((BaseMonster)things.get(i));
            }
        }
        return result;
    }
    public static ArrayList<BaseStructure> getStructures(){
        ArrayList<BaseStructure> result = new ArrayList<>();
        for(int i=0; i<things.size(); i++){
            if(things.get(i).getType()==ClassType.STRUCTURE){
                result.add((BaseStructure) things.get(i));
            }
        }
        return result;
    }
    public void runMenu(){menuWindow = new MenuWindow();}
    public void runWindow(){
        mainWindow = new MainWindow(1800,1000, this);
    }
    public static void save(String path){
        try{
            FileWriter writer = new FileWriter(path);
        for(BasePlayer player : getPlayers()){
            String line=(player.getX()+" "+player.getY()+" "+player.getName()+" "+player.getAttackDmg()+" "+player.getMaxHp()+" "+player.getHp()+" "+player.getMaxMana()+" "+player.getMana()+" "+player.getUpKey()+" "+player.getDownKey()+" "+player.getLeftKey()+" "+player.getRightKey()+" "+player.getLeftAttackKey()+" "+player.getRightAttackKey()+"\n");
            writer.write(line);
        }
            for(BaseMonster monster: getMonsters()){

            }
            for(BaseStructure structure : getStructures()){

            }
        }catch(IOException e){

        }
    }
}
