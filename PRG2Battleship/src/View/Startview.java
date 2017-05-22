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

 /*
 * @author Ueli Steimen
 */
public class Startview extends JFrame {
    
    private final JPanel panel1 = new JPanel();
    private final JLabel label = new JLabel("Name: ");
    private final JLabel label2 = new JLabel("Bitte geben Sie ihren Namen ein");
    private final JTextField field = new JTextField(10);
    private final JButton button = new JButton("Netzwerk");
    private final JButton button1 = new JButton("Computer");
        
        
    public Startview(){
        super("Anmelden");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400,300);
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        
        gc.gridx = 1;
        gc.gridy = 0;
        add(label2, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        add(field, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        add(button, gc);
        
        gc.gridx = 2;
        gc.gridy = 2;
        add(button1, gc);
        
        setVisible(true);
        
        
       
    }
    
    public static void main(String[] args) {
        
        Startview n = new Startview();
       
    }
}
