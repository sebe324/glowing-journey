package com.company.classes.characters.npcs;

import com.company.classes.characters.player.Gunslinger;
import com.company.game.GameMap;
import com.company.classes.characters.BaseCharacter;
import com.company.classes.characters.player.BasePlayer;
import com.company.enums.ClassType;

import java.security.SecureRandom;
import java.util.Random;

public abstract class BaseMonster extends BaseCharacter implements BaseMonsterInterface{
    private BasePlayer attacked=null;
    private int range;
    protected BaseMonster(int x, int y, java.lang.String name, int range, GameMap gameMap) {
        super(x, y, name, ClassType.MONSTER, gameMap);
        this.range=range;
        this.gameMap=gameMap;
    }
    @Override
    public boolean IsPlayerInRange() {
        if(this.attacked==null) {
            for (BasePlayer player : gameMap.getPlayers()) {

                if (getDistance(player) <= this.range) {
                    this.attacked = player;
                    return true;
                }
            }
        }
        else{
            if(getDistance(this.attacked)<=this.range){
                return true;
            }
            else return false;
            }
        return false;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public void pathFindToPlayer() {
        Random random = new SecureRandom();
    if(IsPlayerInRange() && !this.attacked.isInvisible()){
        if(getDistance(this.attacked)<=getDamageRange()){
            attack(attacked.getX(),attacked.getY());
            if(!this.attacked.isAlive()) this.attacked=null;
        }
        else{
            if(getX()>attacked.getX()) left();
            else if(getX()<attacked.getX()) right();
            if(getY()>attacked.getY())up();
            else if(getY()<attacked.getY())down();
        }
    }
    else if(random.nextInt((3-1)+1)==1){ //33% chance to move randomly
        switch(random.nextInt((4 - 1) + 1) + 1){
            case 1: up(); break;
            case 2: down(); break;
            case 3: left(); break;
            case 4: right(); break;
            default: break;
        }
    }
    }
    @Override
    public int getDistance(BasePlayer target){
        int a = Math.abs(target.getY()-getY());
        int b = Math.abs(target.getX()-getX());

        return (int) Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
    }
}
