package edu.up.cs301.pig;


import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;

public class PigSmartComputerPlayer extends GameComputerPlayer {

    public PigSmartComputerPlayer(String name){
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
                if (playerNum == 0) {
                    if (state.getRunningTotal() + state.getPlayer0Score() >= 50 || state.getRunningTotal() >= 26) {
                        PigHoldAction action = new PigHoldAction(this);
                        this.game.sendAction(action);
                    } else {
                        PigRollAction action = new PigRollAction(this);
                        this.game.sendAction(action);
                    }
                }
                if (playerNum == 1) {
                    if (state.getRunningTotal() + state.getPlayer1Score() >= 50 || state.getRunningTotal() >= 26) {
                        PigHoldAction action = new PigHoldAction(this);
                        this.game.sendAction(action);
                    } else {
                        PigRollAction action = new PigRollAction(this);
                        this.game.sendAction(action);
                    }
                }
            }
        }
    }//receiveInfo


}
