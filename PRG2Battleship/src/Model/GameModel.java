/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
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
    
    private gameState state;
    private boolean shipInCreation = false, netPlay = false;
    
    //count for ship creation, helps decide when to start with new ship
    // or to keep filling the old ship
    private int fieldCount = 0;
    private ComputerOpponent compOpponent;
    private NetworkOpponent networkOpponent;
    public Player playerOne;
    private boolean playerOneTurn = false;
    // private GameGrid gameGrid;
    private ArrayList<Ship> ships = new ArrayList<Ship>();
    private Ship ship;
    
            
    public GameModel(){
      playerOne = new Player();  
      state = gameState.SELECTING_OPPONENT;
      playerOneTurn = new Random().nextBoolean();     
      //Initialize gameGrid
      
 
    }

    public void instantiateComputerOpponent(){
      compOpponent = new ComputerOpponent();
      state = gameState.PREPARING_GRID;
    }
    
    public void instantiateNetworkOpponent(){
      networkOpponent = new NetworkOpponent();
      netPlay = true;
    }
    
    public void runGame(int length, int posX, int posY){
        switch (state){
            case PREPARING_GRID:
                if(!shipInCreation){
                    ship = new Ship(length);
                    ship.addField(posX, posY, playerOne.myGrid);
                    ships.add(ship);
                    fieldCount = length - 1;
                    shipInCreation = true;
                }
                else {
                    ship.addField(posX, posY, playerOne.myGrid);
                    fieldCount--;
                    if(fieldCount == 0)
                        //one ship finished
                        shipInCreation = false;
                }
                
                //change to play state
                if(length == -1){
                    playerOne.myGrid.addShip (ship);
                    state = gameState.PLAY;
                }
                break;
            case PLAY: 
                if(netPlay){
                    if(playerOneTurn){
                        compOpponent.oppGrid.attackField(posX, posY);
                        notifyObservers();
                    }
                    else{
                        playerOne.myGrid.attackField(posX, posY);
                    }
                }

                break;
            case FINISHED: break;
            default: break;
            
            
        }
    }

}