package com.company;

import com.company.classes.Something;
import com.company.classes.characters.BaseCharacter;
import com.company.classes.characters.player.BasePlayer;
import com.company.classes.characters.player.Warrior;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.Map.menuWindow;
import static java.awt.Color.*;

public class MainMenu extends JLabel {
    File savesFolder = new File("saves");
    List<File> saves = Arrays.asList(savesFolder.listFiles());
    Main thread = new Main();
    public MainMenu() {
        JButton buttonStart = new JButton("new game");
        buttonStart.setBounds(400, 100, 200, 60);
        buttonStart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    File file=new File("saves/"+JOptionPane.showInputDialog("Nazwa zapisu: ")+".txt");
                    if (file.createNewFile()) {
                       SinglePlayerStartWindow nw = new SinglePlayerStartWindow();
                        menuWindow.dispose();
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
                      //Menu with saves
                        /*  menuWindow.dispose();
                        map.runWindow();
                        thread.start();*/
                    }
                });
            }
        JButton buttonExit = new JButton("exit");
        buttonExit.setBounds(400, 400, 200, 60);
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuWindow.dispose();
            }
        });
        add(buttonExit);
        add(buttonStart);
        add(buttonArena);
        add(buttonLoad);
    }
}
