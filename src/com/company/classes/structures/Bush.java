package com.company.classes.structures;

import com.company.GameMap;

public class Bush extends BaseStructure {

    public Bush(int x, int y, String name, GameMap gameMap) {
        super(x, y, name, gameMap);
        this.setDestructible(false);
        this.uploadImage("Wall.png");
    }
}
