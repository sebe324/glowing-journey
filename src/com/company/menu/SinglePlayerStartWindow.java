package com.company.menu;

import com.company.classes.characters.player.Gunslinger;
import com.company.classes.characters.player.Healer;
import com.company.classes.characters.player.Warrior;
import com.company.classes.characters.player.Wizard;
import com.company.game.GameLoop;
import com.company.game.GameMap;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class SinglePlayerStartWindow extends JFrame {
    private String selectedClass="";
    SinglePlayerStartWindow(GameMap gameMap){
        setLocationRelativeTo(null);
        Runnable r = new GameLoop(gameMap);
        setSize(600,400);
        JLabel label = new JLabel("Select your class");
        add(label);
        label.setBounds(10,10,120,20);
        List<JButton> classSelect = new ArrayList<>();
        classSelect.add(new JButton("Warrior"));
        classSelect.add(new JButton("Gunslinger"));
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
        JLabel label4 = new JLabel("Save name: ");
        label4.setBounds(200, 150, 200,30);
        add(label4);
        JTextField saveName=new JTextField();
        saveName.setBounds(200,200,200,30);
        add(saveName);
        JButton start = new JButton("start");
        start.setBounds(0,0, 80,20);
        start.addActionListener(e -> {
            if(selectedClass!="") {
                switch (selectedClass) {
                    case "Warrior":
                        gameMap.gameObjs.add(new Warrior(10, 10, characterName.getText(), 120, 1000, 1000, 200, 200, 10, 5, 0, 3, gameMap));
                        break;
                    case "Gunslinger":
                        gameMap.gameObjs.add(new Gunslinger(10, 10, characterName.getText(), 120, 1000, 1000, 200, 200, 10, 5, 0, 3, gameMap));
                        break;
                    case "Wizard":
                        gameMap.gameObjs.add(new Wizard(10, 10, characterName.getText(), 120, 1000, 1000, 200, 200, 10, 5, 0, 3, gameMap));
                        break;
                    case "Healer":
                        gameMap.gameObjs.add(new Healer(10, 10, characterName.getText(), 120, 1000, 1000, 200, 200, 10, 5, 0, 3, gameMap));
                        break;
                    default:
                        label.setText("Please pick a class!");
                        break;
                }
                try {
                    File file = new File("saves/"+saveName.getText()+".txt");
                    if (file.createNewFile()) {
                        gameMap.runWindow();
                        gameMap.filePath = "saves/"+saveName.getText()+".txt";
                        gameMap.generate(10);
                        gameMap.save(gameMap.filePath);
                        new Thread(r).start();
                        dispose();
                    }
                } catch (IOException er) {
                    er.printStackTrace();
                }
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
