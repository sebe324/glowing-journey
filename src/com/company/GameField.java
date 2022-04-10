package com.company;

import com.company.classes.Something;
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
        for(Something thing : gameMap.things){
            g.drawImage(thing.getImage(), thing.getXWindow(), thing.getYWindow(), this);
            g.drawString(""+thing.getName(), thing.getXWindow(), thing.getYWindow());
            g.drawString(""+thing.getHp(), thing.getXWindow(), thing.getYWindow()-12);
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
                        player.attack("left");

                        //timer
                        new Timer().schedule(
                                new TimerTask() {
                                    @Override
                                    public void run() {
                                        player.setBaseImage();
                                        repaint();
                                    }
                                }, 200
                        );
                    }
                    else if(key==player.getRightAttackKey()) {
                        player.attack("right");
                        player.setAttackRightImage();

                        //timer
                        new Timer().schedule(
                                new TimerTask() {
                                    @Override
                                    public void run() {
                                        player.setBaseImage();
                                        repaint();
                                    }
                                }, 200
                        );
                    }

            }
            if(key==KeyEvent.VK_ESCAPE){
                gameMap.save("saves/koks.txt");
            }
            validate();
            repaint();
        }
    }
}
