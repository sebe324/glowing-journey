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
    private BaseCharacter player;
    public Map(BaseCharacter player, Something... input){
        //System.out.println(player.getHp());
        things.add(player);
       for(int i = 1; i <input.length+1; i++){
            things.add(input[i-1]);
        }
        this.player=player;
    }

    public Something getThing(int index){return things.get(index);}
    public BaseCharacter getPlayer() {
        return player;
    }

    public void setPlayer(BaseCharacter player) {
        this.player = player;
    }
    public boolean isPlayer(){
        if(this.player!=null){
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
        MainWindow mw = new MainWindow(1800,1000, this);
    }
}
