package com.company.classes;

import com.company.Map;

import javax.swing.*;
import java.awt.*;

import static com.company.Map.occupiedCells;

public abstract class Something {
    private int x;
    private int y;
    private String name;
    private Image image, baseImage;
    private int id;
    public Something(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.id = ++Map.characterCount;
        occupiedCells[this.x][this.y]=this.id;
    }

    public Something() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getXWindow(){
        return x*10;
    }
    public int getYWindow(){
        return y*10;
    }
}

