package com.company.styles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.Color.WHITE;

public class MenuButton extends JButton{
    public MenuButton(String text){
        super(text);
        setBorder(BorderFactory.createMatteBorder(0,5,0,0,new Color(9, 132, 227) ));
        setBackground(new Color(223, 230, 233));
        setForeground(new Color(45, 52, 54));
        setSize(200,60);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                setBackground(new Color(9, 132, 227));
                setForeground(WHITE);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent evt){
                setBackground(new Color(223, 230, 233));
                setForeground(new Color(45, 52, 54));
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        addActionListener(e -> {
            setBackground(new Color(223, 230, 233));
            setForeground(new Color(45, 52, 54));
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        });
    }
}