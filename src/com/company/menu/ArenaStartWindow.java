package com.company.menu;

import com.company.classes.characters.player.*;
import com.company.game.GameLoop;
import com.company.game.GameMap;
import com.company.styles.MenuButton;
import com.company.styles.MenuButton2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ArenaStartWindow extends JPanel {
private List<String> selectedClasses = Arrays.asList("Warrior","Warrior");
private List<JTextField> characterNames = new ArrayList<>();
ArenaStartWindow(GameMap gameMap){
    Runnable r = new GameLoop(gameMap);
    setBackground(new Color(253, 203, 110));
    setLayout(null);
    JLabel saveLabel = new JLabel("Save name");
    saveLabel.setBounds(500,800,100,20);
    add(saveLabel);
    JTextField saveName = new JTextField();
    saveName.setBounds(500,830,200,30);
    add(saveName);
    for(int i=0; i<2; i++){
        characterNames.add(new JTextField());
        JLabel label = new JLabel(selectedClasses.get(i));
        JLabel label3= new JLabel("Player "+(i+1)+" nickname: ");
        if(i==0) {
            label.setBounds(300, 50, 120, 20);
            label3.setBounds(300, 400, 200, 20);
            characterNames.get(i).setBounds(300, 450, 150, 30);
        }
        else { label.setBounds(550,50,120,20);
            label3.setBounds(550, 400, 200, 20);
            characterNames.get(i).setBounds(550, 450, 150, 30);
        }
        add(label);
        List<JButton> classSelect = new ArrayList<>();
        classSelect.add(new MenuButton2("Warrior"));
        classSelect.add(new MenuButton2("Gunslinger"));
        classSelect.add(new MenuButton2("Wizard"));
        classSelect.add(new MenuButton2("Healer"));
        for(int j=0; j<classSelect.size(); j++){
            if(i==0)
                classSelect.get(j).setLocation(300, 70*(j+1)+10);
            else classSelect.get(j).setLocation(550, 70*(j+1)+10);
            int tmp2 = i;
            int tmp= j;
            classSelect.get(j).addActionListener(e->{
                selectedClasses.set(tmp2,classSelect.get(tmp).getText());
                label.setText(selectedClasses.get(tmp2));
                repaint();
            });
            add(classSelect.get(j));
        }
       add(label3);
        add(characterNames.get(i));
    }
    JButton start = new MenuButton("start");
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
                    gameMap.menuWindow.dispose();
                    gameMap.runWindow();
                }
            } catch (IOException er) {
                er.printStackTrace();
            }
        }
    });
    start.setLocation(500,880);
    JButton close = new MenuButton("close");
    close.setLocation(750,880);
    close.addActionListener(e -> {
        gameMap.menuWindow.remove(this);
        gameMap.menuWindow.add(gameMap.menuWindow.getMainMenu());
        gameMap.menuWindow.revalidate();
        gameMap.menuWindow.repaint();

    });
    add(start);
    add(close);
    setVisible(true);
}
    @Override
    protected void paintComponent(Graphics g){
    super.paintComponent(g);
        for (int i = 0; i < 2; i++) {
                    String tmp= selectedClasses.get(i).toLowerCase();
                    Image classImage=new ImageIcon("images/"+tmp+"/"+tmp+".png").getImage();
                    if(i==0) {
                        g.drawImage(classImage, 100, 80, 150, 250, this);
                    }
                    else{
                        g.drawImage(classImage,750,80,150,250,this);
                    }

        }
    }
}
