package com.company.menu;

import com.company.game.GameLoop;
import com.company.game.GameMap;
import com.company.styles.MenuButton;
import com.company.styles.MenuButton2;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class LoadWindow extends JPanel {
LoadWindow(File savesFolder, GameMap gameMap){
    List<File> saves=Arrays.asList(savesFolder.listFiles());
    setLayout(null);
    setBackground(new Color(253, 203, 110));
for(int i=0; i<saves.size(); i++){
    File file=saves.get(i);
    JButton saveButton = new MenuButton2(file.getName());
    saveButton.setLocation(10, i*70+10);
    saveButton.addActionListener(e->{
       gameMap.load(file);
       gameMap.menuWindow.dispose();
       gameMap.runWindow();
       System.out.println(gameMap.occupiedCells[gameMap.gameObjs.get(1).getX()][gameMap.gameObjs.get(1).getY()]);
        Runnable r = new GameLoop(gameMap);
        new Thread(r).start();

    });
    add(saveButton);
    JButton deleteButton = new MenuButton2("delete");
    deleteButton.setLocation(200,i*70+10);
    deleteButton.addActionListener(e->{
        remove(deleteButton);
        remove(saveButton);
        file.delete();
        repaint();
    });
    add(deleteButton);
}
JButton close=new MenuButton("Close");
close.setLocation(750,880);
    close.addActionListener(e->{
        gameMap.menuWindow.remove(this);
        gameMap.menuWindow.add(gameMap.menuWindow.getMainMenu());
        gameMap.menuWindow.revalidate();
        gameMap.menuWindow.repaint();
    });
add(close);
setVisible(true);
}
}
