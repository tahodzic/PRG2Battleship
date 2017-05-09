/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Observable;
import java.util.Random;

/**
 *
 * @author Damir Hodzic
 */
public class GameModel extends Observable{
    public enum gameState{
        SELECTING_OPPONENT,
        PREPARING_GRID,
        PLAY,
        FINISHED
      }
    public gameState state;
    private IOpponent compOpponent, networkOpponent, playerOne;
    private boolean playerOneTurn = false;


    public GameModel(){
      playerOne = new Player();       
      state = gameState.SELECTING_OPPONENT;
      playerOneTurn = new Random().nextBoolean();     
      //Initialize field, per default every value is false
      
 
    }

    public void instantiateComputerOpponent(){
      compOpponent = new ComputerOpponent();
    }
    
    public void instantiateNetworkOpponent(){
      networkOpponent = new NetworkOpponent();
    }
    
    public void makeTurn()

}