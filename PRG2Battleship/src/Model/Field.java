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
    
    public int x;
    public int y;
    
    public Field(int x, int y) {
        setX(x);
        setY(y);
    }
    
    /**
     * Compares if two fields are next to each other
     * @return Returns true if fields are next to each other
     */
    public boolean isNextTo(Field field) {
        if(field.x == this.x && (field.y+1 == this.y || field.y-1 == this.y)) {
            return true;
        } else if(field.y == this.y && (field.x+1 == this.x || field.x-1 == this.x)) {
            return true;
        }
        return false;
    }
    
    /**
     * Compares if a field is next to a collection of fields
     * @return Returns true if field is next to one of the input fields
     */
    public boolean isNextTo(ArrayList<Field> fields) {
        for (Field field : fields) {
            if(this.isNextTo(field)) {
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
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}
