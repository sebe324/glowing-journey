package com.company.classes.characters.npcs;

import com.company.classes.characters.BaseCharacter;
import com.company.classes.characters.player.BasePlayer;
import com.company.enums.ClassType;

import static com.company.Map.getPlayers;

public abstract class BaseMonster extends BaseCharacter implements BaseMonsterInterface{
    private BasePlayer attacked=null;
    private int range;
    public BaseMonster(int x, int y, String name, int range) {
        super(x, y, name, ClassType.MONSTER);
        this.range=range;
    }
    @Override
    public boolean IsPlayerInRange() {
        if(this.attacked==null) {
            for (BasePlayer player : getPlayers()) {

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

    @Override
    public void pathFindToPlayer() {
    if(IsPlayerInRange()){
        if(getDistance(this.attacked)==1){
            attack("right");
            attack("left");
            if(!this.attacked.isAlive()) this.attacked=null;
        }
        else{
            if((this.attacked.getX()-getX())<0){
                left();
                System.out.println("Moving left");
            }
            else if((this.attacked.getX()-getX())>0){
                right();
                System.out.println("Moving right");
            }
            else if((this.attacked.getY()-getY())<0){
                up();
                System.out.println("Moving up");
            }
            else if((this.attacked.getY()-getY())>0){
                down();
                System.out.println("Moving down");
            }
        }
        System.out.println("target: " + this.attacked);
    }
    }
    @Override
    public int getDistance(BasePlayer target){
        int a = Math.abs(target.getY()-getY());
        int b = Math.abs(target.getX()-getX());

        return (int) Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
    }
}
