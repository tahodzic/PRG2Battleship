/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Random;

/**
 *
 * @author Damir Hodzic
 */
public class ComputerOpponent implements IOpponent{
    public GameGrid oppGrid;
    Random randomnr = new Random();
    
    public ComputerOpponent(){
        oppGrid = new GameGrid(false);
    }

    @Override
    public void attackField(GameGrid g) {
        int posX = randomnr.nextInt((7))+0;
        int posY= randomnr.nextInt((7))+0;   
        g.attackField(posX, posY);
    }
}
