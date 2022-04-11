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
                try {
                    gameMap.filePath = ("saves/"+JOptionPane.showInputDialog("Nazwa zapisu: ")+".txt");
                    File file=new File(gameMap.filePath);
                    if (file.createNewFile()) {
                       new SinglePlayerStartWindow(gameMap);
                        gameMap.menuWindow.dispose();
                        System.out.println("File created: " + file.getName());
                    } else {
                        System.out.println("File already exists");
                    }
                } catch (IOException er) {
                    System.out.println("An error occurred.");
                    er.printStackTrace();
                }
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
        });
        add(buttonExit);
        add(buttonStart);
        add(buttonArena);
        add(buttonLoad);
    }
}