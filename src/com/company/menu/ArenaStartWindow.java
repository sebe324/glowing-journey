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
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ArenaStartWindow extends JPanel {
private List<BasePlayer> selectedClasses;
private List<JTextField> characterNames = new ArrayList<>();
ArenaStartWindow(GameMap gameMap){
    selectedClasses = new ArrayList<>(2);
    selectedClasses.add(new Warrior(0,10,"player0",gameMap));
    selectedClasses.add(new Warrior(10,10,"player1",gameMap));
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
        characterNames.add(new JTextField("player"+i));
        JLabel label = new JLabel(selectedClasses.get(i).getName());
        JLabel label3= new JLabel("Player "+i+" nickname: ");
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
                try {
                    Class player=Class.forName("com.company.classes.characters.player."+classSelect.get(tmp).getText());
                    Constructor con =player.getConstructor(int.class, int.class, String.class, GameMap.class);
                    gameMap.characterCount=tmp2;
                    selectedClasses.set(tmp2,(BasePlayer)con.newInstance(tmp2*10,10,characterNames.get(tmp2).getText(), gameMap));
                    if(gameMap.characterCount==1) gameMap.characterCount++;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                label.setText(selectedClasses.get(tmp2).getName());
                repaint();
            });
            add(classSelect.get(j));
        }
       add(label3);
        add(characterNames.get(i));
    }
    JButton start = new MenuButton("start");
    start.addActionListener(e->{
        if(selectedClasses.get(0)!=null && selectedClasses.get(1)!=null) {
            for (int i = 0; i < 2; i++) {

               selectedClasses.get(i).setName(characterNames.get(i).getText());
               gameMap.gameObjs.add(selectedClasses.get(i));
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
                    BasePlayer player = selectedClasses.get(i);
                    Image classImage=player.getImage();
                    String[] desc1=selectedClasses.get(i).getAbilityOneDescription().split(":");
                    String[] desc2=selectedClasses.get(i).getAbilityTwoDescription().split(":");
                    if(i==0) {
                        g.drawImage(classImage, 100, 80, 150, 250, this);
                        g.drawImage(player.getAbilityOneImage(), 20,485,this);
                        g.drawImage(player.getAbilityTwoImage(), 20,585,this);
                        g.drawString(desc1[0],100,540);
                        g.drawString(desc1[1],100,555);
                        g.drawString(desc2[0],100,640);
                        g.drawString(desc2[1],100,655);
                    }
                    else{
                        g.drawImage(classImage,750,80,150,250,this);
                        g.drawImage(player.getAbilityOneImage(), 550,485,this);
                        g.drawImage(player.getAbilityTwoImage(), 550,585,this);
                        g.drawString(desc1[0],630,540);
                        g.drawString(desc1[1],630,555);
                        g.drawString(desc2[0],630,640);
                        g.drawString(desc2[1],630,655);
                    }

        }
    }
}
