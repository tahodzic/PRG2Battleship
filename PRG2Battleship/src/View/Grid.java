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
    
    public Grid() {
         super("Grid");
         setLocationRelativeTo(null);
         for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                JButton b1 = new JButton(""+(i+1)+""+(j+1));
                button1[i][j] = b1;
                panel2.add(b1);
                b1.setBackground(Color.BLUE);
                b1.setForeground(Color.BLUE);
                
                JButton b2 = new JButton(""+(i+1)+""+(j+1));
                button2[i][j] = b2;
                panel3.add(b2);
                b2.setBackground(Color.BLUE);
                b2.setForeground(Color.BLUE);
            }
        }
    
        setSize(800, 600);
        panel2.setLayout(new GridLayout(7,7));
        panel3.setLayout(new GridLayout(7,7));
        panel4.setLayout(new GridLayout(2,2));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
     
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
