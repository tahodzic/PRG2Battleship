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
    public GameGrid oppGrid;
    
    public ComputerOpponent(){
        oppGrid = new GameGrid(false);
    }

    @Override
    public void attackField(int posX, int posY) {
        
    }
         
}
