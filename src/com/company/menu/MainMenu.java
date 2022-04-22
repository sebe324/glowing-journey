package com.company.menu;

import com.company.game.GameMap;
import com.company.styles.MenuButton;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import static java.awt.Color.*;

public class MainMenu extends JPanel {
    File savesFolder = new File("saves");
    private List<File> saves = Arrays.asList(savesFolder.listFiles());
    public MainMenu(GameMap gameMap) {
        setLayout(null);
        setBackground(new Color(253, 203, 110));
        setFocusable(true);
        JLabel title = new JLabel("Glowing Journey");
        title.setFont(new Font("Verdana",Font.BOLD, 40));
        title.setForeground(new Color(240, 147, 43));
        title.setBounds(50,20,400,60);
        add(title);
        JButton buttonStart = new MenuButton("new game");
        buttonStart.setLocation(50, 100);
        buttonStart.addActionListener(e -> {
                  gameMap.menuWindow.remove(this);
                  gameMap.menuWindow.add(new SinglePlayerStartWindow(gameMap));
            gameMap.menuWindow.revalidate();
            gameMap.menuWindow.repaint();
        });
        JButton buttonArena = new MenuButton("1v1");
                buttonArena.setLocation(50,200);
                buttonArena.addActionListener(e -> {
                    gameMap.menuWindow.remove(this);
                gameMap.menuWindow.add(new ArenaStartWindow(gameMap));
                gameMap.menuWindow.revalidate();
                gameMap.menuWindow.repaint();
                });

        JButton buttonLoad = new MenuButton("load game");
                buttonLoad.setLocation(50,300);
            if (saves.isEmpty()) {
                buttonLoad.setBackground(gray);
                buttonLoad.setForeground(white);
            } else {
                buttonLoad.addActionListener(e -> {
                    gameMap.menuWindow.remove(this);
                    gameMap.menuWindow.add(new LoadWindow(savesFolder, gameMap));
                    gameMap.menuWindow.revalidate();
                    gameMap.menuWindow.repaint();
                });
            }
        JButton buttonExit = new MenuButton("exit");
        buttonExit.setLocation(50, 400);
        buttonExit.addActionListener(e -> {
                gameMap.menuWindow.dispose();
                System.exit(0);
        });
        JTextArea description = new JTextArea("Get to 1000 points and win, every kill gives you 10 points.\n If you lose your 3 lives you lose the game. GL");
        description.setOpaque(false);
        description.setEditable(false);
        description.setFont(new Font("Verdana",Font.PLAIN, 14));
        description.setBounds(470,50,420,60);
        JTextArea descriptionPL = new JTextArea("Zdobadz 1000 punktow i wygraj, kazdy kill daje ci 10 punktow.\n Jezeli stracisz 3 zycia przegrywasz. Powodzenia");
        descriptionPL.setFont(new Font("Verdana",Font.PLAIN, 14));
        descriptionPL.setOpaque(false);
        descriptionPL.setEditable(false);
        descriptionPL.setBounds(470,100,450,60);
        add(buttonExit);
        add(buttonStart);
        add(buttonArena);
        add(buttonLoad);
        add(description);
        add(descriptionPL);
    }
}
