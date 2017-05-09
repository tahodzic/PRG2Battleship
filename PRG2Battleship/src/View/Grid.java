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

    public Grid() {
        
        super("Grid");
        
        panel2.setLayout(new GridLayout(7,7));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel2.setPreferredSize(new Dimension(750,750));
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
        
        button11.addActionListener(this);
        button12.addActionListener(this);
        button13.addActionListener(this);
        button14.addActionListener(this);
        button15.addActionListener(this);
        button16.addActionListener(this);
        button17.addActionListener(this);
        button21.addActionListener(this);
        button22.addActionListener(this);
        button23.addActionListener(this);
        button24.addActionListener(this);
        button25.addActionListener(this);
        button26.addActionListener(this);
        button27.addActionListener(this);
        button31.addActionListener(this);
        button32.addActionListener(this);
        button33.addActionListener(this);
        button34.addActionListener(this);
        button35.addActionListener(this);
        button36.addActionListener(this);
        button37.addActionListener(this);       
        button41.addActionListener(this);
        button42.addActionListener(this);
        button43.addActionListener(this);
        button44.addActionListener(this);
        button45.addActionListener(this);
        button46.addActionListener(this);
        button47.addActionListener(this);
        button51.addActionListener(this);
        button52.addActionListener(this);
        button53.addActionListener(this);
        button54.addActionListener(this);
        button55.addActionListener(this);
        button56.addActionListener(this);
        button57.addActionListener(this);
        button61.addActionListener(this);
        button62.addActionListener(this);
        button63.addActionListener(this);
        button64.addActionListener(this);
        button65.addActionListener(this);
        button66.addActionListener(this);
        button67.addActionListener(this);
        button71.addActionListener(this);
        button72.addActionListener(this);
        button73.addActionListener(this);
        button74.addActionListener(this);
        button75.addActionListener(this);
        button76.addActionListener(this);
        button77.addActionListener(this); 
        
        add(panel2);
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
