package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.Map.mainWindow;
import static com.company.Map.menuWindow;

public class MainMenu extends JLabel {
    Main thread = new Main();
    public MainMenu(Map map) {
        JButton buttonStart = new JButton("new game");
        buttonStart.setBounds(400, 100, 200, 60);
        buttonStart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                menuWindow.dispose();
                map.runWindow();
                thread.start();
            }
        });
        JButton buttonLoad = new JButton("load game");
                buttonLoad.setBounds(400,200,200,60);
        buttonLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton buttonExit = new JButton("exit");
        buttonExit.setBounds(400, 300, 200, 60);
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuWindow.dispose();
            }
        });
        add(buttonExit);
        add(buttonStart);
        add(buttonLoad);
    }
}
