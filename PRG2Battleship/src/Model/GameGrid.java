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
    
    // true if the grid is the primary grid not the tracking/opponent grid
    private final boolean primaryGrid;
    
    public GameGrid(boolean primaryGrid) {
        this.primaryGrid = primaryGrid;
        this.ships = new ArrayList<>();
        initializeGrid();
    }
    
    public void initializeGrid() {
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                gameFields[i][j] = new Field(i+1, j+1);
            }
        }
    }
    
    public void attackField(int x, int y) {
        Field field = this.getField(x, y);
        field.attackField(this);
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
    
    public Ship findShipByCoords(int x, int y) {
        Field f = this.getField(x, y);
        for(Ship ship : ships) {
            if(f.containsField(ship.getFields())) {
                return ship;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        GameGrid g = new GameGrid(true);
        Field f1 = g.getField(4, 4);
        Field f2 = g.getField(4, 3);
        Field f3 = g.getField(4, 6);
        Ship s = new Ship(4);
        g.addShip(s);
        s.addField(4, 4, g);
        s.addField(4, 3, g);
        s.addField(4, 2, g);
        
        f1.attackField(g);
        f2.attackField(g);
        f3.attackField(g);
        System.out.println(f1.getState());
        System.out.println(s.getIsAlive());
        
    }
    
}
