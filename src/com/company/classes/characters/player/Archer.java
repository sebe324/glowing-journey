package com.company.classes.characters.player;

import com.company.game.GameMap;
import static com.company.enums.DamageType.PHYSICAL;

public class Archer extends BasePlayer {
    public Archer(int x, int y, java.lang.String name, int attackDmg, int maxHp, int hp, int maxMana, int mana, int hpRegen, GameMap gameMap){
        super(x,y, name, gameMap);
        this.setAttackDmg(attackDmg);
        this.setMaxHp(maxHp);
        this.setHp(hp);
        this.setMaxMana(maxMana);
        this.setMana(mana);
        this.setHpRegen(hpRegen);
        this.setDamageRange(4);
        this.setDamageType(PHYSICAL);
        this.uploadImage("images/archer/archer.png", "images/archer/archerLeftAttack.png", "images/archer/archerRightAttack.png");
    }
}
