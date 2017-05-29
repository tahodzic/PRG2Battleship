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
public class GameModel extends Observable {
    
    public enum GameState {
        SELECTING_OPPONENT,
        PREPARING_GRID,
        PLAY,
        FINISHED
      }
    
    private GameState state;
    private boolean shipInCreation = false, netPlay = false;
    private boolean shipsComplete = false;
    
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
    private int shipLengthChosenByUser = 0;
            
    public void setShipLengthChosenByUser(int i){
        shipLengthChosenByUser = i;
    }
    
    public GameModel(){
      playerOne = new Player();  
      state = GameState.SELECTING_OPPONENT;
      playerOneTurn = new Random().nextBoolean();     
      //Initialize gameGrid
      
 
    }

    public void instantiateComputerOpponent(){
      compOpponent = new ComputerOpponent();
      state = GameState.PREPARING_GRID;
      //setChanged();
      //notifyObservers();
    }
    
    public void instantiateNetworkOpponent(){
      networkOpponent = new NetworkOpponent();
      netPlay = true;
    }
    
    public void runGame(int posX, int posY){
        switch (state){
            case PREPARING_GRID:
                if(!shipInCreation){
                    ship = new Ship(shipLengthChosenByUser);
                    ship.addField(posX, posY, playerOne.myGrid);
                    ships.add(ship);
                    fieldCount = shipLengthChosenByUser - 1;
                    shipInCreation = true;
                    GameGrid test = playerOne.myGrid;
                    setChanged();
                    notifyObservers(test);
                }
                else {
                    ship.addField(posX, posY, playerOne.myGrid);
                    fieldCount--;
                    if(fieldCount == 0)
                        //one ship finished
                        shipInCreation = false;
                }
                
                //change to play state
                if(shipLengthChosenByUser == -1){
                    playerOne.myGrid.addShip (ship);
                    state = GameState.PLAY;
                }
                break;
            case PLAY: 
                if(netPlay){
                    if(playerOneTurn){
                        compOpponent.oppGrid.attackField(posX, posY);
                        setChanged();
                        notifyObservers();
                    }
                    else{
                        compOpponent.attackField(playerOne.myGrid);
                        setChanged();
                        notifyObservers();
                        
                    }
                }

                break;
            case FINISHED: break;
            default: break;
            
            
        }
    }

    public boolean getShipsComplete() {
        return this.shipsComplete;
    }
    
    public void setShipsComplete(boolean shipsComplete) {
        this.shipsComplete = shipsComplete;
    }
    
    public GameState getState() {
        return this.state;
    }
    
    public void setState(GameState state) {
        this.state = state;
    }
    
    public int getFieldCount() {
        return this.fieldCount;
    }
}