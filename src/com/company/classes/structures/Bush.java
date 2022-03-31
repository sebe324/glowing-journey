package com.company.classes.structures;

public class Bush extends BaseStructure {

    public Bush(int x, int y, String name) {
        super(x, y, name);
        this.setDestructible(false);
        this.uploadImage("Wall.png");
    }
}
