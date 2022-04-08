package com.company;

import javax.swing.*;
public class MainWindow extends JFrame {
    private GameField game;
    public MainWindow(int width, int height, Map map){
        setSize(width, height);
        setLocationRelativeTo(null);
        game = new GameField(map);
        add(game);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public GameField getGame() {
        return game;
    }
}
