/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.Field.FieldState;
import static Model.Field.FieldState.HIT;
import static Model.Field.FieldState.MISSED;
import static Model.Field.FieldState.SHIP;
import static Model.Field.FieldState.WATER;


/**
 *
 * @author Damir Hodzic
 */
public class ComputerOpponent implements IOpponent{
    public GameGrid oppGrid;
    int treffer= 0;             //falls vorher treffer war wird auf 1 gesetzt 
    int posX=0;
    int posY=0;
    int n=1;
    FieldState f_state= WATER;
    
    public ComputerOpponent(){
        oppGrid = new GameGrid(false);
    }

    @Override
    public void attackField(GameGrid g) {  
    if(treffer==0){
        do{ 
            posX = (int) (Math.random()*(7)+1);
            posY = (int) (Math.random()*(7)+1); 
            f_state= checkfield(g, posX, posY);    
        }while(f_state!=MISSED && f_state!=HIT);  
        if(f_state==SHIP){
            treffer=1;
        }
        else{
            treffer=0;
        }
        g.attackField(posX, posY);
    }
    else{
        if (posY<9-n){
            f_state= checkfield(g, posX, posY+n);
            if(f_state!=MISSED && f_state!=HIT){
                if(f_state==SHIP){
                    treffer=1;
                    n++;
                }
                else{
                    treffer=0;
                    n=1;
                }
                g.attackField(posX, posY+1); 
            }
            else{
              f_state= checkfield(g, posX, posY-n);
                if(f_state!=MISSED && f_state!=HIT){
                    if(f_state==SHIP){
                        treffer=1;
                        n++;
                    }
                    else{
                        treffer=0;
                        n=1;
                    }
                    g.attackField(posX, posY+n); 
                }  
            }
        } 
        else{
            do{ 
            posX = (int) (Math.random()*(7)+1);
            posY = (int) (Math.random()*(7)+1); 
            f_state= checkfield(g, posX, posY);    
            }while(f_state!=MISSED && f_state!=HIT);
            if(f_state==SHIP){
                treffer=1;
            }
            else{
                treffer=0;
            }
            g.attackField(posX, posY);
        }
    }  
}
    
    public FieldState checkfield(GameGrid g, int posX, int posY){
        FieldState f_state = g.getField(posX,posY).getState();
        return f_state;
    }
}
