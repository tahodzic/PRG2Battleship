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
public class Ship {
    
    private final int length;
    private boolean isAlive;
    private final ArrayList<Field> fields;
    
    public Ship(int length) {
        this.isAlive = true;
        this.length = length;
        this.fields = new ArrayList<>();
    }
    
    /**
     * Adds field to ship
     * @return Returns true if the field was added successfully
     */
    public boolean addField(Field field) {
        if(isFieldValid(field) && fields.size() < length) {
            fields.add(field);
            return true;
        }
        return false;
    }
    
    // TODO Es könnte noch ein schon benutztes
    // Feld (anderes Schiff) gewählt werden
    public boolean isFieldValid(Field field) {
        int i = fields.size();
        switch(i) {
            case 0:
                return true;
            case 1:
                if(fields.get(0).isNextTo(field)) {
                    return true;
                }
            default:
                if(field.isInSameLine(fields.get(0)) && field.isNextTo(fields)) {
                    return true;
                } else {
                    return false;
                }
        }
    }
    
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    
    public boolean getIsAlive() {
        return this.isAlive;
    }
    
    public static void main(String[] args) {
        Ship ship = new Ship(2);
        Field field1 = new Field(3,1);
        Field field2 = new Field(3,2);
        Field field3 = new Field(3,3);
        ship.addField(field1);
        ship.addField(field2);
        ship.addField(field3);
        System.out.println(ship.fields.size());
    }
}
