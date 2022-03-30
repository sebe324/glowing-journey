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
            g.drawImage(thing.getImage(), thing.getX(), thing.getY(), this);
        }
        g.drawImage(player.getImage(), player.getX(), player.getY(), this);
        g.drawString(""+player.getHp(), player.getX(), player.getY()+12);
        g.drawString(""+player.getName(), player.getX(), player.getY()+24);
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
            }
            validate();
            repaint();
        }
    }
}
