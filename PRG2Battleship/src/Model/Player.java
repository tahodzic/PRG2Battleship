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
public class Player implements IOpponent{
    
    public GameGrid myGrid;
    
    public Player(){
        myGrid = new GameGrid(true);
    }
   
    @Override
    public void placeShip(Ship ship) {
    }
    
}
