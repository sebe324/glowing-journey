package com.company.menu;

import com.company.classes.characters.player.*;
import com.company.game.GameLoop;
import com.company.game.GameMap;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaStartWindow extends JFrame {
private List<String> selectedClasses = new ArrayList<>();
private List<JTextField> characterNames = new ArrayList<>();
ArenaStartWindow(GameMap gameMap){
    setLocationRelativeTo(null);
    Runnable r = new GameLoop(gameMap);
    setSize(600,400);
    JLabel saveLabel = new JLabel("Save name");
    saveLabel.setBounds(160,100,100,20);
    add(saveLabel);
    JTextField saveName = new JTextField();
    saveName.setBounds(160,150,100,20);
    add(saveName);
    for(int i=0; i<2; i++){
        selectedClasses.add("");
        characterNames.add(new JTextField());
        JLabel label = new JLabel("Player "+(i+1)+" class");
        label.setBounds(i*350+10, 10, 120, 20);
        add(label);
        List<JButton> classSelect = new ArrayList<>();
        classSelect.add(new JButton("Warrior"));
        classSelect.add(new JButton("Gunslinger"));
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
                        gameMap.gameObjs.add(new Warrior(10*i, 10, characterNames.get(i).getText(), 120, 1000, 1000, 200, 200, 10, 5, 0,3,gameMap));
                        break;
                    case "Gunslinger":
                        gameMap.gameObjs.add(new Gunslinger(10*i, 10, characterNames.get(i).getText(), 120, 1000, 1000, 200, 200, 10, 5, 0,3,gameMap));
                        break;
                    case "Wizard":
                        gameMap.gameObjs.add(new Wizard(10*i, 10, characterNames.get(i).getText(), 120, 1000, 1000, 200, 200, 10, 5,0,3,gameMap));
                        break;
                    case "Healer":
                        gameMap.gameObjs.add(new Healer(10*i, 10, characterNames.get(i).getText(), 120, 1000, 1000, 200, 200, 10, 5, 0,3,gameMap));
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
            player2.setAbilityOneKey(KeyEvent.VK_7);
            player2.setAbilityTwoKey(KeyEvent.VK_8);
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
