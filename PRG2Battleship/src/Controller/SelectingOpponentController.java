/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GameModel;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Damir Hodzic
 */
public class SelectingOpponentController implements ActionListener{
    public GameModel model;
    private Startview view;
    
    public void addGameModel(GameModel model){
        this.model = model;
    }
    
    public void addView(Startview view){
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String ch = ((JButton)e.getSource()).getActionCommand();
        
        switch (ch){
        case "Computer":   //TODO
                                model.instantiateComputerOpponent();
                                
                                break;
        case "Netzwerk" :   //TODO
                                model.instantiateNetworkOpponent();
                                break;

        default:     break;
    }
    }
    

    
}
