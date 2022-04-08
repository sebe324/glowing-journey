package com.company;

import javax.swing.*;

public class MenuWindow extends JFrame {
private MainMenu mainMenu;
public MenuWindow(Map map){
setSize(1000,1000);
setLocationRelativeTo(null);
mainMenu = new MainMenu(map);
add(mainMenu);
    setVisible(true);
}
}
