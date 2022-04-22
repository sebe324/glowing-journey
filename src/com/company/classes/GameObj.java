package com.company.classes;

import com.company.classes.characters.player.BasePlayer;
import com.company.game.GameMap;
import com.company.classes.particles.Particle;
import com.company.enums.ClassType;

import javax.swing.*;
import java.awt.*;

public abstract class GameObj {
    private int x;
    private int y;
    private int maxHp;
    private int hp;
    private String name;
    private ClassType type;
    private Image image;
    private Image baseImage;
    private int id;
    private boolean isAlive;
    protected GameMap gameMap;
    protected GameObj(int x, int y, java.lang.String name, ClassType type, GameMap gameMap) {
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

    protected GameObj() {
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        if(hp>this.maxHp){
            this.hp = this.maxHp;
        }
        else if(hp<=0){
            if(this.type==ClassType.PLAYER){
                BasePlayer player =(BasePlayer)this;
                player.respawn();

            }else {
            removeObj();
            }
        }
        else
            this.hp=hp;

    }
    public void removeObj() {
        gameMap.occupiedCells[this.x][this.y] = 0;
        this.isAlive = false;
        gameMap.characterCount--;
        gameMap.particles.add(new Particle(this.x, this.y, "images/particles/destroyed" + this.name + ".png"));
        int tmp = getIdThings();
        gameMap.gameObjs.remove(getIdThings());
        for (int i = tmp; i < gameMap.gameObjs.size(); i++) {
            gameMap.gameObjs.get(i).id -= 1;
            gameMap.occupiedCells[gameMap.gameObjs.get(i).getX()][gameMap.gameObjs.get(i).getY()] -= 1;
        }
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
        gameMap.occupiedCells[this.x][this.y]=0;
        gameMap.occupiedCells[x][this.y]=this.id;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        gameMap.occupiedCells[this.x][this.y]=0;
        gameMap.occupiedCells[this.x][y]=this.id;
        this.y = y;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }
    public void uploadImage(java.lang.String baseImage){
        this.baseImage = new ImageIcon(baseImage).getImage();
        setBaseImageToImage();
    }

    public void setBaseImage(Image baseImage) {
        this.baseImage = baseImage;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setBaseImageToImage() {
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

