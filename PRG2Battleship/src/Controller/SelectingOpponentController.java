/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GameModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Damir Hodzic
 */
public class SelectingOpponentController implements ActionListener{
    public GameModel model = new GameModel();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String ch = (e.getActionCommand());
        
        switch (ch){
        case "ComputerOpponent":   //TODO
                                model.instantiateComputerOpponent();
                                break;
        case "NetworkOpponent" :   //TODO
                                model.instantiateNetworkOpponent();
                                break;

        default:     break;
    }
    }
    

    
}
