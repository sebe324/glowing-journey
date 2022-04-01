package com.company.classes.particles;

import javax.swing.*;
import java.awt.*;

public class Particle {
    private int x;
    private int y;
    private Image image;

    public Particle(int x, int y, String imagePath) {
        this.x = x;
        this.y = y;
        this.image = new ImageIcon(imagePath).getImage();
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    public int getXWindow(){
        return x*50;
    }
    public int getYWindow(){
        return y*50;
    }
}
