package com.company;

import javax.swing.*;

public class MenuWindow extends JFrame {
private MainMenu mainMenu;
public MenuWindow(GameMap gameMap){
setSize(1000,1000);
setLocationRelativeTo(null);
mainMenu = new MainMenu(gameMap);
add(mainMenu);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}
}
