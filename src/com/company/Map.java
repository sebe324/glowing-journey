package com.company;

import com.company.classes.Something;
import com.company.classes.characters.BaseCharacter;

public class Map {
    public static int characterCount = 0;
    public static int[][] occupiedCells = new int[321][321];
    private Something[] things;
    private BaseCharacter player;
    public Map(BaseCharacter player, Something... input){
        things = new Something[input.length];
        //System.out.println(player.getHp());
        for(int i = 0; i< things.length; i++){
            things[i]=input[i];
        }
        this.player=player;
    }

    public Something[] getThings() {
        return things;
    }

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
        if(getThings().length>0 && isPlayer()) return true;
        else return false;
    }
    public void runWindow(){
        MainWindow mw = new MainWindow(375,438, this);
    }
}
