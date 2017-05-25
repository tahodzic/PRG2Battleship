/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import Model.GameGrid;
import Model.GameModel;

/**
 *
 * @author Ueli Steimen
 */
public class Grid extends JFrame implements Observer{
    
     private final JPanel panel2 = new JPanel();
     private final JPanel panel3 = new JPanel();
     private final JPanel panel4 = new JPanel();
     private final JLabel label1 = new JLabel("Dein Spielfeld");
     private final JLabel label2 = new JLabel("Gegner Spielfeld");
     private final JButton ship1 = new JButton("1er Schiff");
     private final JButton ship2 = new JButton("2er Schiff");
     private final JButton ship3 = new JButton("3er Schiff");
     private final JButton ship4 = new JButton("4er Schiff");
     private final JButton play = new JButton("Play");
     private final JButton[][] button1 = new JButton[7][7];
     private final JButton[][] button2 = new JButton[7][7];
     private final ArrayList<JButton>[][] liste1 = new ArrayList[7][7];
     private final ArrayList<JButton>[][] liste2 = new ArrayList[7][7];
     
     
    //Linkes Spielfeld 
   /*
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
    
    //Rechtes Spielfeld
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
    */
    
  
   
    public Grid() {
         super("Grid");
         setLocationRelativeTo(null);
         int a = 1;
         int b = 1;
         for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                String s = Integer.toString(i+1).concat(Integer.toString(j+1));
                button1[i][j] = new JButton(s);
                a++;
            }
        }
         
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                panel2.add(button1[i][j]);
            }
        }
         
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                button1[i][j].setForeground(Color.BLUE);
                button1[i][j].setBackground(Color.BLUE);
            }
        }
         
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                String s = Integer.toString(i+1).concat(Integer.toString(j+1));
                button2[i][j] = new JButton(s);
                b++;
            }
        }
         
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                panel3.add(button2[i][j]);
            }
        }
         
       for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                
                button2[i][j].setForeground(Color.BLUE);
                button2[i][j].setBackground(Color.BLUE);
            }
        }
       
      /* for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                liste1[i][j].add(button1[i][j]);
                
            }
        }
        
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                
                liste2[i][j].add(button2[i][j]);
            }
        }*/
    
        setSize(800, 600);
        panel2.setLayout(new GridLayout(7,7));
        panel3.setLayout(new GridLayout(7,7));
        panel4.setLayout(new GridLayout(2,2));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        //Linkes Spielfeld
           
        
       /* 
        panel2.add(button11);       button11.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button12);       button12.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button13);       button13.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button14);       button14.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button15);       button15.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button16);       button16.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button17);       button17.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button21);       button21.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button22);       button22.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button23);       button23.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button24);       button24.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button25);       button25.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button26);       button26.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button27);       button27.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button31);       button31.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button32);       button32.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button33);       button33.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button34);       button34.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button35);       button35.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button36);       button36.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button37);       button37.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button41);       button41.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button42);       button42.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button43);       button43.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button44);       button44.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button45);       button45.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button46);       button46.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button47);       button47.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button51);       button51.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button52);       button52.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button53);       button53.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button54);       button54.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button55);       button55.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button56);       button56.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button57);       button57.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button61);       button61.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button62);       button62.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button63);       button63.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button64);       button64.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button65);       button65.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button66);       button66.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button67);       button67.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button71);       button71.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button72);       button72.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button73);       button73.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button74);       button74.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button75);       button75.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button76);       button76.setForeground(new Color(255, 255, 255, 0));
        panel2.add(button77);       button77.setForeground(new Color(255, 255, 255, 0));
        
        
        
        //Rechtes Spielfeld
       
        panel3.add(button011);      button011.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button012);      button012.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button013);      button013.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button014);      button014.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button015);      button015.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button016);      button016.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button017);      button017.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button021);      button021.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button022);      button022.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button023);      button023.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button024);      button024.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button025);      button025.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button026);      button026.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button027);      button027.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button031);      button031.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button032);      button032.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button033);      button033.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button034);      button034.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button035);      button035.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button036);      button036.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button037);      button037.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button041);      button041.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button042);      button042.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button043);      button043.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button044);      button044.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button045);      button045.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button046);      button046.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button047);      button047.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button051);      button051.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button052);      button052.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button053);      button053.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button054);      button054.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button055);      button055.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button056);      button056.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button057);      button057.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button061);      button061.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button062);      button062.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button063);      button063.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button064);      button064.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button065);      button065.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button066);      button066.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button067);      button067.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button071);      button071.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button072);      button072.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button073);      button073.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button074);      button074.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button075);      button075.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button076);      button076.setForeground(new Color(255, 255, 255, 0));
        panel3.add(button077);      button077.setForeground(new Color(255, 255, 255, 0));
        */
        panel4.add(ship1);
        panel4.add(ship2);
        panel4.add(ship3);
        panel4.add(ship4);
        
        GridBagConstraints gb = new GridBagConstraints();
        gb.weightx = 1;
        gb.weighty = 1;
        
        gb.gridx = 0;
        gb.gridy = 1;
        add(panel2, gb);
       
        gb.gridx = 2;
        gb.gridy = 1;
        add(panel3, gb);
        
        gb.gridx = 0;
        gb.gridy = 0;
        add(label1, gb);
        
        gb.gridx = 2;
        gb.gridy = 0;
        add(label2, gb);
        
        gb.gridx = 0;
        gb.gridy = 2;
        add(panel4, gb);
        
        gb.gridx = 1;
        gb.gridy = 2;
        add(play, gb);
        
        setVisible(true);
        
    }
    
    public Rectangle getPosition(JButton button){
      return button.getBounds();
    
    }
    
    
    public void addContorller( ActionListener controller){
        ship1.addActionListener(controller);
        ship2.addActionListener(controller);
        ship3.addActionListener(controller);
        ship4.addActionListener(controller);
        
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                button1[i][j].addActionListener(controller);
            }
        }
        
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                
                button2[i][j].addActionListener(controller);
            }
        }
       
        /*Spielfeld Links
        button11.addActionListener(controller);
        button12.addActionListener(controller);
        button13.addActionListener(controller);
        button14.addActionListener(controller);
        button15.addActionListener(controller);
        button16.addActionListener(controller);
        button17.addActionListener(controller);
        button21.addActionListener(controller);
        button22.addActionListener(controller);
        button23.addActionListener(controller);
        button24.addActionListener(controller);
        button25.addActionListener(controller);
        button26.addActionListener(controller);
        button27.addActionListener(controller);
        button31.addActionListener(controller);
        button32.addActionListener(controller);
        button33.addActionListener(controller);
        button34.addActionListener(controller);
        button35.addActionListener(controller);
        button36.addActionListener(controller);
        button37.addActionListener(controller);
        button41.addActionListener(controller);
        button42.addActionListener(controller);
        button43.addActionListener(controller);
        button44.addActionListener(controller);
        button45.addActionListener(controller);
        button46.addActionListener(controller);
        button47.addActionListener(controller);
        button51.addActionListener(controller);
        button52.addActionListener(controller);
        button53.addActionListener(controller);
        button54.addActionListener(controller);
        button55.addActionListener(controller);
        button56.addActionListener(controller);
        button57.addActionListener(controller);
        button61.addActionListener(controller);
        button62.addActionListener(controller);
        button63.addActionListener(controller);
        button64.addActionListener(controller);
        button65.addActionListener(controller);
        button66.addActionListener(controller);
        button67.addActionListener(controller);
        button71.addActionListener(controller);
        button72.addActionListener(controller);
        button73.addActionListener(controller);
        button74.addActionListener(controller);
        button75.addActionListener(controller);
        button76.addActionListener(controller);
        button77.addActionListener(controller);
        //Spielfeld rechts
        button011.addActionListener(controller);
        button012.addActionListener(controller);
        button013.addActionListener(controller);
        button014.addActionListener(controller);
        button015.addActionListener(controller);
        button016.addActionListener(controller);
        button017.addActionListener(controller);
        button021.addActionListener(controller);
        button022.addActionListener(controller);
        button023.addActionListener(controller);
        button024.addActionListener(controller);
        button025.addActionListener(controller);
        button026.addActionListener(controller);
        button027.addActionListener(controller);
        button031.addActionListener(controller);
        button032.addActionListener(controller);
        button033.addActionListener(controller);
        button034.addActionListener(controller);
        button035.addActionListener(controller);
        button036.addActionListener(controller);
        button037.addActionListener(controller);
        button041.addActionListener(controller);
        button042.addActionListener(controller);
        button043.addActionListener(controller);
        button044.addActionListener(controller);
        button045.addActionListener(controller);
        button046.addActionListener(controller);
        button047.addActionListener(controller);
        button051.addActionListener(controller);
        button052.addActionListener(controller);
        button053.addActionListener(controller);
        button054.addActionListener(controller);
        button055.addActionListener(controller);
        button056.addActionListener(controller);
        button057.addActionListener(controller);
        button061.addActionListener(controller);
        button062.addActionListener(controller);
        button063.addActionListener(controller);
        button064.addActionListener(controller);
        button065.addActionListener(controller);
        button066.addActionListener(controller);
        button067.addActionListener(controller);
        button071.addActionListener(controller);
        button072.addActionListener(controller);
        button073.addActionListener(controller);
        button074.addActionListener(controller);
        button075.addActionListener(controller);
        button076.addActionListener(controller);
        button077.addActionListener(controller);
        */
    }
    
    
     public static void main(String[] args) {
        Grid grid = new Grid();
    
    }

    @Override
    public void update(Observable o, Object arg) {
       GameGrid grid = (GameGrid)arg;
       int x, y;
       
       //If playerOne gamegrid
       if (grid.getPrimaryGrid()){
            for(y = 0; y < 7; y++){
                 for(x = 0; x < 7; x++){
                     switch(grid.getField(x+1,y+1).getState()){            
                         case HIT: button1[x][y].setBackground(Color.RED); 
                                   button1[x][y].setForeground(Color.RED); 
                                   break;
                         case WATER: button1[x][y].setBackground(Color.BLUE);
                                   button1[x][y].setForeground(Color.BLUE); 
                                   break;
                         case MISSED: button1[x][y].setBackground(Color.WHITE); 
                                   button1[x][y].setForeground(Color.WHITE); 
                                   break;
                         case SHIP: button1[x][y].setBackground(Color.BLACK); 
                                   button1[x][y].setForeground(Color.BLACK); 
                                   break;
                     }
                 }
            }
       }
       //If opponent game grid
       else if (!grid.getPrimaryGrid()){
            for(y = 0; y < 7; y++){
                 for(x = 0; x < 7; x++){
                     switch(grid.getField(x+1,y+1).getState()){            
                         case HIT: button2[x][y].setBackground(Color.RED); 
                                   button2[x][y].setForeground(Color.RED); 
                                   break;
                         case WATER: button2[x][y].setBackground(Color.BLUE);
                                   button2[x][y].setForeground(Color.BLUE); 
                                   break;
                         case MISSED: button2[x][y].setBackground(Color.WHITE); 
                                   button2[x][y].setForeground(Color.WHITE); 
                                   break;
                         case SHIP: button2[x][y].setBackground(Color.BLACK); 
                                   button2[x][y].setForeground(Color.BLACK); 
                                   break;
                     }
                 }
            }
       }
        
        
    }
    

   
    public void drawButtonPlaceShip(int a){
        
        
        
    }  

    
}
