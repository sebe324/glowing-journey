package com.company;

import com.company.classes.Something;
import com.company.classes.characters.BaseCharacter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameField extends JPanel {
    private Map map;
    private Something[] things;
    private BaseCharacter player;
    public GameField(Map map){
        this.map = map;
        this.things= map.getThings();
        this.player=map.getPlayer();
        System.out.println(player.getName());
        setFocusable(true);
        addKeyListener(new FieldKeyListener());
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Something thing : things){
            g.drawImage(thing.getImage(), thing.getXWindow(), thing.getYWindow(), this);
            g.drawString(""+thing.getClass(), thing.getXWindow(), thing.getYWindow());
            g.drawString(""+thing.getHp(), thing.getXWindow(), thing.getYWindow()-12);
        }
        g.drawImage(player.getImage(), player.getXWindow(), player.getYWindow(), this);
        g.drawString(""+player.getHp(), player.getXWindow(), player.getYWindow());
        g.drawString(""+player.getName(), player.getXWindow(), player.getYWindow()-12);
    }
    public class FieldKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            super.keyPressed(e);
            int key = e.getKeyCode();
            switch(key){
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
            validate();
            repaint();
        }
    }
}
