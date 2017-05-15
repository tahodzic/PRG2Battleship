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
    
    public Field getField(int x, int y) {
        return gameFields[x-1][y-1];
    }
    
    public boolean addShip(Ship ship) {
        return (ships.add(ship));
    }
    
    public boolean getPrimaryGrid() {
        return this.primaryGrid;
    }
    
    
}
