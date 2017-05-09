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
        if(fields.size() < length && isFieldValid(field)) {
            fields.add(field);
            field.addField(field);
            return true;
        }
        return false;
    }
    
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
    
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    
    public boolean getIsAlive() {
        return this.isAlive;
    }
    
    public static void main(String[] args) {
        Ship ship = new Ship(5);
        Ship s = new Ship(2);
        Field field1 = new Field(3,1);
        Field field2 = new Field(3,2);
        Field field3 = new Field(2,2);
        Field field4 = new Field(3,4);
        Field field5 = new Field(3,3);
        ship.addField(field1);
        ship.addField(field2);
        ship.addField(field3);
        ship.addField(field4);
        s.addField(field4);
        s.addField(field5);
        s.addField(field2);
        System.out.println(ship.fields.size());
        System.out.println(s.fields.size());
    }
}
