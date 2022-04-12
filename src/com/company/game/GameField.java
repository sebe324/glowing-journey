package com.company.game;

import com.company.classes.GameObj;
import com.company.classes.characters.player.BasePlayer;
import com.company.classes.particles.Particle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class GameField extends JPanel {
    private GameMap gameMap;
    public GameField(GameMap gameMap){
        this.gameMap = gameMap;
        setFocusable(true);
        addKeyListener(new FieldKeyListener());
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Particle particle : gameMap.particles){
            g.drawImage(particle.getImage(), particle.getXWindow(), particle.getYWindow(), this);
        }
        for(GameObj thing : gameMap.gameObjs){
            g.drawImage(thing.getImage(), thing.getXWindow(), thing.getYWindow(), this);
        }
        for(BasePlayer player: gameMap.getPlayers()){
            g.drawImage(player.getImage(), player.getXWindow(), player.getYWindow(), this);
            g.drawString(""+player.getName(), player.getXWindow(), player.getYWindow());
            g.drawString("Health "+player.getHp(), player.getXWindow(), player.getYWindow()-12);
            g.drawString("Mana "+player.getMana(), player.getXWindow(), player.getYWindow()-24);
        }
    }
    public class FieldKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            super.keyPressed(e);
            int key = e.getKeyCode();
            for(int i=0; i < gameMap.getPlayers().size(); i++) {
                BasePlayer player=gameMap.getPlayers().get(i);
                    if(key==player.getUpKey())  player.up();
                    else if(key==player.getDownKey()) player.down();
                    else if(key==player.getLeftKey()) player.left();
                    else if (key==player.getRightKey()) player.right();
                    else if (key==player.getLeftAttackKey()) {
                        player.setAttackLeftImage();
                        player.attack(player.getX()-player.getDamageRange(), player.getY());

                        //timer
                        new Timer().schedule(
                                new TimerTask() {
                                    @Override
                                    public void run() {
                                        player.setBaseImageToImage();
                                        repaint();
                                    }
                                }, 200
                        );
                    }
                    else if(key==player.getRightAttackKey()) {
                        player.attack(player.getX()+player.getDamageRange(),player.getY());
                        player.setAttackRightImage();

                        //timer
                        new Timer().schedule(
                                new TimerTask() {
                                    @Override
                                    public void run() {
                                        player.setBaseImageToImage();
                                        repaint();
                                    }
                                }, 200
                        );
                    }
                    else if(key==player.getAbilityOneKey()) player.abilityOne();
                    else if(key==player.getAbilityTwoKey()) player.abilityTwo();
            }
            if(key==KeyEvent.VK_ESCAPE){
                System.out.print(gameMap.filePath);
                gameMap.save(gameMap.filePath);
            }
            validate();
            repaint();
        }
    }
}
