package com.company.menu;

import com.company.classes.characters.BaseCharacter;
import com.company.classes.characters.player.*;
import com.company.game.GameLoop;
import com.company.game.GameMap;
import com.company.styles.MenuButton;
import com.company.styles.MenuButton2;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
public class SinglePlayerStartWindow extends JPanel {
    private BasePlayer selectedClass;
    SinglePlayerStartWindow(GameMap gameMap){
        setLayout(null);
        selectedClass=new Warrior(10,10,"player0",gameMap);
        setBackground(new Color(253, 203, 110));
        Runnable r = new GameLoop(gameMap);
        JTextField characterName = new JTextField();
        characterName.setBounds(200,100,200,30);
        add(characterName);
        List<JButton> classSelect = new ArrayList<>();
        classSelect.add(new MenuButton2("Warrior"));
        classSelect.add(new MenuButton2("Gunslinger"));
        classSelect.add(new MenuButton2("Wizard"));
        classSelect.add(new MenuButton2("Healer"));
        JLabel label2 = new JLabel(selectedClass.getName());
        for(int i=0; i<classSelect.size(); i++){
            classSelect.get(i).setLocation(10,60*(i+1)+10);
            int tmp = i;
            classSelect.get(i).addActionListener(e -> {
                try {
                    Class player=Class.forName("com.company.classes.characters.player."+classSelect.get(tmp).getText());
                    Constructor con =player.getConstructor(int.class, int.class, String.class, GameMap.class);
                    gameMap.characterCount=0;
                    selectedClass=(BasePlayer)con.newInstance(tmp*10,10,characterName.getText(), gameMap);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            label2.setText(selectedClass.getName());
            repaint();
            });
            add(classSelect.get(i));
        }
        label2.setBounds(500, 50, 100,20);
        add(label2);
        JLabel label3 = new JLabel("Your nickname: ");
        label3.setBounds(200, 50, 200,30);
        add(label3);
        JLabel label4 = new JLabel("Save name: ");
        label4.setBounds(200, 150, 200,30);
        add(label4);
        JTextField saveName=new JTextField();
        saveName.setBounds(200,200,200,30);
        add(saveName);
        JButton start = new MenuButton("start");
        start.setLocation(500,880);
        start.addActionListener(e -> {
                try {
                    File file = new File("saves/"+saveName.getText()+".txt");
                    if (file.createNewFile()) {
                        gameMap.filePath = "saves/"+saveName.getText()+".txt";
                        gameMap.gameObjs.add(selectedClass);
                        gameMap.generate(10);
                        gameMap.save(gameMap.filePath);
                        gameMap.menuWindow.dispose();
                        gameMap.runWindow();
                        System.out.println("start");
                        new Thread(r).start();
                    }
                } catch (IOException er) {
                    er.printStackTrace();
                }
        });
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
                String[] desc1=selectedClass.getAbilityOneDescription().split(":");
                String[] desc2=selectedClass.getAbilityTwoDescription().split(":");
                g.drawImage(selectedClass.getImage(), 500, 80, 150, 250, this);
                g.drawImage(selectedClass.getAbilityOneImage(), 500,350,this);
                g.drawImage(selectedClass.getAbilityTwoImage(), 500,450,this);
                g.drawString(desc1[0],580,405);
                g.drawString(desc1[1],580,420);
                g.drawString(desc2[0],580,505);
                g.drawString(desc2[1],580,520);
    }
}
