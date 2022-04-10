package com.company;

import com.company.classes.characters.player.Archer;
import com.company.classes.characters.player.Healer;
import com.company.classes.characters.player.Warrior;
import com.company.classes.characters.player.Wizard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static com.company.Map.things;

public class SinglePlayerStartWindow extends JFrame {
    private Map map = new Map();
    Main thread = new Main();
    private String selectedClass;
    SinglePlayerStartWindow(){
        setLocationRelativeTo(null);
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
            classSelect.get(i).addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                selectedClass=classSelect.get(tmp).getText();
                label2.setText(selectedClass);
                }
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
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch(selectedClass){
                    case "Warrior":
                          things.add(new Warrior(10,10,characterName.getText(),120,1000,1000,200,200,10, KeyEvent.VK_W,KeyEvent.VK_S,KeyEvent.VK_A,KeyEvent.VK_D,KeyEvent.VK_Q,KeyEvent.VK_E));
                          map.runWindow();
                        thread.start();
                        dispose();
                        break;
                    case "Archer":
                        things.add(new Archer(10,10,characterName.getText(),120,1000,1000,200,200,10, KeyEvent.VK_W,KeyEvent.VK_S,KeyEvent.VK_A,KeyEvent.VK_D,KeyEvent.VK_Q,KeyEvent.VK_E));
                        map.runWindow();
                        thread.start();
                        dispose();
                        break;
                    case "Wizard":
                        things.add(new Wizard(10,10,characterName.getText(),120,1000,1000,200,200,10, KeyEvent.VK_W,KeyEvent.VK_S,KeyEvent.VK_A,KeyEvent.VK_D,KeyEvent.VK_Q,KeyEvent.VK_E));
                        map.runWindow();
                        thread.start();
                        dispose();
                        break;
                    case "Healer":
                        things.add(new Healer(10,10,characterName.getText(),120,1000,1000,200,200,10, KeyEvent.VK_W,KeyEvent.VK_S,KeyEvent.VK_A,KeyEvent.VK_D,KeyEvent.VK_Q,KeyEvent.VK_E));
                        map.runWindow();
                        thread.start();
                        dispose();
                        break;
                    default:
                        label.setText("Please pick a class!");
                        break;
                }

            }
        });
        JButton close = new JButton("close");
        close.setBounds(100,0,80,20);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel panel = new JPanel();
        panel.setBounds(200,300,200,20);
        panel.add(start);
        panel.add(close);
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
