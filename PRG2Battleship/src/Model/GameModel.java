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
    private ArrayList<Ship> oppShips = new ArrayList<Ship>();
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
      //playerOneTurn = new Random().nextBoolean();     

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
        playerOne.myGrid.setNumberOfShips();
        setOpponentShips(playerOne.myGrid.getNumberOfShips());
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
                        compOpponent.attackField(playerOne.myGrid);
                        playerOneTurn = true;
                        setChanged();
                        notifyObservers(playerOne.myGrid);
                        if(isDead()) {
                            state = gameState.FINISHED;
                            playerOne.myGrid.setHasLost(true);
                            setChanged();
                            notifyObservers(playerOne.myGrid);
                            
                        }
                        
                        if(isOppDead()){
                            state = gameState.FINISHED;
                            compOpponent.oppGrid.setHasLost(true);
                            setChanged();
                            notifyObservers(compOpponent.oppGrid);
                        }
                    }
                }

                break;
            case FINISHED: break;
            default: break;
            
            
        }
    }
    
    public boolean isOppDead(){
        for(Ship s: oppShips){
            if(s.isStillAlive()){
                return false;
            }
        }
        return true;
    }
    public boolean isDead(){
        for(Ship s: ships){
            if(s.isStillAlive()){
                return false;
            }
        }
        return true;
    }

    public void setOpponentShips(int numberOfShips) {
        Ship s;
        for(int i = 0; i < numberOfShips; i++) {
            do {
                int rand = random(1, 4);
                s = (getRandomShip(compOpponent.oppGrid, rand));  
            }while(!s.getFieldsSet());
            compOpponent.oppGrid.addShip(s);
            oppShips.add(s);
        }
    }
    
    public Ship getRandomShip(GameGrid g, int length) {
        int rand = random(1, 5);
        switch(length) {
            case 1:
                switch(rand) {
                    case 1:
                        Ship s1 = g.findShip(length);
                        s1.addField(2, 4, g);
                    return s1;
                    case 2:
                        Ship s2 = g.findShip(length);
                        s2.addField(6, 7, g);
                    return s2;
                    case 3:
                        Ship s3 = g.findShip(length);
                        s3.addField(2, 3, g);
                    return s3;
                    case 4:
                        Ship s4 = g.findShip(length);
                        s4.addField(5, 2, g);
                    return s4;
                    case 5:
                        Ship s5 = g.findShip(length);
                        s5.addField(3, 1, g);
                    return s5;
                }
            break;
            case 2:
               switch(rand) {
                    case 1:
                        Ship s1 = g.findShip(length);
                        s1.addField(3, 5, g);
                        s1.addField(4, 5, g);
                    return s1;
                    case 2:
                        Ship s2 = g.findShip(length);
                        s2.addField(7, 6, g);
                        s2.addField(7, 7, g);
                    return s2;
                    case 3:
                        Ship s3 = g.findShip(length);
                        s3.addField(2, 1, g);
                        s3.addField(1, 1, g);
                    return s3;
                    case 4:
                        Ship s4 = g.findShip(length);
                        s4.addField(5, 6, g);
                        s4.addField(5, 5, g);
                    return s4;
                    case 5:
                        Ship s5 = g.findShip(length);
                        s5.addField(1, 7, g);
                        s5.addField(2, 7, g);
                    return s5;
                }
            break;
            case 3:
                switch(rand) {
                    case 1:
                        Ship s1 = g.findShip(length);
                        s1.addField(4, 7, g);
                        s1.addField(4, 6, g);
                        s1.addField(4, 5, g);
                    return s1;
                    case 2:
                        Ship s2 = g.findShip(length);
                        s2.addField(2, 2, g);
                        s2.addField(3, 2, g);
                        s2.addField(4, 2, g);
                    return s2;
                    case 3:
                        Ship s3 = g.findShip(length);
                        s3.addField(6, 6, g);
                        s3.addField(5, 6, g);
                        s3.addField(4, 6, g);
                    return s3;
                    case 4:
                        Ship s4 = g.findShip(length);
                        s4.addField(3, 3, g);
                        s4.addField(3, 4, g);
                        s4.addField(3, 5, g);
                    return s4;
                    case 5:
                        Ship s5 = g.findShip(length);
                        s5.addField(6, 1, g);
                        s5.addField(5, 1, g);
                        s5.addField(4, 1, g);
                    return s5;
                }
            break;
            case 4:
                switch(rand) {
                    case 1:
                        Ship s1 = g.findShip(length);
                        s1.addField(7, 3, g);
                        s1.addField(7, 2, g);
                        s1.addField(7, 4, g);
                        s1.addField(7, 5, g);
                    return s1;
                    case 2:
                        Ship s2 = g.findShip(length);
                        s2.addField(5, 2, g);
                        s2.addField(5, 3, g);
                        s2.addField(5, 4, g);
                        s2.addField(5, 5, g);
                    return s2;
                    case 3:
                        Ship s3 = g.findShip(length);
                        s3.addField(6, 6, g);
                        s3.addField(7, 6, g);
                        s3.addField(5, 6, g);
                        s3.addField(4, 6, g);
                    return s3;
                    case 4:
                        Ship s4 = g.findShip(length);
                        s4.addField(3, 5, g);
                        s4.addField(3, 4, g);
                        s4.addField(3, 7, g);
                        s4.addField(3, 6, g);
                    return s4;
                    case 5:
                        Ship s5 = g.findShip(length);
                        s5.addField(6, 5, g);
                        s5.addField(5, 5, g);
                        s5.addField(4, 5, g);
                        s5.addField(7, 5, g);
                    return s5;
                }
            break;
        }
        throw new NullPointerException();
    }
    
    public int random(int min, int max) {
        return (int) (Math.random()*(max)+min);
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
    
    public boolean getPlayerOneTurn() {
        return this.playerOneTurn;
    }
}
