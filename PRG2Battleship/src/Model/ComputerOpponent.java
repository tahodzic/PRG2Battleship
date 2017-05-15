/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Damir Hodzic
 */
public class ComputerOpponent implements IOpponent{
    private GameGrid grid;
    
    public ComputerOpponent(){
        grid = new GameGrid(false);
    }
    @Override
    public void placeShip(Ship ship) {
        
    }
    
}
