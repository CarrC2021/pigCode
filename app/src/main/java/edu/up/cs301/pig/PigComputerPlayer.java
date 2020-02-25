package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.utilities.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        if (info instanceof PigGameState){
            //create a new state from the given info which will change the values in the GameState
            PigGameState state = (PigGameState)info;
            //if it is the computer's turn take action
            if (playerNum == state.getTurnID()){
                if (new Random().nextInt(2) == 0){
                    PigHoldAction action = new PigHoldAction(this);
                    this.game.sendAction(action);
                }
                else{
                    PigRollAction action = new PigRollAction(this);
                    this.game.sendAction(action);
                }
            }
        }
    }//receiveInfo

}
