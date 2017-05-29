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
        String s = e.getActionCommand();
        switch (s){
            case "Computer" :
                model.instantiateComputerOpponent();
                view.dispose();
                Main.Main.grid.setVisible(true);
            break;
            case "Netzwerk" :
                model.instantiateNetworkOpponent();
                
            break;
            default :
            break;
        }
    } 
}
