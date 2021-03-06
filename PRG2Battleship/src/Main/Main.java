/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Model.*;
import View.*;
import Controller.*;
/**
 *
 * @author Damir Hodzic
 */
public class Main {
    public static GridController gridController;
    public static Grid grid;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create models and view
        GameModel myModel = new GameModel();
        Startview myStartView = new Startview();
        
        myModel.addObserver(myStartView);
        
        SelectingOpponentController startController = new SelectingOpponentController();
        startController.addView(myStartView);
        startController.addGameModel(myModel);
        myStartView.addController(startController);       
        
        grid = new Grid();
        myModel.addObserver(grid);
        gridController = new GridController();
        gridController.addView(grid);
        gridController.addGameModel(myModel);
        grid.addContorller(gridController);
    }
}
