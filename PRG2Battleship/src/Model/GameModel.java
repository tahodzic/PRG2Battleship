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
    
    public enum gameState {
        SELECTING_OPPONENT,
        PREPARING_GRID,
        PLAY,
        FINISHED
      }
    
    private gameState state;
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
        fieldCount = i;
    }
    
    public GameModel(){
      playerOne = new Player();  

      state = gameState.SELECTING_OPPONENT;
      //playerOneTurn = new Random().nextBoolean();   
      playerOneTurn = true;

      state = gameState.SELECTING_OPPONENT;
      playerOneTurn = new Random().nextBoolean();     

      //Initialize gameGrid
      
 
    }

    public void instantiateComputerOpponent(){
      compOpponent = new ComputerOpponent();
      state = gameState.PREPARING_GRID;
      //setChanged();
      //notifyObservers();
    }
    
    public void instantiateNetworkOpponent(){
      networkOpponent = new NetworkOpponent();
      netPlay = true;
    }
    
    public void setStateToPlay(){
        this.state = gameState.PLAY;
        compOpponent.oppGrid = playerOne.myGrid;
        setChanged();
        //in update method user needs to be informed
        notifyObservers(compOpponent.oppGrid);     
    }
    
    public void runGame(int posX, int posY){
        switch (state){
            case PREPARING_GRID:
                if(!shipInCreation){
                    if(shipLengthChosenByUser == 0){
                        //invalid field clicked by user
                        playerOne.myGrid.setIsValid(false);
                        setChanged();
                        //in update method user needs to be informed
                        notifyObservers(playerOne.myGrid);                        
                    }
                    else { 
                        ship = playerOne.myGrid.findShip(shipLengthChosenByUser);
                        
                        if(ship.addField(posX, posY, playerOne.myGrid)){
                     
                            ships.add(ship);
                            fieldCount = fieldCount - 1;
                            shipInCreation = true;
                            if(fieldCount == 0){
                                //one ship finished
                                shipInCreation = false;
                                ship.setFieldsSet(true);
                                shipLengthChosenByUser = 0;
                            }                                   
                            setChanged();
                            notifyObservers(playerOne.myGrid);
                        } else {
                            //invalid field clicked by user
                            playerOne.myGrid.setIsValid(false);
                            setChanged();
                            //in update method user needs to be informed
                            notifyObservers(playerOne.myGrid);
                        }
                    }
                }
                else {
                    ship = playerOne.myGrid.findShip(shipLengthChosenByUser);
                    if(ship.addField(posX, posY, playerOne.myGrid)){
                        fieldCount--;
                        if(fieldCount == 0){
                            //one ship finished
                            shipInCreation = false;
                            ship.setFieldsSet(true);
                            shipLengthChosenByUser = 0;
                            ship = null;
                        }
                        setChanged();
                        //in update method user needs to be informed
                        notifyObservers(playerOne.myGrid);
                    } else {
                        //invalid field clicked by user
                        playerOne.myGrid.setIsValid(false);
                        setChanged();
                        //in update method user needs to be informed
                        notifyObservers(playerOne.myGrid);
                    }
                }

                //change to play state
                if(shipLengthChosenByUser == -1){
                    playerOne.myGrid.addShip (ship);
                    state = gameState.PLAY;
                }

                break;
            case PLAY: 
                if(!netPlay){
                    if(playerOneTurn){
                        compOpponent.oppGrid.attackField(posX, posY);
                        playerOneTurn = false;
                        setChanged();
                        notifyObservers(compOpponent.oppGrid);
                    }
                    else{
                        compOpponent.attackField(playerOne.myGrid);
                        playerOneTurn = true;
                        setChanged();
                        notifyObservers(playerOne.myGrid);
                        
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
    
    public gameState getState() {
        return this.state;
    }
    
    public void setState(gameState state) {
        this.state = state;
    }
    
    public int getFieldCount() {
        return this.fieldCount;
    }
}
