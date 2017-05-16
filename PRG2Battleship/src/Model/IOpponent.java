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
public interface IOpponent {
    //GameGrid gameGrid = new GameGrid(7,7);
    int posX = 0, posY = 0;
    
    void attackField(int posX, int posY);
    
}
