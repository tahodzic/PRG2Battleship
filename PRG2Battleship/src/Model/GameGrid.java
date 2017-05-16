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
    private Ship ship1, ship2, ship3, ship4, ship5;
    
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
        addShip(ship2 = new Ship(2));
        addShip(ship3 = new Ship(2));
        addShip(ship4 = new Ship(3));
        addShip(ship5 = new Ship(4));
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
    
    public static void main(String[] args) {
    
    }
    
}
