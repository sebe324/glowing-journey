package com.company.styles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuButton2 extends JButton {
    public MenuButton2(String text){
        super(text);
        setBorder(BorderFactory.createLineBorder(new Color(243, 156, 18),2));
        setBackground(new Color(241, 196, 15));
        setForeground(new Color(127, 140, 141));
        setSize(150,50);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt){
                setBackground(new Color(243, 156, 18));
                setForeground(Color.WHITE);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                setBackground(new Color(241, 196, 15));
                setForeground(new Color(127, 140, 141));
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        addActionListener(e -> {
            setBackground(new Color(241, 196, 15));
            setForeground(new Color(127, 140, 141));
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        });
    }
}
