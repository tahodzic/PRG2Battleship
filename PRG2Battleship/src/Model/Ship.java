/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import Model.Field.FieldState;

/**
 *
 * @author Elia Grifo
 */
public class Ship {
    
    private final int length;
    private boolean isAlive;
    private final ArrayList<Field> fields;
    private boolean fieldsSet;
    
    public Ship(int length) {
        this.isAlive = true;
        this.fieldsSet = false;
        this.length = length;
        this.fields = new ArrayList<>();
    }
    
    /**
     * Adds field to ship
     * @return Returns true if the field was added
     */
    public boolean addField(int x, int y, GameGrid g) {
        Field field = g.getField(x, y);
        if(fields.size() < length && isFieldValid(field)) {
            fields.add(field);
            field.setState(FieldState.SHIP);
            g.setIsValid(true);
            return true;
        }
        g.setIsValid(false);
        return false;
    }
    
    /**
     * Checks if field isn't already set and is next to already set fields
     * @return Returns true if the field can be set
     */
    public boolean isFieldValid(Field field) {
        int i = fields.size();
        switch(i) {
            case 0:
                if(field.isEmptyField()) {
                    return true;
                }
            break;
            case 1:
                if(fields.get(0).isNextTo(field)) {
                    return true;
                }
            break;
            default:
                if(field.isInSameLine(fields.get(0)) && field.isNextTo(fields)) {
                    return true;
                }
            break;
        }
        return false;
    }
    
    /**
     * Removes field from ship
     * @return Returns true if field was removed
     */
    public boolean removeField(int x, int y, GameGrid g) {
        Field field = g.getField(x, y);
        if(field.containsField(fields)) {
            field.setState(FieldState.WATER);
            return fields.remove(field);
        }
        return false;
    }
    
    public void removeFields() {
        for(Field field : fields) {
            fields.remove(field);
            field.setState(FieldState.WATER);
        }
    }
    
    /**
     * Goes through all fields of the ship and checks if they are hit or not
     * @return Returns true if the ship is still alive
     */
    public boolean isStillAlive() {
        for(Field field : fields) {
            if(field.getState() != FieldState.HIT) {
                return true;
            }
        }
        return false;
    }
    
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    
    public boolean getIsAlive() {
        return this.isAlive;
    }
    
    public ArrayList<Field> getFields() {
        return this.fields;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public void setFieldsSet(boolean fieldsSet) {
        this.fieldsSet = fieldsSet;
    }
    
    public boolean getFieldsSet() {
        return this.fieldsSet;
    }
    
    // For testing purpose
    public void printFields() {
        for(Field f : fields) {
            System.out.println(f.getX()+", " +f.getY());
        }
    }
    
    // For testing purpose
    public void printIsAlive() {
        System.out.println(this.isAlive);
    }
}
