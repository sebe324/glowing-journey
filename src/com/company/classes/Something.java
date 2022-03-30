package com.company.classes;

import javax.swing.*;
import java.awt.*;

public abstract class Something {
    private int x;
    private int y;
    private String name;
    private Image image, baseImage;
    public Something(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
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
}
