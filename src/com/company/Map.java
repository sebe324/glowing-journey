package com.company;

import com.company.classes.Something;
import com.company.classes.characters.BaseCharacter;
import com.company.classes.particles.Particle;

import java.util.ArrayList;
import java.util.List;

public class Map {
    public static int characterCount = 0;
    public static int[][] occupiedCells = new int[36][20];
    public static List<Something> things = new ArrayList<>();
    public static List<Particle> particles = new ArrayList<>();
    public static List<BaseCharacter> players;
    public static MainWindow mw;
    public Map(ArrayList<BaseCharacter> players, Something... input){
        //System.out.println(player.getHp());

        for(BaseCharacter player : players) {
            things.add(player);
        }
       for(int i = 0; i <input.length; i++){
            things.add(input[i]);
        }
        this.players=players;
    }

    public boolean isPlayer(){
        if(this.players!=null){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean notEmpty(){
        if(things.size()>0 && isPlayer()) return true;
        else return false;
    }
    public void runWindow(){
        mw = new MainWindow(1800,1000, this);
    }
}
