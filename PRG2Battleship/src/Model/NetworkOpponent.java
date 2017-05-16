/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.GridController;

/**
 *
 * @author Damir Hodzic
 */
public class NetworkOpponent implements IOpponent{
    
    public NetworkOpponent(){
    NetworkOpponent server;
    GridController gameControlInstance;
    GameState gameState;
    final int LEVEL_ERROR = 1;
    final int LEVEL_NORMAL = 0;
    private ClientHandler clientHandelerPlayer1;
    private ClientHandler clientHandelerPlayer2;
    private Thread client1;
    private Thread client2;
    }
    
    @Override
    @Override
    public void attackField(int posX, int posY) {
    }
    
    public void recievedAttack(){
        
    }
}
