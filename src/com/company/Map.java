package com.company;

import com.company.classes.Something;
import com.company.classes.characters.BaseCharacter;
import com.company.classes.characters.player.BasePlayer;
import com.company.classes.particles.Particle;
import com.company.enums.ClassType;

import java.util.ArrayList;
import java.util.List;

public class Map {
    public static int characterCount = 0;
    public static int[][] occupiedCells = new int[36][20];
    public static List<Something> things = new ArrayList<>();
    public static List<Particle> particles = new ArrayList<>();
    //public static List<BasePlayer> players;
    public static MainWindow mw;
    public Map(Something... input){
        //System.out.println(player.getHp());

       for(int i = 0; i <input.length; i++){
            things.add(input[i]);
        }
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
    public void runWindow(){
        mw = new MainWindow(1800,1000, this);
    }
}
