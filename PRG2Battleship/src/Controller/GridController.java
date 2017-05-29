/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GameModel;
import Model.GameModel.GameState;
import View.Grid;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Elia Grifo
 */
public class GridController implements ActionListener {
    
    private Grid view;
    private static int chosenLength = 0;
    private GameModel gameModel;
    private boolean primaryGrid = false;
    private boolean shipInCreation = false;
    private static int counter = 0;
    
    public GridController() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.resetLabel();
        String string = resolveClickedButton(e.getActionCommand());
        doAction(string);
    }
    
    public void doAction(String string) {
        int i = string.length();
        switch(i) {
            case 1 :
                if(!string.equals("0")) {
                    if(shipInCreation) {
                        view.setLabel("Wähle die Schiffsfelder!");
                        view.highligthLabel();
                    } else if(chosenLength == 0) {
                        chosenLength = Integer.valueOf(string);
                        shipInCreation = true;
                        gameModel.setShipLengthChosenByUser(chosenLength);
                        view.setLabel("Wähle die Schiffsfelder!");
                    } else {
                        view.setLabel("Wähle eine Schiffsgrösse!");
                        view.highligthLabel();
                    }
                } else {
                    if(gameModel.getShipsComplete()) {
                        view.displayPlayMode();
                        gameModel.setState(GameState.PLAY);
                    } else {
                        view.setLabel("Noch nicht spielbereit!");
                        view.highligthLabel();
                    }
                }
            break;
            case 2 :
                if(shipInCreation) {
                    if(!primaryGrid) {
                        view.setLabel("Falsches Spielfeld!");
                        view.highligthLabel();
                    } else {
                        gameModel.runGame(getX(string), getY(string));
                        if(gameModel.getState() == GameState.PREPARING_GRID) {
                            counter = chosenLength - gameModel.getFieldCount();
                            view.setLabel("Gesetzte Felder: " +counter+ " von "+chosenLength);
                        }
                    }
                } else {
                    view.setLabel("Wähle eine Schiffsgrösse!");
                    view.highligthLabel();
                }
            break;
        }
    }
    
    public String resolveClickedButton(String string) {
        int i = string.length();
        if(i <= 3) {    
            switch(i) {
                case 2 :
                    primaryGrid = true;
                return string;
                case 3 :
                    primaryGrid = false;
                return ""+getY(string)+""+getX(string);
                default :
                return null;
            }
        }
        if(string.equalsIgnoreCase("play")) {
            return "0";
        } else {
            return ""+string.charAt(0);
        }
    }
    
    public int getX(String string) {
        int i = Integer.valueOf(string);
        return (i % 10);
    }
    
    public int getY(String string) {
        int i = Integer.valueOf(string);
        return (i/10);
    }
    
    public static void setChosenLength(int i) {
        chosenLength = i;
    }
    
    public static int getChosenLength() {
        return chosenLength;
    }
    
    public void addGameModel(GameModel model){
        gameModel = model;
    }
    
    public void addView(Grid view){
        this.view = view;
    }
}
