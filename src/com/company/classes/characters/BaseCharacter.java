package com.company.classes.characters;

import com.company.Map;
import com.company.classes.Something;
import com.company.enums.DamageRange;
import com.company.enums.DamageType;

import javax.swing.*;
import java.awt.*;

import static com.company.Map.occupiedCells;

public abstract class BaseCharacter extends Something implements BaseCharacterInterface{

    private int maxHp, hp, mana, maxMana, level, attackDmg;
    private int hpRegen, manaRegen;
    private String name;
    protected String className;
    private int id;
    private DamageType damageType;
    private DamageRange damageRange;
    private Image image, baseImage, attackLeftImage, attackRightImage;
    public BaseCharacter(int x, int y, String name){
        super(x,y,name);
        this.id = ++Map.characterCount;
    }

    public BaseCharacter() {
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if(hp>this.maxHp){
            this.hp = this.maxHp;
        }
        else
            this.hp=hp;

    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if(this.mana>this.maxHp){
            this.mana=maxMana;
        }
        else
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public void setAttackDmg(int attackDmg) {
        this.attackDmg = attackDmg;
    }

    public int getHpRegen() {
        return hpRegen;
    }

    public void setHpRegen(int hpRegen) {
        this.hpRegen = hpRegen;
    }

    public int getManaRegen() {
        return manaRegen;
    }

    public void setManaRegen(int manaRegen) {
        this.manaRegen = manaRegen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getBaseImage() {
        return baseImage;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setBaseImage() {
        this.image = this.baseImage;
    }

    public Image getAttackLeftImage() {
        return attackLeftImage;
    }

    public void setAttackLeftImage() {
        this.image = this.attackLeftImage;
    }

    public Image getAttackRightImage() {
        return attackRightImage;
    }

    public void setAttackRightImage() {
        this.image = this.attackRightImage;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public DamageRange getDamageRange() {
        return damageRange;
    }

    public void setDamageRange(DamageRange damageRange) {
        this.damageRange = damageRange;
    }

    @Override
    public void loseHealth(int amount){
        setHp(getHp()-amount);
    }
    @Override
    public void regenerateHp(int amount){
        setHp(getHp()+amount);
    }
    @Override
    public void loseMana(int amount){
        setMana(getMana()-amount);
    }
    @Override
    public void regenerateMana(int amount){
        setMana(getMana()+amount);
    }
    @Override
    public void attack(BaseCharacter attacked){
        attacked.loseHealth(this.attackDmg);
    }
    @Override
    public void levelUp(){
        setLevel(getLevel()+1);
    }
    @Override
    public void info(){

    }
    public void uploadImage(String baseImage, String attackLeftImage, String attackRightImage){
        this.baseImage = new ImageIcon(baseImage).getImage();
        this.attackLeftImage = new ImageIcon(attackLeftImage).getImage();
        this.attackRightImage = new ImageIcon(attackRightImage).getImage();
        setBaseImage();
    }
    public void tryChangePosition(int newPosX, int newPosY){
    if(occupiedCells[newPosX][newPosY]==0){
        occupiedCells[newPosX][newPosY]=this.id;
        System.out.println(this.getX());
        System.out.println(this.getY());
        this.setY(newPosY);
        this.setX(newPosX);
        System.out.println(occupiedCells[newPosX][newPosY]);
    }
    else{
        loseHealth(30);
    }
    }
    public void left(){
        int newPositionX = this.getX() > 40 ? this.getX() - 40: 0;
        tryChangePosition(newPositionX, this.getY());
        System.out.println(this.getX());
    }
    public void right(){
        int newPositionX = this.getX()<320 ? this.getX()+40 : 320;
        tryChangePosition(newPositionX, this.getY());
    }
    public void up(){
        int newPositionY=this.getY() > 40 ? this.getY() - 40 : 0;
        tryChangePosition(this.getX(), newPositionY);
    }
    public void down(){
        int newPositionY=this.getY() < 320 ? this.getY() + 40 :320;
        tryChangePosition(this.getX(), newPositionY);
    }
}
