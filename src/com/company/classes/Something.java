package com.company.classes;

import com.company.GameMap;
import com.company.classes.particles.Particle;
import com.company.enums.ClassType;

import javax.swing.*;
import java.awt.*;

public abstract class Something {
    private int x;
    private int y;
    private int maxHp, hp;
    private String name;
    private ClassType type;
    private Image image, baseImage;
    private int id;
    private boolean isAlive;
    private GameMap gameMap;
    protected Something(int x, int y, String name, ClassType type, GameMap gameMap) {
        this.x = x;
        this.y = y;
        this.gameMap = gameMap;
        this.name = name;
        this.type=type;
        this.id = ++gameMap.characterCount;
        this.isAlive=true;
        gameMap.occupiedCells[this.x][this.y]=this.id;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public ClassType getType() {
        return type;
    }

    public void setType(ClassType type) {
        this.type = type;
    }

    protected Something() {
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        if(hp>this.maxHp){
            this.hp = this.maxHp;
        }
        else if(hp<=0){
            gameMap.occupiedCells[this.x][this.y]=0;
            this.isAlive=false;
            gameMap.characterCount--;
            gameMap.particles.add(new Particle(this.x, this.y, "images/particles/destroyed"+this.name+".png"));
            int tmp= getIdThings();
            gameMap.things.remove(getIdThings());
            for(int i = tmp; i< gameMap.things.size(); i++){
                gameMap.things.get(i).id-=1;
                gameMap.occupiedCells[gameMap.things.get(i).getX()][gameMap.things.get(i).getY()]-=1;
            }
        }
        else
            this.hp=hp;

    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void uploadImage(String baseImage){
        this.baseImage = new ImageIcon(baseImage).getImage();
        setBaseImage();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getBaseImage() {
        return baseImage;
    }

    public void setBaseImage() {
        this.image=this.baseImage;
    }
    public int getId(){
        return id;
    }
    public int getIdThings() {
        return id-1;
    }

    public int getXWindow(){
        return x*50;
    }
    public int getYWindow(){
        return y*50;
    }
    public void loseHp(int amount){
        setHp(getHp()-amount);
    }
}

