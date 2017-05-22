/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Ueli Steimen
 */
public class Grid extends JFrame implements ActionListener{
    
     private final JPanel panel2 = new JPanel();
     private final JPanel panel3 = new JPanel();
     private final JLabel label1 = new JLabel("Dein Spielfeld");
     private final JLabel label2 = new JLabel("Gegner Spielfeld");
     
    private final JButton button11 = new JButton("1");
    private final JButton button12 = new JButton("2");
    private final JButton button13 = new JButton("3");
    private final JButton button14 = new JButton("4");
    private final JButton button15 = new JButton("5");
    private final JButton button16 = new JButton("6");
    private final JButton button17 = new JButton("7");
    private final JButton button21 = new JButton("8");
    private final JButton button22 = new JButton("9");
    private final JButton button23 = new JButton("10");
    private final JButton button24 = new JButton("11");
    private final JButton button25 = new JButton("12");
    private final JButton button26 = new JButton("13");
    private final JButton button27 = new JButton("14");
    private final JButton button31 = new JButton("15");
    private final JButton button32 = new JButton("16");
    private final JButton button33 = new JButton("17");
    private final JButton button34 = new JButton("18");
    private final JButton button35 = new JButton("19");
    private final JButton button36 = new JButton("20");
    private final JButton button37=  new JButton("21");
    private final JButton button41=  new JButton("22");
    private final JButton button42 = new JButton("23");
    private final JButton button43 = new JButton("24");
    private final JButton button44 = new JButton("25");
    private final JButton button45 = new JButton("26");
    private final JButton button46 = new JButton("27");
    private final JButton button47 = new JButton("28");
    private final JButton button51 = new JButton("29");
    private final JButton button52 = new JButton("30");
    private final JButton button53 = new JButton("31");
    private final JButton button54 = new JButton("32");
    private final JButton button55 = new JButton("33");
    private final JButton button56 = new JButton("34");
    private final JButton button57 = new JButton("35");
    private final JButton button61 = new JButton("36");
    private final JButton button62 = new JButton("37");
    private final JButton button63 = new JButton("38");
    private final JButton button64 = new JButton("39");
    private final JButton button65 = new JButton("40");
    private final JButton button66 = new JButton("41");
    private final JButton button67 = new JButton("42");
    private final JButton button71 = new JButton("43");
    private final JButton button72 = new JButton("44");
    private final JButton button73 = new JButton("45");
    private final JButton button74 = new JButton("46");
    private final JButton button75 = new JButton("47");
    private final JButton button76 = new JButton("48");
    private final JButton button77 = new JButton("49");
    
    private final JButton button011 = new JButton("1");
    private final JButton button012 = new JButton("2");
    private final JButton button013 = new JButton("3");
    private final JButton button014 = new JButton("4");
    private final JButton button015 = new JButton("5");
    private final JButton button016 = new JButton("6");
    private final JButton button017 = new JButton("7");
    private final JButton button021 = new JButton("8");
    private final JButton button022 = new JButton("9");
    private final JButton button023 = new JButton("10");
    private final JButton button024 = new JButton("11");
    private final JButton button025 = new JButton("12");
    private final JButton button026 = new JButton("13");
    private final JButton button027 = new JButton("14");
    private final JButton button031 = new JButton("15");
    private final JButton button032 = new JButton("16");
    private final JButton button033 = new JButton("17");
    private final JButton button034 = new JButton("18");
    private final JButton button035 = new JButton("19");
    private final JButton button036 = new JButton("20");
    private final JButton button037=  new JButton("21");
    private final JButton button041=  new JButton("22");
    private final JButton button042 = new JButton("23");
    private final JButton button043 = new JButton("24");
    private final JButton button044 = new JButton("25");
    private final JButton button045 = new JButton("26");
    private final JButton button046 = new JButton("27");
    private final JButton button047 = new JButton("28");
    private final JButton button051 = new JButton("29");
    private final JButton button052 = new JButton("30");
    private final JButton button053 = new JButton("31");
    private final JButton button054 = new JButton("32");
    private final JButton button055 = new JButton("33");
    private final JButton button056 = new JButton("34");
    private final JButton button057 = new JButton("35");
    private final JButton button061 = new JButton("36");
    private final JButton button062 = new JButton("37");
    private final JButton button063 = new JButton("38");
    private final JButton button064 = new JButton("39");
    private final JButton button065 = new JButton("40");
    private final JButton button066 = new JButton("41");
    private final JButton button067 = new JButton("42");
    private final JButton button071 = new JButton("43");
    private final JButton button072 = new JButton("44");
    private final JButton button073 = new JButton("45");
    private final JButton button074 = new JButton("46");
    private final JButton button075 = new JButton("47");
    private final JButton button076 = new JButton("48");
    private final JButton button077 = new JButton("49");

