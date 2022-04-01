package com.company;

import com.company.classes.Something;
import com.company.classes.characters.BaseCharacter;
import com.company.classes.particles.Particle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import static com.company.Map.*;

public class GameField extends JPanel {
    private Map map;
    public GameField(Map map){
        this.map = map;
        setFocusable(true);
        addKeyListener(new FieldKeyListener());
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Particle particle : particles){
            g.drawImage(particle.getImage(), particle.getXWindow(), particle.getYWindow(), this);
        }
        for(Something thing : things){
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
            for(int i=0; i < players.size(); i++) {
                BaseCharacter player=players.get(i);
                switch (key) {
                    case KeyEvent.VK_W:
                        player.up();
                        break;
                    case KeyEvent.VK_S:
                        player.down();
                        break;
                    case KeyEvent.VK_A:
                        player.left();
                        break;
                    case KeyEvent.VK_D:
                        player.right();
                        break;
                    case KeyEvent.VK_Q:
                        player.setAttackLeftImage();
                        player.attack("left");

                        //timer
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                                    @Override
                                    public void run() {
                                        player.setBaseImage();
                                        repaint();
                                    }
                                }, 200
                        );
                        break;
                    case KeyEvent.VK_E:
                        player.attack("right");
                        player.setAttackRightImage();

                        //timer
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                                    @Override
                                    public void run() {
                                        player.setBaseImage();
                                        repaint();
                                    }
                                }, 200
                        );
                        break;
                }
            }
            validate();
            repaint();
        }
    }
}
