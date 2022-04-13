package com.company.menu;

import com.company.game.GameMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static java.awt.Color.*;

public class MainMenu extends JLabel {
    File savesFolder = new File("saves");
    private List<File> saves = Arrays.asList(savesFolder.listFiles());
    public MainMenu(GameMap gameMap) {
        JButton buttonStart = new JButton("new game");
        buttonStart.setBounds(400, 100, 200, 60);
        buttonStart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                       new SinglePlayerStartWindow(gameMap);
                        gameMap.menuWindow.dispose();
            }
        });
        JButton buttonArena = new JButton("1v1");
                buttonArena.setBounds(400,200,200,60);
                buttonArena.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    new ArenaStartWindow(gameMap);
                    gameMap.menuWindow.dispose();
                    }
                });

        JButton buttonLoad = new JButton("load game");
                buttonLoad.setBounds(400,300,200,60);
            if (saves.isEmpty()) {
                buttonLoad.setBackground(gray);
                buttonLoad.setForeground(white);
            } else {
                buttonLoad.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        gameMap.menuWindow.dispose();
                   new LoadWindow(savesFolder);
                    }
                });
            }
        JButton buttonExit = new JButton("exit");
        buttonExit.setBounds(400, 400, 200, 60);
        buttonExit.addActionListener(e -> {
                gameMap.menuWindow.dispose();
                System.exit(0);
        });
        JTextArea description = new JTextArea("Get to 1000 points and win, every kill gives you 10 points.\n If you lose your 3 lives you lose the game. GL");
        description.setBounds(400,500,350,60);
        JTextArea descriptionPL = new JTextArea("Zdobadz 1000 punktow i wygraj, kazdy kill daje ci 10 punktow.\n Jezeli stracisz 3 zycia przegrywasz. Powodzenia");
        descriptionPL.setBounds(400,600,350,60);
        add(buttonExit);
        add(buttonStart);
        add(buttonArena);
        add(buttonLoad);
        add(description);
        add(descriptionPL);
    }
}
