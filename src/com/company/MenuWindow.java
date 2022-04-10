package com.company;

import com.company.classes.characters.player.BasePlayer;

import javax.swing.*;

public class MenuWindow extends JFrame {
private MainMenu mainMenu;
public MenuWindow(){
setSize(1000,1000);
setLocationRelativeTo(null);
mainMenu = new MainMenu();
add(mainMenu);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
