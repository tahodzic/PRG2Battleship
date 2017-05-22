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
public class Field {
    
    public enum FieldState {WATER, SHIP, MISSED, HIT}
    
    private int x;
    private int y;
    private FieldState state;
    
    public Field(int x, int y) {
        setX(x);
        setY(y);
        setState(FieldState.WATER);
    }
    
    /**
     * Compares if two fields are next to each other and not already used
     * @return Returns true if fields are next to each other
     */
    public boolean isNextTo(Field field) {
        if(!field.isEmptyField()) {
            return false;
        }
        if(field.x == this.x && (field.y+1 == this.y || field.y-1 == this.y)) {
            return true;
        } else if(field.y == this.y && (field.x+1 == this.x || field.x-1 == this.x)) {
            return true;
        }
        return false;
    }
    
    /**
     * Compares if a field is next to a collection of fields but not already used
     * @return Returns true if field is next to one of the input fields
     */
    public boolean isNextTo(ArrayList<Field> fields) {
        for (Field field : fields) {
            if(field.isNextTo(this)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Compares if two fields are in the same line
     * @return Returns true if fields are in the same line
     */
    public boolean isInSameLine(Field field) {
        return (field.x == this.x || field.y == this.y);
    }
    
    /**
     * Compares if two fields have the same x and y coordinates
     * @return Returns true if the fields are in the same position
     */
    public boolean isSameField(Field field) {
        return (field.x == this.x && field.y == this.y);
    }
    
    /**
     * Checks if a field is already in the list
     * @return Returns true if the same field is already in the list
     */
    public boolean containsField(ArrayList<Field> fields) {
        for(Field field : fields) {
            if(this.isSameField(field)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isValidAttackField() {
        return (this.state == FieldState.WATER || this.state == FieldState.SHIP);
    }
    
    /**
     * Sets an attacked field to MISSED or HIT
     * @return Returns true if the field was valid and has been attacked
     */
    public boolean attackField(GameGrid g) {
        if(this.isValidAttackField()) {
            switch(this.state) {
                case WATER:
                    this.setState(FieldState.MISSED);
                return true;
                case SHIP:
                    this.setState(FieldState.HIT);
                    Ship ship = g.findShipByCoords(this.x, this.y);
                    if(!ship.isStillAlive()) {
                        ship.setIsAlive(false);
                    }
                return true;
            }
        }
        return false;
    }
   
    /**
     * Checks if a field is empty (not already in use)
     * @return Returns true if the field is empty
     */
    public boolean isEmptyField() {
        return (this.state == FieldState.WATER);
    }
    
    public void setState(FieldState state) {
        this.state = state;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public FieldState getState() {
        return this.state;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
}
