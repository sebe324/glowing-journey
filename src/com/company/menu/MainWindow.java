package com.company.menu;

import com.company.game.GameField;
import com.company.game.GameMap;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private GameField game;
    public MainWindow(int width, int height, GameMap gameMap){
        setSize(width, height);
        setLocationRelativeTo(null);
        game = new GameField(gameMap);
        add(game);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public GameField getGame() {
        return game;
    }
}
