/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Elia Grifo
 */
public class Ship {
    
    private final int length;
    private boolean isAlive;
    private Field[] field;
    
    public Ship(int length) {
        this.isAlive = true;
        this.length = length;
        this.field = new Field[length];
    }
    
    public void setField(int x, int y) {
        
    }
    
    public boolean isValidField() {
        
        return false;
    }
    
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