    public Grid() {
        
        super("Grid");
        setSize(800, 500);
        panel2.setLayout(new GridLayout(7,7));
        panel3.setLayout(new GridLayout(7,7));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        
        panel2.add(button11);
        panel2.add(button12);
        panel2.add(button13);
        panel2.add(button14);
        panel2.add(button15);
        panel2.add(button16);
        panel2.add(button17);
        panel2.add(button21);
        panel2.add(button22);
        panel2.add(button23);
        panel2.add(button24);
        panel2.add(button25);
        panel2.add(button26);
        panel2.add(button27);
        panel2.add(button31);
        panel2.add(button32);
        panel2.add(button33);
        panel2.add(button34);
        panel2.add(button35);
        panel2.add(button36);
        panel2.add(button37);
        panel2.add(button41);
        panel2.add(button42);
        panel2.add(button43);
        panel2.add(button44);
        panel2.add(button45);
        panel2.add(button46);
        panel2.add(button47);
        panel2.add(button51);
        panel2.add(button52);
        panel2.add(button53);
        panel2.add(button54);
        panel2.add(button55);
        panel2.add(button56);
        panel2.add(button57);
        panel2.add(button61);
        panel2.add(button62);
        panel2.add(button63);
        panel2.add(button64);
        panel2.add(button65);
        panel2.add(button66);
        panel2.add(button67);
        panel2.add(button71);
        panel2.add(button72);
        panel2.add(button73);
        panel2.add(button74);
        panel2.add(button75);
        panel2.add(button76);
        panel2.add(button77);
        
        panel3.add(button011);
        panel3.add(button012);
        panel3.add(button013);
        panel3.add(button014);
        panel3.add(button015);
        panel3.add(button016);
        panel3.add(button017);
        panel3.add(button021);
        panel3.add(button022);
        panel3.add(button023);
        panel3.add(button024);
        panel3.add(button025);
        panel3.add(button026);
        panel3.add(button027);
        panel3.add(button031);
        panel3.add(button032);
        panel3.add(button033);
        panel3.add(button034);
        panel3.add(button035);
        panel3.add(button036);
        panel3.add(button037);
        panel3.add(button041);
        panel3.add(button042);
        panel3.add(button043);
        panel3.add(button044);
        panel3.add(button045);
        panel3.add(button046);
        panel3.add(button047);
        panel3.add(button051);
        panel3.add(button052);
        panel3.add(button053);
        panel3.add(button054);
        panel3.add(button055);
        panel3.add(button056);
        panel3.add(button057);
        panel3.add(button061);
        panel3.add(button062);
        panel3.add(button063);
        panel3.add(button064);
        panel3.add(button065);
        panel3.add(button066);
        panel3.add(button067);
        panel3.add(button071);
        panel3.add(button072);
        panel3.add(button073);
        panel3.add(button074);
        panel3.add(button075);
        panel3.add(button076);
        panel3.add(button077);
        
        GridBagConstraints gb = new GridBagConstraints();
        gb.weightx = 1;
        gb.weighty = 1;
        
        gb.gridx = 0;
        gb.gridy = 1;
        add(panel2, gb);
       
        gb.gridx = 1;
        gb.gridy = 1;
        add(panel3, gb);
        
        gb.gridx = 0;
        gb.gridy = 0;
        add(label1, gb);
        
        gb.gridx = 1;
        gb.gridy = 0;
        add(label2, gb);
        
        setVisible(true);
    }
    
    public Rectangle getPosition(JButton button){
      return button.getBounds();
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
     public static void main(String[] args) {
        Grid grid = new Grid();
    
    }
   
    
}
