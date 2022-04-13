package com.company.classes.structures;

import com.company.game.GameMap;

public class Bush extends BaseStructure {

    public Bush(int x, int y, java.lang.String name, GameMap gameMap) {
        super(x, y, name, gameMap);
        this.setDestructible(false);
        this.uploadImage("images/bush/bush.png");
    }
}
