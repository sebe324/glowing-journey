package com.company.classes;

import com.company.Map;
import com.company.classes.characters.BaseCharacter;
import com.company.classes.particles.Particle;
import com.company.enums.ClassType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.company.Map.*;

public abstract class Something {
    private int x;
    private int y;
    private int maxHp, hp;
    private String name;
    private ClassType type;
    private Image image, baseImage;
    private int id;
    private boolean isAlive;
    public Something(int x, int y, String name, ClassType type) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.type=type;
        this.id = ++Map.characterCount;
        this.isAlive=true;
        occupiedCells[this.x][this.y]=this.id;
        System.out.println("X "+this.x);
        System.out.println("Y "+this.y);
        System.out.println("Psycha siedzi" +  occupiedCells[this.x][this.y]);
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

    public Something() {
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        if(hp>this.maxHp){
            this.hp = this.maxHp;
        }
        else if(hp<=0){
            occupiedCells[this.x][this.y]=0;
            this.isAlive=false;
            particles.add(new Particle(this.x, this.y, "images/particles/destroyed"+this.name+".png"));
            int tmp= getIdThings();
            System.out.println("deleted : " + things.get(getIdThings()));
            things.remove(getIdThings());
            for(int i=tmp; i<things.size(); i++){
                things.get(i).id-=1;
                occupiedCells[things.get(i).getX()][things.get(i).getY()]-=1;
                System.out.println("i"+i+"id"+things.get(i).id+"name"+things.get(i).name);
            }
            System.out.println("things size" + things.size());
            for(int i=0; i<things.size(); i++){
                System.out.println("i"+i+"id"+things.get(i).id+"name"+things.get(i).name);
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

