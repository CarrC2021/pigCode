package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class PigGameState extends GameState {

    private int player0Score;
    private int player1Score;
    private int dieValue;
    private int turnID;
    private int runningTotal;

    public PigGameState(){
        turnID = 0;
        player0Score = 0;
        player1Score = 0;
        runningTotal = 0;
        dieValue = 0;
    }

    public PigGameState(PigGameState state){
        turnID = state.getTurnID();
        player0Score = state.getPlayer0Score();
        player1Score = state.getPlayer1Score();
        runningTotal = state.getRunningTotal();
        dieValue = state.getDieValue();
    }


    public int getDieValue() {
        return dieValue;
    }

    public int getPlayer0Score() {
        return player0Score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public int getTurnID() {
        return turnID;
    }

    public void setDieValue(int dieValue) {
        this.dieValue = dieValue;
    }

    public void setPlayer0Score(int player0Score) {
        this.player0Score = player0Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public void setRunningTotal(int runningTotal) {
        this.runningTotal = runningTotal;
    }

    public void setTurnID(int turnID) {
        this.turnID = turnID;
    }
}
