package com.company.menu;

import com.company.game.GameLoop;
import com.company.game.GameMap;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class LoadWindow extends JFrame {
LoadWindow(File savesFolder){
    List<File> saves=Arrays.asList(savesFolder.listFiles());
setLocationRelativeTo(null);
setSize(600,400);
    JPanel container = new JPanel();
    container.setPreferredSize(new Dimension(200,saves.size()*40+10));
    container.setLayout(null);
JScrollPane scrPane = new JScrollPane(container);
for(int i=0; i<saves.size(); i++){
    File file=saves.get(i);
    JButton saveButton = new JButton(file.getName());
    saveButton.setBounds(10, i*40+10, 120, 20);
    saveButton.addActionListener(e->{
        GameMap gameMap=new GameMap();
       gameMap.load(file);
       gameMap.runWindow();
       System.out.println(gameMap.occupiedCells[gameMap.gameObjs.get(1).getX()][gameMap.gameObjs.get(1).getY()]);
       dispose();
        Runnable r = new GameLoop(gameMap);
        new Thread(r).start();

    });
    container.add(saveButton);
    JButton deleteButton = new JButton("delete");
    deleteButton.setBounds(140,i*40+10,60,20);
    deleteButton.addActionListener(e->{
        container.remove(deleteButton);
        container.remove(saveButton);
        file.delete();
        container.repaint();
    });
    container.add(deleteButton);
}
add(scrPane);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
}
}
