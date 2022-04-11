package com.company.classes.characters.npcs;

import com.company.game.GameMap;
import com.company.classes.characters.BaseCharacter;
import com.company.classes.characters.player.BasePlayer;
import com.company.enums.ClassType;

public abstract class BaseMonster extends BaseCharacter implements BaseMonsterInterface{
    private BasePlayer attacked=null;
    private int range;
    private GameMap gameMap;
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
    if(IsPlayerInRange()){
        if(getDistance(this.attacked)==1){
            attack("right");
            attack("left");
            attack("up");
            attack("down");
            if(!this.attacked.isAlive()) this.attacked=null;
        }
        else{
            if((this.attacked.getX()-getX())<0){
                left();
            }
            else if((this.attacked.getX()-getX())>0){
                right();
            }
            else if((this.attacked.getY()-getY())<0){
                up();
            }
            else if((this.attacked.getY()-getY())>0){
                down();
            }
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
