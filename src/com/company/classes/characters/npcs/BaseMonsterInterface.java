package com.company.classes.characters.npcs;

import com.company.classes.characters.BaseCharacter;
import com.company.classes.characters.player.BasePlayer;

public interface BaseMonsterInterface {
    boolean IsPlayerInRange();
    void pathFindToPlayer();
    int getDistance(BasePlayer target);
}
