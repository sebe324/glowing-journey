package com.company.menu;

import com.company.classes.characters.player.*;
import com.company.game.GameLoop;
import com.company.game.GameMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class ArenaStartWindow extends JFrame {
private List<String> selectedClasses = new ArrayList<>();
private List<JTextField> characterNames = new ArrayList<>();
ArenaStartWindow(GameMap gameMap){
    setLocationRelativeTo(null);
    Runnable r = new GameLoop(gameMap);
    setSize(600,400);
    for(int i=0; i<2; i++){
        selectedClasses.add("");
        characterNames.add(new JTextField());
        JLabel label = new JLabel("Player "+(i+1)+" class");
        label.setBounds(i*350+10, 10, 120, 20);
        add(label);
        List<JButton> classSelect = new ArrayList<>();
        classSelect.add(new JButton("Warrior"));
        classSelect.add(new JButton("Archer"));
        classSelect.add(new JButton("Wizard"));
        classSelect.add(new JButton("Healer"));
        for(int j=0; j<classSelect.size(); j++){
            classSelect.get(j).setBounds(i*350+10, 25*(j+1)+10, 120, 20);
            int tmp2 = i;
            int tmp= j;
            classSelect.get(j).addActionListener(e->{
                selectedClasses.set(tmp2,classSelect.get(tmp).getText());
                label.setText(selectedClasses.get(tmp2));

            });
            add(classSelect.get(j));
        }
        JLabel label3= new JLabel("Player "+(i+1)+" nickname: ");
        label3.setBounds(i*350+10, 250, 200, 20);
       add(label3);
        characterNames.get(i).setBounds(i*350+10, 300, 200, 30);
        add(characterNames.get(i));
    }
    JButton start = new JButton("start");
    start.addActionListener(e->{
        if(!selectedClasses.get(0).equals("") && !selectedClasses.get(1).equals("")) {
            for (int i = 0; i < 2; i++) {
                switch (selectedClasses.get(i)) {
                    case "Warrior":
                        gameMap.things.add(new Warrior(10*i, 10, characterNames.get(i).getText(), 120, 1000, 1000, 200, 200, 10, gameMap));
                        break;
                    case "Archer":
                        gameMap.things.add(new Archer(10*i, 10, characterNames.get(i).getText(), 120, 1000, 1000, 200, 200, 10, gameMap));
                        break;
                    case "Wizard":
                        gameMap.things.add(new Wizard(10*i, 10, characterNames.get(i).getText(), 120, 1000, 1000, 200, 200, 10, gameMap));
                        break;
                    case "Healer":
                        gameMap.things.add(new Healer(10*i, 10, characterNames.get(i).getText(), 120, 1000, 1000, 200, 200, 10, gameMap));
                        break;
                    default:

                        break;
                }
            }
            BasePlayer player2=gameMap.getPlayers().get(1);
            player2.setUpKey(KeyEvent.VK_I);
            player2.setLeftKey(KeyEvent.VK_J);
            player2.setRightKey(KeyEvent.VK_L);
            player2.setDownKey(KeyEvent.VK_K);
            player2.setLeftAttackKey(KeyEvent.VK_U);
            player2.setRightAttackKey(KeyEvent.VK_O);
            gameMap.runWindow();
            gameMap.mainWindow.getGame().setBackground(new Color(255, 234, 167));
            new Thread(r).start();
            dispose();
        }
    });
    start.setBounds(160,0,80,20);
    JButton close = new JButton("close");
    close.setBounds(260,0,80,20);
    close.addActionListener(e -> dispose());
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.add(start);
    panel.add(close);
    add(panel);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}
}
