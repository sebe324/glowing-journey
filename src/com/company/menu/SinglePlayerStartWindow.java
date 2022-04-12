package com.company.menu;

import com.company.classes.characters.player.Archer;
import com.company.classes.characters.player.Healer;
import com.company.classes.characters.player.Warrior;
import com.company.classes.characters.player.Wizard;
import com.company.game.GameLoop;
import com.company.game.GameMap;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
public class SinglePlayerStartWindow extends JFrame {
    private String selectedClass;
    SinglePlayerStartWindow(GameMap gameMap){
        setLocationRelativeTo(null);
        Runnable r = new GameLoop(gameMap);
        setSize(600,400);
        JLabel label = new JLabel("Select your class");
        add(label);
        label.setBounds(10,10,120,20);
        List<JButton> classSelect = new ArrayList<>();
        classSelect.add(new JButton("Warrior"));
        classSelect.add(new JButton("Archer"));
        classSelect.add(new JButton("Wizard"));
        classSelect.add(new JButton("Healer"));
        JLabel label2 = new JLabel();
        for(int i=0; i<classSelect.size(); i++){
            classSelect.get(i).setBounds(10,25*(i+1)+10, 120, 20);
            int tmp = i;
            classSelect.get(i).addActionListener(e -> {
            selectedClass=classSelect.get(tmp).getText();
            label2.setText(selectedClass);
            });
            add(classSelect.get(i));
        }
        label2.setBounds(10, 300, 100,20);
        add(label2);
        JLabel label3 = new JLabel("Your nickname: ");
        label3.setBounds(200, 50, 200,30);
        add(label3);
        JTextField characterName = new JTextField();
        characterName.setBounds(200,100,200,30);
        add(characterName);
        JButton start = new JButton("start");
        start.setBounds(0,0, 80,20);
        start.addActionListener(e -> {
            switch(selectedClass){
                case "Warrior":
                    gameMap.gameObjs.add(new Warrior(10,10,characterName.getText(),120,1000,1000,200,200,10, 5, gameMap));
                    gameMap.runWindow();
                    new Thread(r).start();
                    dispose();
                    break;
                case "Archer":
                    gameMap.gameObjs.add(new Archer(10,10,characterName.getText(),120,1000,1000,200,200,10,5,gameMap));
                    gameMap.runWindow();
                    new Thread(r).start();
                    dispose();
                    break;
                case "Wizard":
                    gameMap.gameObjs.add(new Wizard(10,10,characterName.getText(),120,1000,1000,200,200,10,5,gameMap));
                    gameMap.runWindow();
                    new Thread(r).start();
                    dispose();
                    break;
                case "Healer":
                    gameMap.gameObjs.add(new Healer(10,10,characterName.getText(),120,1000,1000,200,200,10,5,gameMap));
                    gameMap.runWindow();
                    new Thread(r).start();
                    dispose();
                    break;
                default:
                    label.setText("Please pick a class!");
                    break;
            }

        });
        JButton close = new JButton("close");
        close.setBounds(100,0,80,20);
        close.addActionListener(e -> dispose());
        JPanel panel = new JPanel();
        panel.setBounds(200,300,200,20);
        panel.add(start);
        panel.add(close);
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
