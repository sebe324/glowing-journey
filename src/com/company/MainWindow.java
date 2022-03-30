package com.company;

import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow(int width, int height, Map map){
        setSize(width, height);
        setLocationRelativeTo(null);
        add(new GameField(map));
        setVisible(true);
    }
}
