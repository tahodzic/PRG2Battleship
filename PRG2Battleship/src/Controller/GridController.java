/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GameModel;
import View.Grid;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Elia Grifo
 */
public class GridController implements ActionListener {
    
    private static int chosenLength = 0;
    private GameModel gameModel = new GameModel();
    
    public GridController() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println();
    }
    
    public String resolveActionCommand(String string) {
        String s;
        switch(string.length()) {
            case 1 :
                s = getY(string)+""+getX(string);
            break;
            case 2 :
                s = getY(string)+""+getX(string);
            break;
            case 3 :
                s = "0"+getY(string)+""+getX(string);
            break;
            case 4 :
                s = ""+string.charAt(0);
            break;
            default:
                s = ""+string.charAt(0);
                chosenLength = string.charAt(0);
            break;
        }
        return s;
    }
    
    public void doCommand(String string) {
        String s = resolveActionCommand(string);
        int x = s.charAt(1);
                int y = s.charAt(0);
        switch(string.length()) {
            case 1 :
                if(string.equalsIgnoreCase("p")) {
                    gameModel.runGame(0, 0, 0);
                } else {
                    gameModel.runGame(chosenLength, 0, 0);
                }
            break;
            case 2 :
                gameModel.runGame(chosenLength, x, y);
            break;
            case 3 :
                gameModel.runGame(-1, x, y);
            break;
            default:
               
            break;
        }
    }
    
    public static void main(String[] args) {
        Grid g = new Grid();
        GridController gc = new GridController();
        g.addContorller(gc);
    }
    
    public int getX(String string) {
        int i = Integer.valueOf(string);
        return (i % 7 == 0) ? 7 : (i % 7);
    }
    
    public int getY(String string) {
        int i = Integer.valueOf(string);
        return (i % 7 == 0) ? (i/7) : (i/7+1);
    }
    
    public static void setChosenLength(int i) {
        chosenLength = i;
    }
    
    public static int getChosenLength() {
        return chosenLength;
    }
    
}
