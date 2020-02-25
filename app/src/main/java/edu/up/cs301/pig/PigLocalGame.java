package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private PigGameState pigGameState;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        pigGameState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if (playerIdx == pigGameState.getTurnID()){
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if (action instanceof PigRollAction){
            Random random = new Random();
            pigGameState.setDieValue(random.nextInt((5) + 1) + 1);
            if (pigGameState.getDieValue() > 1) {
                pigGameState.setRunningTotal(pigGameState.getRunningTotal() + pigGameState.getDieValue());
            }
            else { pigGameState.setRunningTotal(0);}
            return true;
        }
        if (action instanceof PigHoldAction){
            if(pigGameState.getTurnID() == 0){
                pigGameState.setPlayer0Score(pigGameState.getPlayer0Score() + pigGameState.getRunningTotal());
                pigGameState.setTurnID(1);
            }
            else {
                pigGameState.setPlayer1Score(pigGameState.getPlayer1Score() + pigGameState.getRunningTotal());
                pigGameState.setTurnID(0);
            }

            pigGameState.setRunningTotal(0);
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState copyState = new PigGameState(pigGameState);
        p.sendInfo(copyState);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if (pigGameState.getPlayer0Score() >= 50){
            return "Player 0 has won. They won with a score of" + pigGameState.getPlayer1Score();
        }
        if (pigGameState.getPlayer1Score() >= 50){
            return "Player 1 has won. They won with a score of" + pigGameState.getPlayer1Score();
        }
        return null;
    }

}// class PigLocalGame
