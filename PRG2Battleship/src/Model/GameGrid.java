/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Elia Grifo
 */
public class GameGrid {
    
    private final Field[][] gameFields = new Field[7][7];
    private final ArrayList<Ship> ships;
    private Ship ship1, ship2, ship3, ship4, ship5, ship6, ship7, ship8, ship9, ship10;
    private boolean isValid;
    
    // true if the grid is the primary grid not the tracking/opponent grid
    private final boolean primaryGrid;
    
    public GameGrid(boolean primaryGrid) {
        this.primaryGrid = primaryGrid;
        this.ships = new ArrayList<>();
        initGrid();
        initShips();
    }  
    
    public void initGrid() {
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                gameFields[i][j] = new Field(i+1, j+1);
            }
        }
    }
    
    public void initShips() {
        addShip(ship1 = new Ship(1));
        addShip(ship2 = new Ship(1));
        addShip(ship3 = new Ship(1));
        addShip(ship4 = new Ship(1));
        addShip(ship5 = new Ship(2));
        addShip(ship6 = new Ship(2));
        addShip(ship7 = new Ship(2));
        addShip(ship8 = new Ship(3));
        addShip(ship9 = new Ship(3));
        addShip(ship10 = new Ship(4));
    }
    
    public boolean shipsComplete() {
        for(Ship ship : ships) {
            if(!ship.getFieldsSet()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean shipAvailable(int length) {
        if(this.findShip(length) == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public Ship findShip(int length) {
        for(Ship ship : ships) {
            if(ship.getLength() == length && !ship.getFieldsSet()) {
                return ship;
            }
        }
        throw new NullPointerException();
    }
    
    public boolean attackField(int x, int y) {
        Field field = this.getField(x, y);
        return field.attackField(this);
    }
    
    public Field getField(int x, int y) {
        return gameFields[x-1][y-1];
    }
    
    public boolean addShip(Ship ship) {
        return (ships.add(ship));
    }
    
    public boolean getPrimaryGrid() {
        return this.primaryGrid;
    }
    
    public boolean getIsValid() {
        return this.isValid;
    }
    
    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
    
    public Ship findShipByCoords(int x, int y) throws NullPointerException {
        Field f = this.getField(x, y);
        for(Ship ship : ships) {
            if(f.containsField(ship.getFields())) {
                return ship;
            }
        }
        throw new NullPointerException();
    }
    
    // For testing purpose
    public void printShips() {
        for(Ship ship : ships) {
            System.out.println(ship.getLength());
        }
    }
    
}
